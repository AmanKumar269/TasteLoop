package com.jsp.tasteloop.common_module.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf-> csrf.disable())
                .formLogin(form->form.disable())
            .authorizeHttpRequests(auth->
                    auth.requestMatchers("/tasteloop/user/**").permitAll()
                            .requestMatchers("/tasteloop/restaurant/**").permitAll()
                            .requestMatchers("/tasteloop/fooditem/**").permitAll()
                            .requestMatchers("/tasteloop/cart/**").permitAll()
                    .anyRequest().authenticated());


        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
