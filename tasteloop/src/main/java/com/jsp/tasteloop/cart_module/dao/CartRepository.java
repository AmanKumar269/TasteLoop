package com.jsp.tasteloop.cart_module.dao;

import com.jsp.tasteloop.cart_module.model.Cart;
import com.jsp.tasteloop.user_module.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
