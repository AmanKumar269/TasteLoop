package com.jsp.tasteloop.user_module.service;

import com.jsp.tasteloop.user_module.dto.LoginRequest;
import com.jsp.tasteloop.user_module.dto.UserRequest;
import com.jsp.tasteloop.user_module.dto.UserResponse;

//register
//login
//profile
//delete
//change password
public interface UserService {
    UserResponse register(UserRequest user);
    UserResponse login(LoginRequest login);
    UserResponse profile(Integer id);
    void deleteUser(Integer id);
    UserResponse changePassword(String email, String oldPassword, String newPassword);
}
