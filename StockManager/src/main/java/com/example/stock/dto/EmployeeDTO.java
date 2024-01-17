package com.example.stock.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.example.stock.entity.Purchase;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    
    private Long id; // 員工序號
    private String name; // 員工姓名
    private String title; // 職稱
    
    private Set<PurchaseDTO> purchases = new LinkedHashSet<>();
    
}
