package com.jsp.tasteloop.payment_module.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasteloop/payments")
public class PaymentController {
    @PostMapping("/process")
    public boolean paymentProcess(@RequestParam  Long userId) {
        return true;
    }
}
