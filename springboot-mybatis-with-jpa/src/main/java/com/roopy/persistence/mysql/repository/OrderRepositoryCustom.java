package com.roopy.persistence.mysql.repository;

import com.roopy.domain.Orderm;

public interface OrderRepositoryCustom {

	/**
	 * 주문정보 저장
	 * 
	 * @param order
	 * @return
	 */
	public Orderm saveOrder(Orderm order);
	
}
