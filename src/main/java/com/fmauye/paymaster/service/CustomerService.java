/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.service;

/**
 *
 * @author F5437172
 */

import com.fmauye.paymaster.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.springframework.stereotype.Service;

//import com.github.javafaker.Faker;



//@Singleton
//@Startup

@Service
public class CustomerService {

    
//	private List<Customer> customers;
private List<Customer> customers;
	//@PostConstruct
	//public void init() {
		//this.customers = createRandomCustomers();
	//}

	@Schedule(hour = "*", minute = "*/10", persistent = false)
	public void resetCustomers() {
		this.customers = createRandomCustomers();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void deleteCustomer(Customer customer) {
		this.customers.remove(customer);

		if (this.customers.isEmpty()) {
			this.customers = createRandomCustomers();
		}
	}

	public Customer findByCustomerId(String customerId) {
		return this.customers.stream().filter(c -> c.getCustomerId().equals(customerId)).findFirst().orElse(null);
	}

	private List<Customer> createRandomCustomers() {
		List<Customer> result = new ArrayList<>();
                //Customer customer=new Customer();
                //customer.setCustomerId(customerId);
                
		for (int i = 1; i < 100; i++) {
			//Faker faker = new Faker();
			result.add(new Customer("Tafadzwa", "Mashakada",String.valueOf(i),ThreadLocalRandom.current().nextLong(1_000_000)));
		}

		return result;
	}
}
