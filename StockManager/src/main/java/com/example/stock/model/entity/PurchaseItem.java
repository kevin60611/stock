package com.example.stock.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchase_item")
@Getter
@Setter
public class PurchaseItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 採購項目序號
	
	@Column
	private Integer amount; // 採購數量
	
	@Column
    private String unit; // 採購單位
	
	@JoinColumn(name = "purchase_id")
	@ManyToOne
	private Purchase purchase;
	
	@JoinColumn(name = "product_id")
	@ManyToOne
	private Product product;


    @Override
	public String toString() {
		return "PurchaseItem [id=" + id + ", amount=" + amount + ", unit=" + unit + ", purchase=" + purchase
				+ ", product=" + product + "]";
	}
}
