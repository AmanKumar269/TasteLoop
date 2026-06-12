package com.jsp.tasteloop.payment_module.service.impl;

import com.jsp.tasteloop.payment_module.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public boolean processPayment(Integer userId) {
        return true;
    }
}
