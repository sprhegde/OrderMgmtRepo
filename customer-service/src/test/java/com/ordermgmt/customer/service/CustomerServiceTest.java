package com.ordermgmt.customer.service;

import com.ordermgmt.customer.client.AuthServiceClient;
import com.ordermgmt.customer.domain.*;
import com.ordermgmt.customer.repository.CustomerRepository;
import com.ordermgmt.customer.service.CustomerServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private AuthServiceClient authClient;

	@Mock
	private CustomerRepository repository;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void shouldFindByName() {

		final Customer customer = new Customer();
		customer.setCustomerId("test");

		when(customerService.findByCustomerId(customer.getCustomerId())).thenReturn(customer);
		Customer found = customerService.findByCustomerId(customer.getCustomerId());

		assertEquals(customer, found);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenNameIsEmpty() {
		customerService.findByCustomerId("");
	}

	@Test
	public void shouldCreateAccountWithGivenUser() {

		User user = new User();
		user.setUsername("test");

		Customer customer = customerService.create(user);

		assertEquals(user.getUsername(), customer.getCustomerId());
		/*assertEquals(0, customer.getSaving().getAmount().intValue());
		assertEquals(Currency.getDefault(), customer.getSaving().getCurrency());
		assertEquals(0, customer.getSaving().getInterest().intValue());
		assertEquals(false, customer.getSaving().getDeposit());
		assertEquals(false, customer.getSaving().getCapitalization());*/
		assertNotNull(customer.getLastSeen());

		verify(authClient, times(1)).createUser(user);
		verify(repository, times(1)).save(customer);
	}

	@Test
	public void shouldSaveChangesWhenUpdatedAccountGiven() {

		Item grocery = new Item();
		grocery.setTitle("Grocery");
		grocery.setAmount(new BigDecimal(10));
		//grocery.setCurrency(Currency.USD);
		//grocery.setPeriod(TimePeriod.DAY);
		grocery.setIcon("meal");

		Item salary = new Item();
		salary.setTitle("Salary");
		salary.setAmount(new BigDecimal(9100));
		//salary.setCurrency(Currency.USD);
		//salary.setPeriod(TimePeriod.MONTH);
		salary.setIcon("wallet");

		//Saving saving = new Saving();
		//saving.setAmount(new BigDecimal(1500));
		//saving.setCurrency(Currency.USD);
		//saving.setInterest(new BigDecimal("3.32"));
		//saving.setDeposit(true);
		//saving.setCapitalization(false);

		final Customer update = new Customer();
		update.setCustomerId("test");
		update.setNote("test note");
		update.setIncomes(Arrays.asList(salary));
		update.setExpenses(Arrays.asList(grocery));
		//update.setSaving(saving);

		final Customer customer = new Customer();

		when(customerService.findByCustomerId("test")).thenReturn(customer);
		customerService.saveChanges("test", update);

		assertEquals(update.getNote(), customer.getNote());
		assertNotNull(customer.getLastSeen());

		/*assertEquals(update.getSaving().getAmount(), customer.getSaving().getAmount());
		assertEquals(update.getSaving().getCurrency(), customer.getSaving().getCurrency());
		assertEquals(update.getSaving().getInterest(), customer.getSaving().getInterest());
		assertEquals(update.getSaving().getDeposit(), customer.getSaving().getDeposit());
		assertEquals(update.getSaving().getCapitalization(), customer.getSaving().getCapitalization());*/

		assertEquals(update.getExpenses().size(), customer.getExpenses().size());
		assertEquals(update.getIncomes().size(), customer.getIncomes().size());

		assertEquals(update.getExpenses().get(0).getTitle(), customer.getExpenses().get(0).getTitle());
		assertEquals(0, update.getExpenses().get(0).getAmount().compareTo(customer.getExpenses().get(0).getAmount()));
		//assertEquals(update.getExpenses().get(0).getCurrency(), customer.getExpenses().get(0).getCurrency());
		//assertEquals(update.getExpenses().get(0).getPeriod(), customer.getExpenses().get(0).getPeriod());
		assertEquals(update.getExpenses().get(0).getIcon(), customer.getExpenses().get(0).getIcon());
		
		assertEquals(update.getIncomes().get(0).getTitle(), customer.getIncomes().get(0).getTitle());
		assertEquals(0, update.getIncomes().get(0).getAmount().compareTo(customer.getIncomes().get(0).getAmount()));
		//assertEquals(update.getIncomes().get(0).getCurrency(), customer.getIncomes().get(0).getCurrency());
		//assertEquals(update.getIncomes().get(0).getPeriod(), customer.getIncomes().get(0).getPeriod());
		assertEquals(update.getIncomes().get(0).getIcon(), customer.getIncomes().get(0).getIcon());
		
		verify(repository, times(1)).save(customer);
		//verify(statisticsClient, times(1)).updateStatistics("test", customer);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenNoAccountsExistedWithGivenName() {
		final Customer update = new Customer();
		update.setIncomes(Arrays.asList(new Item()));
		update.setExpenses(Arrays.asList(new Item()));

		when(customerService.findByCustomerId("test")).thenReturn(null);
		customerService.saveChanges("test", update);
	}
}
