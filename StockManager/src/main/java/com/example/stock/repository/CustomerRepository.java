package com.example.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stock.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
