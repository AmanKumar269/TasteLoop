package com.jsp.tasteloop.cart_module.service.impl;

import com.jsp.tasteloop.cart_module.dao.CartRepository;
import com.jsp.tasteloop.cart_module.dto.CartRequest;
import com.jsp.tasteloop.cart_module.dto.CartResponse;
import com.jsp.tasteloop.cart_module.model.Cart;
import com.jsp.tasteloop.cart_module.model.CartItem;
import com.jsp.tasteloop.cart_module.service.CartService;
import com.jsp.tasteloop.restaurant_module.dao.FoodItemRepository;
import com.jsp.tasteloop.restaurant_module.model.FoodItem;
import com.jsp.tasteloop.user_module.dao.UserRepository;
import com.jsp.tasteloop.user_module.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final FoodItemRepository foodItemRepository;
    @Override
    public CartResponse createCart(CartRequest cartRequest) {

        User user = userRepository.findById(cartRequest.getUserId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FoodItem foodItem = foodItemRepository.findById(cartRequest.getFoodItemId().intValue())
                .orElseThrow(() -> new RuntimeException("Food Item not found"));

        Cart cart = cartRepository.findByUser(user).orElse(null);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setItems(new ArrayList<>());
            cart.setTotalPrice(0.0);
        }

        CartItem cartItem = new CartItem();
        cartItem.setFoodItemId(foodItem.getId().longValue());
        cartItem.setFoodName(foodItem.getName());
        cartItem.setDescription(foodItem.getDescription());
        cartItem.setPrice(foodItem.getPrice());
        cartItem.setCategory(foodItem.getCategory());
        cartItem.setQuantity(1);

        cartItem.setCart(cart);
        cart.getItems().add(cartItem);

        cart.setTotalPrice(cart.getTotalPrice() + foodItem.getPrice());

        Cart savedCart = cartRepository.save(cart);

        return buildResponse(savedCart);
    }

    @Override
    public CartResponse findByUserId(Long userId) {

        User user = userRepository.findById(userId.intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        return buildResponse(cart);
    }

    @Override
    public CartResponse addItemToCart(CartRequest cartRequest) {

        User user = userRepository.findById(cartRequest.getUserId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FoodItem foodItem = foodItemRepository.findById(cartRequest.getFoodItemId().intValue())
                .orElseThrow(() -> new RuntimeException("Food Item not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartItem existingItem = null;

        for (CartItem item : cart.getItems()) {
            if (item.getFoodItemId().equals(foodItem.getId().longValue())) {
                existingItem = item;
                break;
            }
        }

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + 1);
        } else {

            CartItem cartItem = new CartItem();
            cartItem.setFoodItemId(foodItem.getId().longValue());
            cartItem.setFoodName(foodItem.getName());
            cartItem.setDescription(foodItem.getDescription());
            cartItem.setPrice(foodItem.getPrice());
            cartItem.setCategory(foodItem.getCategory());
            cartItem.setQuantity(1);

            cartItem.setCart(cart);
            cart.getItems().add(cartItem);
        }

        recalcTotal(cart);

        return buildResponse(cartRepository.save(cart));
    }

    @Override
    public CartResponse increaseItemQuantity(CartRequest cartRequest) {

        User user = userRepository.findById(cartRequest.getUserId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FoodItem foodItem = foodItemRepository.findById(cartRequest.getFoodItemId().intValue())
                .orElseThrow(() -> new RuntimeException("Food Item not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartItem item = findItem(cart, foodItem.getId().longValue());

        item.setQuantity(item.getQuantity() + 1);

        recalcTotal(cart);

        return buildResponse(cartRepository.save(cart));
    }


    @Override
    public CartResponse decreaseItemQuantity(CartRequest cartRequest) {

        User user = userRepository.findById(cartRequest.getUserId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FoodItem foodItem = foodItemRepository.findById(cartRequest.getFoodItemId().intValue())
                .orElseThrow(() -> new RuntimeException("Food Item not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartItem item = findItem(cart, foodItem.getId().longValue());

        if (item.getQuantity() > 1) {
            item.setQuantity(item.getQuantity() - 1);
        } else {
            cart.getItems().remove(item);
        }
        recalcTotal(cart);

        return buildResponse(cartRepository.save(cart));
    }


    private CartItem findItem(Cart cart, Long foodItemId) {
        return cart.getItems().stream()
                .filter(i -> i.getFoodItemId().equals(foodItemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item not found in cart"));
    }

    private void recalcTotal(Cart cart) {
        double total = 0.0;

        for (CartItem item : cart.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        cart.setTotalPrice(total);
    }
    private CartResponse buildResponse(Cart cart) {
        CartResponse response = new CartResponse();
        response.setItems(cart.getItems());
        response.setTotalPrice(cart.getTotalPrice());
        response.setQuantity(cart.getItems().size());
        return response;
    }
}