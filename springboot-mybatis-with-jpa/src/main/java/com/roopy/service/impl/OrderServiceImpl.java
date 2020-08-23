package com.roopy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roopy.domain.Orderm;
import com.roopy.persistence.mysql.repository.OrderRepository;
import com.roopy.persistence.pgsql.mapper.OrderMapper;
import com.roopy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	@Transactional
	public Orderm saveOrder(String orderId) throws Exception {
		
		// 주문정보 조회
		Orderm order = orderMapper.findOrder(orderId);
		
		// 주문정보 저장
		if (null != order) {
			order = orderRepository.saveOrder(order);
		}

		return order;
	}

}
