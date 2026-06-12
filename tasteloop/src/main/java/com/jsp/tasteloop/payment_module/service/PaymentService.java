package com.jsp.tasteloop.payment_module.service;

import org.springframework.stereotype.Service;


public interface PaymentService {
    boolean processPayment(Integer userId);
}
