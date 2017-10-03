package com.ordermgmt.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ordermgmt.customer.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

	Customer findByCustomerId(String name);

}
