package com.jsp.tasteloop.common_module.exception;

public class RestaurantNotFound extends RuntimeException{
    public RestaurantNotFound(String message) {
        super(message);
    }
}
