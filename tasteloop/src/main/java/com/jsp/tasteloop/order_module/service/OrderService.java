package com.jsp.tasteloop.order_module.service;

import com.jsp.tasteloop.order_module.dto.OrderResponse;
import com.jsp.tasteloop.user_module.model.User;

import java.util.List;

public interface OrderService {
    OrderResponse order(User user);
}
