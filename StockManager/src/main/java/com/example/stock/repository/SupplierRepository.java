package com.example.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.entity.Employee;

@Repository
public interface SupplierRepository extends JpaRepository<Employee, Long> {

}
