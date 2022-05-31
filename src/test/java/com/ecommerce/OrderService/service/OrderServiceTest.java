package com.ecommerce.OrderService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.OrderService.entity.Order;
import com.ecommerce.OrderService.entity.OrderDto;
import com.ecommerce.OrderService.repository.OrderRepository;

@SpringBootTest(classes= {OrderServiceTest.class})
public class OrderServiceTest {

	
	@Mock
	OrderRepository orderRepo;
	
	@InjectMocks
	OrderService orderService;
	
	@Test
	public void test_createOrder() {
		
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId("order123");
		orderDto.setCartId(123);
		orderDto.setUserId(123);
		orderDto.setPaymentMethods(null);
		orderDto.setCardDetails(null);
		orderDto.setShippingAddress(null);
		
		
		Order order1= new Order();
		order1.setOrderId("order1");
		order1.setCartDetails(null);
		order1.setUserDetails(null);
		order1.setCardDetails(null);
		order1.setPaymentMethods(null);
		order1.setShippingAddress(null);
	
	when(orderRepo.insert(order1)).thenReturn(order1);
	
	assertEquals(orderDto,orderService.createOrder(orderDto));}
	
	

}
