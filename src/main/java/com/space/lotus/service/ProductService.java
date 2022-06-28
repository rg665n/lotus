package com.space.lotus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.space.lotus.repository.ProductRepository;
import com.space.lotus.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll()
		.forEach(products::add);
		return products;
	}
	
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void updateProduct(Product product, Long id) {
		Product _product  = productRepository.findById(id).orElse(null);
		if(_product == null) {
			productRepository.save(product);
		}
		else {
			_product.setDescription(product.getDescription());
			_product.setHsn(product.getHsn());
			_product.setRate(product.getRate());
			productRepository.save(_product);
		}
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
}

