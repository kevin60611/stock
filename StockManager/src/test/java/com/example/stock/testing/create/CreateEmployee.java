package com.example.stock.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.stock.dto.EmployeeDTO;
import com.example.stock.service.EmployeeService;

@SpringBootTest
public class CreateEmployee {
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void addTest() {
		
		EmployeeDTO emp1 = new EmployeeDTO();
        emp1.setName("胡國鴻");
        emp1.setTitle("店主"); // 設定職稱

        EmployeeDTO emp2 = new EmployeeDTO();
        emp2.setName("孫曉萳");
        emp2.setTitle("店長"); // 設定職稱

        EmployeeDTO emp3 = new EmployeeDTO();
        emp3.setName("賴玄博");
        emp3.setTitle("店員"); // 設定職稱

        EmployeeDTO emp4 = new EmployeeDTO();
        emp4.setName("文成臻");
        emp4.setTitle("店員"); // 設定職稱

        EmployeeDTO emp5 = new EmployeeDTO();
        emp5.setName("湯顧澄");
        emp5.setTitle("店員"); // 設定職稱
		
		employeeService.add(emp1);
		employeeService.add(emp2);
		employeeService.add(emp3);
		employeeService.add(emp4);
		employeeService.add(emp5);
		
		System.out.println("Save OK !");
	}
}