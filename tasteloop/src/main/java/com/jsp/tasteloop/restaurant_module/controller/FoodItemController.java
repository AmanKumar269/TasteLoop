package com.jsp.tasteloop.restaurant_module.controller;

import com.jsp.tasteloop.restaurant_module.dto.FoodItemRequest;
import com.jsp.tasteloop.restaurant_module.dto.FoodItemResponse;
import com.jsp.tasteloop.restaurant_module.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasteloop/fooditem")
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodItemService foodItemService;

    @PostMapping("/add")
    public ResponseEntity<FoodItemResponse> addFoodItem(
            @RequestBody FoodItemRequest foodItemRequest) {

        FoodItemResponse response =
                foodItemService.addFoodItem(foodItemRequest);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update-stock/{foodItemId}")
    public ResponseEntity<FoodItemResponse> updateStock(
            @PathVariable Integer foodItemId,
            @RequestParam Integer newStock) {

        FoodItemResponse response =
                foodItemService.updateStock(foodItemId, newStock);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/food-items")
    public ResponseEntity<List<FoodItemResponse>> getFoodItemsByRestaurantId(
            @RequestParam Long restaurantId) {

        List<FoodItemResponse> foodItems =
                foodItemService.foodItemByRestaurantId(restaurantId);

        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

}