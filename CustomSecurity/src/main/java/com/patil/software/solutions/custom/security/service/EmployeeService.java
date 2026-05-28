package com.patil.software.solutions.custom.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.patil.software.solutions.custom.security.entity.Employee;
import com.patil.software.solutions.custom.security.repository.EmployeeRepository;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        if (!employee.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        if(employee.get().getUsername().equals(username)) {
            return (UserDetails) User.withUsername(employee.get().getUsername())
                    .password(employee.get().getPassword())
                    .authorities("read")
                    .build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}