package com.example.stock.model.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    
    private Long id; // 員工序號
    private String name; // 員工姓名
    private String title; // 職稱
    
    private Set<PurchaseDto> purchases = new LinkedHashSet<>();
    
}
