package com.roopy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roopy.domain.Orderm;
import com.roopy.persistence.pgsql.mapper.OrderMapper;
import com.roopy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public Orderm saveOrder(String orderId) throws Exception {
		
		// 주문정보 조회
		Orderm order = orderMapper.findOrder(orderId);

		return order;
	}

}
