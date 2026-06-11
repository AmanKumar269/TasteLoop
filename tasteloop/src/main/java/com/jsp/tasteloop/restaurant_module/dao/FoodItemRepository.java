package com.jsp.tasteloop.restaurant_module.dao;

import com.jsp.tasteloop.restaurant_module.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    List<FoodItem> findByRestaurantRestaurantId(Long restaurantId);
}
