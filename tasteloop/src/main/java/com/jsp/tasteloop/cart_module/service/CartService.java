package com.jsp.tasteloop.cart_module.service;

import com.jsp.tasteloop.cart_module.dto.CartRequest;
import com.jsp.tasteloop.cart_module.dto.CartResponse;
import com.jsp.tasteloop.user_module.dto.LoginRequest;
import com.jsp.tasteloop.user_module.dto.UserRequest;
import com.jsp.tasteloop.user_module.dto.UserResponse;

//createACart
//findByUserId
//addItemToCart
//Increase
//Decrease
public interface CartService {
    CartResponse createCart(CartRequest cartRequest);
    CartResponse findByUserId(Long userId);
    CartResponse addItemToCart(CartRequest cartRequest);
    CartResponse increaseItemQuantity(CartRequest cartRequest);
    CartResponse decreaseItemQuantity(CartRequest cartRequest);
}
