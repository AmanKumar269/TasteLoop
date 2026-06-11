package com.jsp.tasteloop.restaurant_module.service;

import com.jsp.tasteloop.restaurant_module.dto.RestaurantRequest;
import com.jsp.tasteloop.restaurant_module.dto.RestaurantResponse;
import com.jsp.tasteloop.restaurant_module.model.Restaurant;

import java.util.List;

//findById
//findAll by loc
//findAll by name
//findAll
//update manager
public interface RestaurantService {
    RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest);
    List<RestaurantResponse> getAllRestaurants();
    List<RestaurantResponse> getRestaurantsByLocation(String location);
    List<RestaurantResponse> getRestaurantsByName(String name);
    RestaurantResponse updateManager(Long restaurantId, Integer managerId);
    RestaurantResponse getRestaurantById(Long restaurantId);
}
