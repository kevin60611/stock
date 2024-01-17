package com.example.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.dto.EmployeeDTO;
import com.example.stock.entity.Employee;
import com.example.stock.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void add(EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee();
		employee.setName(employeeDTO.getName());
		employee.setTitle(employeeDTO.getTitle());
		employeeRepository.save(employee);
	
	}
}
