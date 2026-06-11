package com.jsp.tasteloop.restaurant_module.service.impl;
import com.jsp.tasteloop.common_module.exception.RestaurantNotFound;
import com.jsp.tasteloop.restaurant_module.dao.FoodItemRepository;
import com.jsp.tasteloop.restaurant_module.dao.RestaurantRepository;
import com.jsp.tasteloop.restaurant_module.dto.FoodItemRequest;
import com.jsp.tasteloop.restaurant_module.dto.FoodItemResponse;
import com.jsp.tasteloop.restaurant_module.model.FoodItem;
import com.jsp.tasteloop.restaurant_module.model.Restaurant;
import com.jsp.tasteloop.restaurant_module.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {
    private final FoodItemRepository foodItemRepository;
    private final RestaurantRepository restaurantRepository;
    @Override
    public FoodItemResponse addFoodItem(FoodItemRequest foodItemRequest) {

        Restaurant restaurant = restaurantRepository
                .findById(foodItemRequest.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        FoodItem foodItem = new FoodItem();

        foodItem.setName(foodItemRequest.getName());
        foodItem.setDescription(foodItemRequest.getDescription());
        foodItem.setPrice(foodItemRequest.getPrice());
        foodItem.setStock(foodItemRequest.getStock());
        foodItem.setCategory(foodItemRequest.getCategory());

        foodItem.setStock_available(foodItemRequest.getStock() > 0);

        foodItem.setRestaurant(restaurant);

        FoodItem savedFoodItem = foodItemRepository.save(foodItem);

        FoodItemResponse response = new FoodItemResponse();

        response.setName(savedFoodItem.getName());
        response.setDescription(savedFoodItem.getDescription());
        response.setPrice(savedFoodItem.getPrice());
        response.setStock(savedFoodItem.getStock());
        response.setStockAvailable(savedFoodItem.getStock_available());
        response.setCategory(savedFoodItem.getCategory());

        response.setRestaurantId(savedFoodItem.getRestaurant().getRestaurantId());
        response.setRestaurantName(savedFoodItem.getRestaurant().getRestaurantName());

        return response;
    }
    @Override
    public FoodItemResponse updateStock(Integer foodItemId, Integer newStock) {

        FoodItem foodItem = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new RuntimeException("FoodItem not found"));

        // update stock
        foodItem.setStock(newStock);

        // update availability automatically
        foodItem.setStock_available(newStock > 0);

        FoodItem updatedFoodItem = foodItemRepository.save(foodItem);

        FoodItemResponse response = new FoodItemResponse();

        response.setName(updatedFoodItem.getName());
        response.setDescription(updatedFoodItem.getDescription());
        response.setPrice(updatedFoodItem.getPrice());
        response.setStock(updatedFoodItem.getStock());
        response.setStockAvailable(updatedFoodItem.getStock_available());
        response.setCategory(updatedFoodItem.getCategory());

        response.setRestaurantId(updatedFoodItem.getRestaurant().getRestaurantId());
        response.setRestaurantName(updatedFoodItem.getRestaurant().getRestaurantName());

        return response;
    }

    @Override
    public List<FoodItemResponse> foodItemByRestaurantId(Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFound("Restaurant not found"));

        List<FoodItem> foodItems =
                foodItemRepository.findByRestaurantRestaurantId(restaurantId);

        List<FoodItemResponse> responses = new ArrayList<>();

        for (FoodItem foodItem : foodItems) {

            FoodItemResponse response = new FoodItemResponse();

            response.setName(foodItem.getName());
            response.setDescription(foodItem.getDescription());
            response.setPrice(foodItem.getPrice());
            response.setStock(foodItem.getStock());
            response.setStockAvailable(foodItem.getStock_available());
            response.setCategory(foodItem.getCategory());

            response.setRestaurantId(restaurant.getRestaurantId());
            response.setRestaurantName(restaurant.getRestaurantName());

            responses.add(response);
        }

        return responses;
    }
}


