package com.example.psi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
	
	private Long id; // 員工序號
	private String name; // 員工姓名
	
	private DepartmentDTO department;
}