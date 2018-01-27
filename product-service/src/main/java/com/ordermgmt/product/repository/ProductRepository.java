package com.ordermgmt.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ordermgmt.product.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

	

}
