package com.jsp.tasteloop.user_module.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private Long phone;
    private String email;
    private String password;
}
