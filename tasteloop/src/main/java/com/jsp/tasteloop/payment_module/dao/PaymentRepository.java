package com.jsp.tasteloop.payment_module.dao;

import com.jsp.tasteloop.payment_module.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
