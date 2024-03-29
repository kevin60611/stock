package com.example.stock.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.model.dto.CustomerDto;
import com.example.stock.model.dto.EmployeeDto;
import com.example.stock.model.dto.OrderDto;
import com.example.stock.model.dto.OrderItemDto;
import com.example.stock.model.entity.Customer;
import com.example.stock.model.entity.Employee;
import com.example.stock.model.entity.Order;
import com.example.stock.model.entity.OrderItem;
import com.example.stock.repository.OrderItemRepository;
import com.example.stock.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// 新增
	@Transactional
	public Long add(OrderDto orderDto) {
	    Order order = modelMapper.map(orderDto, Order.class);
	    Order savedOrder = orderRepository.saveAndFlush(order);
	    return savedOrder.getId(); // 返回保存後的 ID
	}

	
	// 修改
	public void update(OrderDto orderDto, Long id) {
		Optional<Order> orderOpt = orderRepository.findById(id);
		if(orderOpt.isPresent()) {
			Order order = orderOpt.get();
			order.setDate(orderDto.getDate());
			
			EmployeeDto employeeDto = orderDto.getEmployee();
			Employee employee = modelMapper.map(employeeDto, Employee.class);
			order.setEmployee(employee);
			
			CustomerDto customerDto = orderDto.getCustomer();
			Customer customer = modelMapper.map(customerDto, Customer.class);
			order.setCustomer(customer);
			
			orderRepository.save(order);
		} 
	}
	
	// 刪除
	public void delete(Long id) {
		Optional<Order> orderOpt = orderRepository.findById(id);
		if(orderOpt.isPresent()) {
			orderRepository.delete(orderOpt.get());
		} 
	}
		
	// 查詢單筆
	public OrderDto getOrderById(Long id) {
		Optional<Order> orderOpt = orderRepository.findById(id);
		if(orderOpt.isPresent()) {
			Order order = orderOpt.get();
			OrderDto orderDto = modelMapper.map(order, OrderDto.class);
			return orderDto;
		}
		return null;
	}
	
	// 全部查詢
	public List<OrderDto> findAll() {
		List<Order> orders = orderRepository.findAll();
		return orders.stream()
						  .map(order -> modelMapper.map(order, OrderDto.class))
						  .toList();
	}
	
	//-------------------------------------------------------------------------------------
	
	// 新增訂單項目
	public void addItem(OrderItemDto orderItemDto, Long oid) {
		// 訂單明細
		OrderItem orderItem = modelMapper.map(orderItemDto, OrderItem.class);
		// 訂單檔(主檔)
		Order order = orderRepository.findById(oid).get();
		// 訂單項目與訂單檔(主檔)建立關聯 (ps:由多的一方建立關聯)
		orderItem.setOrder(order);
		orderItemRepository.save(orderItem);
	}
	
	// 查詢訂單項目單筆
	public OrderItemDto getOrderItemById(Long id) {
		Optional<OrderItem> orderItemOpt = orderItemRepository.findById(id);
		if(orderItemOpt.isPresent()) {
			OrderItem orderItem = orderItemOpt.get();
			OrderItemDto orderItemDto = modelMapper.map(orderItem, OrderItemDto.class);
			return orderItemDto;
		}
		return null;
	}
	
	// 修改訂單項目
	public void updateOrderItem(OrderItemDto orderItemDto, Long oid) {
		// 訂單明細
		OrderItem orderItem = modelMapper.map(orderItemDto, OrderItem.class);
		// 訂單檔(主檔)
		Order order = orderRepository.findById(oid).get();
		// 訂單項目與訂單檔(主檔)建立關聯 (ps:由多的一方建立關聯)
		orderItem.setOrder(order);
		orderItemRepository.save(orderItem);		
	}
	
	// 刪除訂單項目
	public void deleteOrderItem(Long iid) {
		orderItemRepository.deleteById(iid);
	}
	
	
	
}