package com.roopy.persistence.mysql.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.roopy.domain.Orderm;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Orderm saveOrder(Orderm order) {
		return em.merge(order);
	}

}
