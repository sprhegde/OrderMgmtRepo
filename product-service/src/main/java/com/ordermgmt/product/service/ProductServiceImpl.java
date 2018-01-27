package com.ordermgmt.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermgmt.product.domain.Product;
import com.ordermgmt.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> findProductData() {
		// TODO Auto-generated method stub
		return (List<Product>) repository.findAll();
	}
	
	
}
