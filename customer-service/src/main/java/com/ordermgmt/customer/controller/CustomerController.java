package com.ordermgmt.customer.controller;

import com.ordermgmt.customer.domain.Customer;
import com.ordermgmt.customer.domain.User;
import com.ordermgmt.customer.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public Customer getAccountByName(@PathVariable String name) {
		return customerService.findByCustomerId(name);
	}

	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Customer getCurrentAccount(Principal principal) {
		return customerService.findByCustomerId(principal.getName());
	}

	@RequestMapping(path = "/current", method = RequestMethod.PUT)
	public void saveCurrentAccount(Principal principal, @Valid @RequestBody Customer account) {
		customerService.saveChanges(principal.getName(), account);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Customer createNewAccount(@Valid @RequestBody User user) {
		return customerService.create(user);
	}
}
