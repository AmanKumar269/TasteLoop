package com.jsp.tasteloop.order_module.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.tasteloop.order_module.dto.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Integer userId;
    private Long paymentId;
    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    private Double totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
