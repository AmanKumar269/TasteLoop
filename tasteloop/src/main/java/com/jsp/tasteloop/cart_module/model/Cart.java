package com.jsp.tasteloop.cart_module.model;

import com.jsp.tasteloop.user_module.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @OneToOne(cascade=CascadeType.ALL)
    private User user;
    @OneToMany(cascade=CascadeType.ALL)
    private List<CartItem> items;
    private Double totalPrice;
}
