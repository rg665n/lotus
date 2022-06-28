package com.space.lotus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.space.lotus.repository.CustomerRepository;
import com.space.lotus.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll()
		.forEach(customers::add);
		return customers;
	}
	
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void updateCustomer(Customer customer, Long id) {
		Customer _customer  = customerRepository.findById(id).orElse(null);
		if(_customer == null) {
			customerRepository.save(customer);
		}
		else {
			_customer.setBillingAddress(customer.getBillingAddress());
			_customer.setContactNumber(customer.getContactNumber());
			_customer.setGstin(customer.getGstin());
			_customer.setName(customer.getName());
			_customer.setPlaceOfSupply(customer.getPlaceOfSupply());
			_customer.setPlaceOfSupplyCode(customer.getPlaceOfSupplyCode());
			_customer.setShippingAddress(customer.getShippingAddress());
			customerRepository.save(_customer);
		}
	}
	
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
}

