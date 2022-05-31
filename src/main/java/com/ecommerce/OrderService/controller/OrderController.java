package com.ecommerce.OrderService.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.OrderService.entity.Order;
import com.ecommerce.OrderService.entity.OrderDto;
import com.ecommerce.OrderService.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/")
	public ResponseEntity<Order> saveOrder(@RequestBody OrderDto orderDto) {

		try {
			Order order = orderService.createOrder(orderDto);

			return new ResponseEntity<Order>(order, HttpStatus.CREATED);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Order> getOrderByOrderId(@PathVariable String orderId) {
 try {
		Order order= orderService.getSingleOrder(orderId);
		return new ResponseEntity<Order>(order,HttpStatus.FOUND);
 }catch (Exception e) {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }

	}
	
	
	
	

	@GetMapping("/{userId}")
	public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Integer userId) {
 try {
		List<Order> orders=orderService.getOrderByUserId(userId);
		return new ResponseEntity<List<Order>>(orders,HttpStatus.FOUND);
	}catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	}

}