package com.space.lotus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.space.lotus.model.Product;
import com.space.lotus.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/api/v1/products/{id}")
	public Product getProduct(@PathVariable("id") Long id ) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/api/v1/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/api/v1/products/{id}")
	public void updateProduct(@RequestBody Product product ,@PathVariable Long id) {
		productService.updateProduct(product,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/api/v1/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
