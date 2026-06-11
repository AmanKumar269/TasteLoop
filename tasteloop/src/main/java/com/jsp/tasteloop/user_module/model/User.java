package com.jsp.tasteloop.user_module.model;

import com.jsp.tasteloop.restaurant_module.model.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "user-seq" , allocationSize = 1,initialValue = 1000)
    private Integer id;
    private String name;
    private Long phone;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = true)
    private boolean active;
    @OneToOne(mappedBy = "manager")
    private Restaurant restaurant;
}
