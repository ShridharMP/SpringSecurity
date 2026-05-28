package com.patil.software.solutions.custom.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.patil.software.solutions.custom.security.service.EmployeeService;

@Configuration
public class SecurityConfig {
    // @Autowired
    // private EmployeeService employeeService;

    // @Bean
    // UserDetailsService userDetailsService() {
    //     UserDetails userDetails = User.withUsername("pshridhar")
    //             .password("Password@1234")
    //             .authorities("read")
    //             .build();
    //     return new InMemoryUserDetailsManager(userDetails);
    // }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
