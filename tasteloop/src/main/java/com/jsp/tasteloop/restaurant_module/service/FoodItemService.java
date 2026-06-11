package com.jsp.tasteloop.restaurant_module.service;

import com.jsp.tasteloop.restaurant_module.dto.FoodItemRequest;
import com.jsp.tasteloop.restaurant_module.dto.FoodItemResponse;
import com.jsp.tasteloop.restaurant_module.dto.RestaurantRequest;
import com.jsp.tasteloop.restaurant_module.dto.RestaurantResponse;

import java.util.List;

//findAllFoodByRestaurantId
//addFoodItem
//Update stock
public interface FoodItemService {
    FoodItemResponse addFoodItem(FoodItemRequest foodItemRequest);
    FoodItemResponse updateStock(Integer foodItemId, Integer newStock);
    List<FoodItemResponse> foodItemByRestaurantId(Long restaurantId);
}
