package com.example.stock.testing.read;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.stock.dto.EmployeeDto;
import com.example.stock.dto.EmployeePageDto;
import com.example.stock.service.EmployeeService;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import jakarta.transaction.Transactional;

@SpringBootTest
public class ReadEmployee {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Transactional
    @Test
    public void readAll() {
        System.out.println("readAll:");
        Pageable pageable = PageRequest.of(0, 5);
        EmployeePageDto employeePageDto = employeeService.findAll(pageable); 
        for(EmployeeDto employeeDto : employeePageDto.getEmployees()) {
            System.out.println("id: " + employeeDto.getId());
            System.out.println("name: " + employeeDto.getName());
            System.out.println("title: " + employeeDto.getTitle());
              }
    }
}

