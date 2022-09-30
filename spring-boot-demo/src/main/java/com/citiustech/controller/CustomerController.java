package com.citiustech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entity.Customer;
import com.citiustech.service.CustomerService;

import ch.qos.logback.core.status.Status;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public  String register(@RequestBody Customer customer) {
	customerService.register(customer);
	return "Customer registered successfully!";
	}
	
//	@PostMapping("/register")
//	public RegisterStatus sregister(@RequestBody Customer customer);
//	//return"Custemer Registered successfully!"
//	RegisterStatus status= new RegisterStatus();
//	status.setStatus(true);
//	status.setMessageIfAny("Registration Done!");
//	Status.setRegisteredCustomerId(0);
//	return status;
}
