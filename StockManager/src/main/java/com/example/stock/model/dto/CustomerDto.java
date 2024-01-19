package com.example.stock.model.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
	// 欄位資料
	private Long id; // 客戶序號
	private String name; // 客戶姓名
	private String phoneNumber; // 手機號碼
	
	private Set<OrderDto> orders = new LinkedHashSet<>();
}