package com.example.stock.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.stock.model.dto.ProductDto;
import com.example.stock.service.ProductService;

@SpringBootTest
public class CreateProduct {
	@Autowired
	private ProductService productService;
	
	@Test
	public void addTest() {
		ProductDto p1 = new ProductDto();
		p1.setName("小熊軟糖");
		p1.setCost(5);
		p1.setPrice(15);
		p1.setUnit("顆");
		p1.setMinPurchaseQuantity(100);
		p1.setLeadTime(7);
		
		ProductDto p2 = new ProductDto();
		p2.setName("小熊餅乾");
		p2.setCost(15);
		p2.setPrice(40);
		p2.setUnit("包");
		p2.setMinPurchaseQuantity(100);
		p2.setLeadTime(7);
		
		ProductDto p3 = new ProductDto();
		p3.setName("小熊巧克力");
		p3.setCost(20);
		p3.setPrice(49);
		p1.setUnit("包");
		p1.setMinPurchaseQuantity(100);
		p1.setLeadTime(7);
		
		// 儲存
		productService.add(p1);
		productService.add(p2);
		productService.add(p3);
		
		System.out.println("Save OK !");
	}
	
}