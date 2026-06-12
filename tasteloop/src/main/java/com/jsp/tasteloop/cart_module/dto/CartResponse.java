package com.jsp.tasteloop.cart_module.dto;

import com.jsp.tasteloop.cart_module.model.CartItem;
import com.jsp.tasteloop.restaurant_module.model.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CartResponse {

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private double totalPrice;
    private List<CartItem> items;
}
