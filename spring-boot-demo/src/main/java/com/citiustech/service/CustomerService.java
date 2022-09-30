package com.citiustech.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiustech.entity.Customer;
import com.citiustech.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public void register(Customer customer) {
		//customerRepository.save(customer);
	}
	
}
