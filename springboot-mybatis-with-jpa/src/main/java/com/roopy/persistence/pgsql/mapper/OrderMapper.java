package com.roopy.persistence.pgsql.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.roopy.domain.Orderm;

@Repository
public interface OrderMapper {

	public Orderm findOrder(@Param("orderId") String orderId);
	
}
