package com.ordermgmt.customer.service;

import com.ordermgmt.customer.client.AuthServiceClient;
import com.ordermgmt.customer.client.NotificationServiceClient;
import com.ordermgmt.customer.domain.Address;
import com.ordermgmt.customer.domain.Customer;
import com.ordermgmt.customer.domain.User;
import com.ordermgmt.customer.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final Logger log = LoggerFactory.getLogger(getClass());


	@Autowired
	private AuthServiceClient authClient;
	
	@Autowired
	private NotificationServiceClient notificationClient;

	@Autowired
	private CustomerRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findByCustomerId(String accountName) {
		Assert.hasLength(accountName);
		return repository.findByCustomerId(accountName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer create(User user) {

		Customer existing = repository.findByCustomerId(user.getUsername());
		Assert.isNull(existing, "account already exists: " + user.getUsername());

		authClient.createUser(user);

		
		Address address = new Address();
		address.setHouseNo(user.getHouseNo());
		address.setAddress1(user.getAddress1());
		address.setAddress2(user.getAddress2());
		address.setTelNo(user.getTelNo());
		address.setFaxNo(user.getFaxNo());

		Customer customer = new Customer();
		customer.setCustomerId(user.getUsername());
		customer.setLastSeen(new Date());
		customer.setCustomerName(user.getCustomerName());
		customer.setEmail(user.getEmail());
		customer.setAddress(address);

		repository.save(customer);

		log.info("new account has been created: " + user.getUsername());
		
		notificationClient.sendMail(user);
		
		log.info("end notificationClient method");
		
		return customer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveChanges(String name, Customer update) {

		Customer customer = repository.findByCustomerId(name);
		Assert.notNull(customer, "can't find account with name " + name);

		customer.setIncomes(update.getIncomes());
		customer.setExpenses(update.getExpenses());
		//customer.setSaving(update.getSaving());
		customer.setNote(update.getNote());
		customer.setLastSeen(new Date());
		repository.save(customer);

		log.debug("account {} changes has been saved", name);

		//statisticsClient.updateStatistics(name, customer);
	}
}
