package com.example.stock.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 商品序號
	
	@Column
	private String name; // 商品名稱
	
	@Column
	private Integer cost; // 商品成本
	
	@Column
	private Integer price; // 商品定價
	
	@Column
    private String unit; // 商品單位

    @Column
    private Integer minPurchaseQuantity; // 最低採購量

    @Column
    private Integer leadTime; // 進貨期
    
    @OneToMany(mappedBy = "product")
	@OrderBy("id ASC")
	private Set<PurchaseItem> purchaseItems = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "product")
	@OrderBy("id ASC")
	private Set<OrderItem> orderItems = new LinkedHashSet<>();

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", price=" + price + ", unit=" + unit
				+ ", minPurchaseQuantity=" + minPurchaseQuantity + ", leadTime=" + leadTime + "]";
	}
	
	
}
