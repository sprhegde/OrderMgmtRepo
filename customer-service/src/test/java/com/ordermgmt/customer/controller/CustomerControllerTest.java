package com.ordermgmt.customer.controller;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.ordermgmt.customer.CustomerApplication;
import com.ordermgmt.customer.domain.Customer;
import com.ordermgmt.customer.domain.Item;
import com.ordermgmt.customer.domain.User;
import com.ordermgmt.customer.service.CustomerService;
import com.sun.security.auth.UserPrincipal;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = CustomerApplication.class)
@WebAppConfiguration
public class CustomerControllerTest {

	private static final ObjectMapper mapper = new ObjectMapper();

	@InjectMocks
	private CustomerController customerController;

	@Mock
	private CustomerService customerService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void shouldGetAccountByName() throws Exception {

		final Customer customer = new Customer();
		customer.setCustomerId("test");

		when(customerService.findByCustomerId(customer.getCustomerId())).thenReturn(customer);

		mockMvc.perform(get("/" + customer.getCustomerId()))
				.andExpect(jsonPath("$.name").value(customer.getCustomerId()))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldGetCurrentAccount() throws Exception {

		final Customer customer = new Customer();
		customer.setCustomerId("test");

		when(customerService.findByCustomerId(customer.getCustomerId())).thenReturn(customer);

		mockMvc.perform(get("/current").principal(new UserPrincipal(customer.getCustomerId())))
				.andExpect(jsonPath("$.name").value(customer.getCustomerId()))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldSaveCurrentAccount() throws Exception {

		//Saving saving = new Saving();
		//saving.setAmount(new BigDecimal(1500));
		//saving.setCurrency(Currency.USD);
		//saving.setInterest(new BigDecimal("3.32"));
		//saving.setDeposit(true);
		//saving.setCapitalization(false);

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

		final Customer customer = new Customer();
		customer.setCustomerId("test");
		customer.setNote("test note");
		customer.setLastSeen(new Date());
		//customer.setSaving(saving);
		customer.setExpenses(ImmutableList.of(grocery));
		customer.setIncomes(ImmutableList.of(salary));

		String json = mapper.writeValueAsString(customer);

		mockMvc.perform(put("/current").principal(new UserPrincipal(customer.getCustomerId())).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldFailOnValidationTryingToSaveCurrentAccount() throws Exception {

		final Customer customer = new Customer();
		customer.setCustomerId("test");

		String json = mapper.writeValueAsString(customer);

		mockMvc.perform(put("/current").principal(new UserPrincipal(customer.getCustomerId())).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void shouldRegisterNewAccount() throws Exception {

		final User user = new User();
		user.setUsername("test");
		user.setPassword("password");

		String json = mapper.writeValueAsString(user);
		System.out.println(json);
		mockMvc.perform(post("/").principal(new UserPrincipal("test")).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldFailOnValidationTryingToRegisterNewAccount() throws Exception {

		final User user = new User();
		user.setUsername("t");

		String json = mapper.writeValueAsString(user);

		mockMvc.perform(post("/").principal(new UserPrincipal("test")).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isBadRequest());
	}
}
