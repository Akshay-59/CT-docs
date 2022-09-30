package com.citiustech.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.citiustech.entity.Customer;

@Repository
public class CustomerRepository extends GenericRepository{

	
//	public List<Customer> fetchAll(){
//		return entityManager
//				.createQuery("select c from Customer c", Customer.class)
//				.getResultList();
//	}
}
