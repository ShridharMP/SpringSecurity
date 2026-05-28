package com.patil.software.solutions.custom.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.patil.software.solutions.custom.security.service.EmployeeService;

@RestController
public class CustomSecurityController {

    @Autowired
    private EmployeeService employeeService;
    // @GetMapping("/home")
    // public String home() {
    //     return "Welcome to the Home Page!";
    // }

    @GetMapping("/employee/{username}")
    public UserDetails getEmployee(@PathVariable String username) {
        try {
            return employeeService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
