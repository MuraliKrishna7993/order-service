package com.ecommerce.OrderService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.OrderService.entity.Order;
import com.ecommerce.OrderService.entity.OrderDto;
import com.ecommerce.OrderService.service.OrderService;

@SpringBootTest(classes= {OrderControllerTest.class})
public class OrderControllerTest {
	
	@Mock
	OrderService orderService;
	
	@InjectMocks
	OrderController orderController;
	
	@Test
	public void test_saveOrder() {
		
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId("order123");
		orderDto.setCartId(123);
		orderDto.setUserId(123);
		orderDto.setPaymentMethods(null);
		orderDto.setCardDetails(null);
		orderDto.setShippingAddress(null);
		
		Order order= new Order();
		order.setOrderId("order123");
		order.setCartDetails(null);
		order.setUserDetails(null);
		order.setCardDetails(null);
		order.setPaymentMethods(null);
		order.setShippingAddress(null);
		
		when(orderService.createOrder(orderDto)).thenReturn(order);

		ResponseEntity<Order> res = orderController.saveOrder(orderDto);

		assertEquals(HttpStatus.CREATED, res.getStatusCode());

		assertEquals(order, res.getBody());

	}
	
	@Test
	public void test_getOrderByOrderId() {
		Order order= new Order();
		order.setOrderId("order123");
		order.setCartDetails(null);
		order.setUserDetails(null);
		order.setCardDetails(null);
		order.setPaymentMethods(null);
		order.setShippingAddress(null);
		
		String orderId="order123";
		
		when(orderService.getSingleOrder(orderId)).thenReturn(order);
		ResponseEntity<Order> res = orderController.getOrderByOrderId(orderId);

		assertEquals(HttpStatus.FOUND, res.getStatusCode());

		assertEquals(orderId, res.getBody().getOrderId());

	}
	
	@Test
	public void test_getOrdersByUserId() {
		
		Order order1= new Order();
		order1.setOrderId("order1");
		order1.setCartDetails(null);
		order1.setUserDetails(null);
		order1.setCardDetails(null);
		order1.setPaymentMethods(null);
		order1.setShippingAddress(null);
		
		Order order2= new Order();
		order2.setOrderId("order2");
		order2.setCartDetails(null);
		order2.setUserDetails(null);
		order2.setCardDetails(null);
		order2.setPaymentMethods(null);
		order2.setShippingAddress(null);
		
		Order order3= new Order();
		order3.setOrderId("order3");
		order3.setCartDetails(null);
		order3.setUserDetails(null);
		order3.setCardDetails(null);
		order3.setPaymentMethods(null);
		order3.setShippingAddress(null);
		
		List<Order> orders = new ArrayList<Order>();
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		Integer userId=123;
		
		
		when(orderService.getOrderByUserId(userId)).thenReturn(orders);

		ResponseEntity<List<Order>> res = orderController.getOrdersByUserId(userId);

		assertEquals(HttpStatus.FOUND, res.getStatusCode());

		assertEquals(3, res.getBody().size());
		
	}
	
	

}
