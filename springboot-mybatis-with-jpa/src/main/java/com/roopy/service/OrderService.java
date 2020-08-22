package com.roopy.service;

import com.roopy.domain.Orderm;

public interface OrderService {

	public Orderm saveOrder(String orderId) throws Exception;
	
}
