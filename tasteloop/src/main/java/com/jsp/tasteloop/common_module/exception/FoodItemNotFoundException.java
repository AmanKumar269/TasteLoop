package com.jsp.tasteloop.common_module.exception;

public class FoodItemNotFoundException extends RuntimeException {

    public FoodItemNotFoundException(String message) {
        super(message);
    }
}