package com.roopy.persistence.mysql.repository;

import org.springframework.data.repository.Repository;

import com.roopy.domain.Orderm;

public interface OrderRepository extends Repository<Orderm, String>, OrderRepositoryCustom {

}
