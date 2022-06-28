package com.space.lotus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.space.lotus.model.Customer;
import com.space.lotus.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/customers/{id}")
	public Customer getCustomer(@PathVariable("id") Long id ) {
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/api/v1/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/api/v1/customers/{id}")
	public void updateCustomer(@RequestBody Customer customer ,@PathVariable Long id) {
		customerService.updateCustomer(customer,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/api/v1/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}
}
