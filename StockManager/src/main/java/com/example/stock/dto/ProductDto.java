package com.example.stock.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.example.stock.entity.PurchaseItem;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private Long id; // 商品序號
	private String name; // 商品名稱
	private Integer cost; // 商品成本
	private Integer price; // 商品定價
    private String unit; // 商品單位
    private Integer minPurchaseQuantity; // 最低採購量
    private Integer leadTime; // 進貨期
    
    private Set<PurchaseItemDto> purchaseItems = new LinkedHashSet<>();
    }
