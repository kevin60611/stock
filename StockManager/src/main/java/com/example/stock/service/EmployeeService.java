package com.example.stock.service;

import java.util.Optional;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.stock.model.dto.EmployeePageDto;
import com.example.stock.model.dto.EmployeeDto;
import com.example.stock.model.entity.Employee;
import com.example.stock.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void add(EmployeeDto employeeDto) {

		Employee employee = modelMapper.map(employeeDto, Employee.class);
//		Employee employee = new Employee();
//		employee.setName(employeeDTO.getName());
//		employee.setTitle(employeeDTO.getTitle());
		employeeRepository.save(employee);
	}
	
	// 修改
    public void update(EmployeeDto employeeDto, Long id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setName(employeeDto.getName()); // 更新員工姓名
            // 不再需要更新部門的相關邏輯
            employeeRepository.save(employee);
        }
    }

    // 刪除
    public void delete(Long id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        employeeOpt.ifPresent(employeeRepository::delete);
    }
	
    // 查詢單筆
 	public EmployeeDto getEmployeeById(Long id) {
 		Optional<Employee> employeetOpt = employeeRepository.findById(id);
 		if(employeetOpt.isPresent()) {
 			Employee employee = employeetOpt.get();
 			EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
 			return employeeDto;
 		}
 		return null;
 	}
 	
 	// 全部查詢(分頁)
 	public EmployeePageDto findAll(Pageable pageable) {
 		Page<Employee> employeePage = employeeRepository.findAll(pageable);
 		Page<EmployeeDto> employeePageDto = employeePage.map(employee -> modelMapper.map(employee, EmployeeDto.class));
 		return new EmployeePageDto(employeePageDto);
 	}
 	
 	// 全部查詢
 	public List<EmployeeDto> findAll() {
 		List<Employee> employees = employeeRepository.findAll();
 		return employees.stream()
 						  .map(employee -> modelMapper.map(employee, EmployeeDto.class))
 						  .toList();
 	}

}
