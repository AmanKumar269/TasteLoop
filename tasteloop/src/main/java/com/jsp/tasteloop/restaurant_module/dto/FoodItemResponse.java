package com.jsp.tasteloop.restaurant_module.dto;

import com.jsp.tasteloop.restaurant_module.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemResponse {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Boolean stockAvailable;
    private Category category;
    private Long restaurantId;
    private String restaurantName;
}
