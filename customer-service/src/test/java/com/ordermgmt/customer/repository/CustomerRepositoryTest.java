package com.ordermgmt.customer.repository;

import com.ordermgmt.customer.CustomerApplication;
import com.ordermgmt.customer.domain.*;
import com.ordermgmt.customer.repository.CustomerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = CustomerApplication.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository repository;

	@Test
	public void shouldFindAccountByName() {

		Customer stub = getStubAccount();
		repository.save(stub);

		Customer found = repository.findByCustomerId(stub.getCustomerId());
		assertEquals(stub.getLastSeen(), found.getLastSeen());
		assertEquals(stub.getNote(), found.getNote());
		assertEquals(stub.getIncomes().size(), found.getIncomes().size());
		assertEquals(stub.getExpenses().size(), found.getExpenses().size());
	}

	private Customer getStubAccount() {

		//Saving saving = new Saving();
		//saving.setAmount(new BigDecimal(1500));
		//saving.setCurrency(Currency.USD);
		//saving.setInterest(new BigDecimal("3.32"));
		//saving.setDeposit(true);
		//saving.setCapitalization(false);

		//Item vacation = new Item();
		//vacation.setTitle("Vacation");
		//vacation.setAmount(new BigDecimal(3400));
		//vacation.setCurrency(Currency.EUR);
		//vacation.setPeriod(TimePeriod.YEAR);
		//vacation.setIcon("tourism");

		//Item grocery = new Item();
		//grocery.setTitle("Grocery");
		//grocery.setAmount(new BigDecimal(10));
		//grocery.setCurrency(Currency.USD);
		//grocery.setPeriod(TimePeriod.DAY);
		//grocery.setIcon("meal");

		//Item salary = new Item();
		//salary.setTitle("Salary");
		//salary.setAmount(new BigDecimal(9100));
		//salary.setCurrency(Currency.USD);
		//salary.setPeriod(TimePeriod.MONTH);
		//salary.setIcon("wallet");

		Customer customer = new Customer();
		customer.setCustomerId("test");
		customer.setNote("test note");
		customer.setLastSeen(new Date());
		//customer.setSaving(saving);
		//customer.setExpenses(Arrays.asList(grocery, vacation));
		//customer.setIncomes(Arrays.asList(salary));

		return customer;
	}
}
