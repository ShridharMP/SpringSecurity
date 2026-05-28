package com.patil.software.solutions.spring.security.SpringSecurity2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping("/greeting")
    public String getGreeting() {
        return "Hello, welcome to Spring Security!";
    }
}

