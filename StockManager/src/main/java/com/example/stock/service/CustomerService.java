package com.example.stock.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository coustomerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
}
