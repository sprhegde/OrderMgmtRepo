package com.ordermgmt.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ordermgmt.product.domain.Product;
import com.ordermgmt.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PreAuthorize("permitAll()")
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/allproducts", method = RequestMethod.GET)
	
	public List<Product> getProduct() {
	

		return productService.findProductData();


	}
	
}
