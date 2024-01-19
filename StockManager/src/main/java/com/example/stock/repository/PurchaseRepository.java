package com.example.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.model.entity.Employee;

@Repository
public interface PurchaseRepository extends JpaRepository<Employee, Long> {

}
