package com.example.stock.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.stock.dto.EmployeeDto;
import com.example.stock.service.EmployeeService;

@SpringBootTest
public class CreateEmployee {
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void addTest() {
		
		EmployeeDto emp1 = new EmployeeDto();
        emp1.setName("胡國鴻");
        emp1.setTitle("店主"); // 設定職稱

        EmployeeDto emp2 = new EmployeeDto();
        emp2.setName("孫曉萳");
        emp2.setTitle("店長"); // 設定職稱

        EmployeeDto emp3 = new EmployeeDto();
        emp3.setName("賴玄博");
        emp3.setTitle("店員"); // 設定職稱

        EmployeeDto emp4 = new EmployeeDto();
        emp4.setName("文成臻");
        emp4.setTitle("店員"); // 設定職稱

        EmployeeDto emp5 = new EmployeeDto();
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