package com.jsp.tasteloop.restaurant_module.dao;

import com.jsp.tasteloop.restaurant_module.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("select r from Restaurant r where r.address = :address")
    List<Restaurant> findByAddress(String address);

    @Query("select r from Restaurant r where r.restaurantName =:name")
    List<Restaurant> findByRestaurantName(String name);

}
