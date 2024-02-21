package com.example.spring_security.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests((req->req.
                requestMatchers("/registration").permitAll() //доступ всем
                .anyRequest().authenticated())) // авторизаваным
                .formLogin((form->form.loginPage("/login").permitAll())).logout((log->log.permitAll()));
        return httpSecurity.build();

    }
}
