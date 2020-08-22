package com.roopy.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roopy.domain.Orderm;
import com.roopy.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/order/{orderId}")
	public Orderm saveOrder(HttpServletRequest request, @PathVariable String orderId, HttpServletResponse response,
			@RequestParam HashMap<String, String> param) throws Exception {
		
		Orderm order = orderService.saveOrder(orderId);;
		
		return order;
	}
	
}
