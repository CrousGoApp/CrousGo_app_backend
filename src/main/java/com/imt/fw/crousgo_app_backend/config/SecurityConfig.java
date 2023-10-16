
package com.imt.fw.crousgo_app_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        try {
            http
                    .csrf().disable()
                    .authorizeHttpRequests(authorizeHttpRequests ->
                            authorizeHttpRequests
                                    .anyRequest().permitAll()
                        
                    );
                    http.headers().frameOptions().disable();
                    
                    
            return http.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}