package com.example.stock.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDto {
	private Long id; // 供應商序號
	private String name; // 供應商名稱
	private String contactPerson; // 聯絡人
	private String contactNumber; // 聯繫方式
	
	private Set<PurchaseDto> purchases = new LinkedHashSet<>();
}