package com.example.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.model.entity.Product;
import com.example.stock.model.vo.Inventory;
import com.example.stock.model.vo.ProductSales;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(nativeQuery = true, value = "select p.id, p.name, p.cost, p.price, p.unit, "
			+ "(select sum(amount) from purchase_item where product_id = p.id limit 1) as amount1, "
			+ "(select sum(amount) from order_item where product_id = p.id limit 1) as amount2 "
			+ "from product p")
	List<Inventory> queryInventory();
	
	@Query(nativeQuery = true, value = "select p.id, p.name, p.cost, p.price, p.unit, "
			+ "(select sum(amount) from purchase_item where product_id = p.id limit 1) as amount1, "
			+ "(select sum(amount) from order_item where product_id = p.id limit 1) as amount2 "
			+ "from product p where p.id=:id ")
	Inventory findInventoryById(Long id);
	
	@Query(nativeQuery = true, value = "select p.id, p.name, sum(o.amount) as total "
			+ "from order_item o, product p "
			+ "where o.product_id = p.id "
			+ "group by p.id, p.name ")
	List<ProductSales> queryProductSales(); 
}