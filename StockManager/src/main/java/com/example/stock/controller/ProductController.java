package com.example.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stock.model.dto.ProductDto;
import com.example.stock.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String index(@ModelAttribute ProductDto productDto, Model model) {
		List<ProductDto> productDtos = productService.findAll();
		model.addAttribute("productDtos", productDtos);
		model.addAttribute("productDto", productDto);
		return "product";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		ProductDto productDto = productService.getProductById(id);
		model.addAttribute("productDto", productDto);
		return "product-edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		productService.delete(id);
		return "redirect:/product/";
	}
	
	@PostMapping("/")
	public String add(ProductDto productDto) {
		productService.add(productDto);
		return "redirect:/product/";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, ProductDto productDto) {
		productService.update(productDto, id);
		return "redirect:/product/";
	}
	
}