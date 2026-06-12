package com.jsp.tasteloop.order_module.controller;

import com.jsp.tasteloop.order_module.dto.OrderResponse;
import com.jsp.tasteloop.order_module.service.OrderService;
import com.jsp.tasteloop.user_module.dao.UserRepository;
import com.jsp.tasteloop.user_module.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasteloop/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserRepository userRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<OrderResponse> placeOrder(
            @PathVariable Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        OrderResponse response = orderService.order(user);

        return ResponseEntity.ok(response);
    }
}