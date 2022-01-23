/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5437172
 */
@Service
public class CustomerServiceImpl {
    
 public  List<Customer> createRandomCustomers() {
		List<Customer> result = new ArrayList<>();
                //Customer customer=new Customer();
                //customer.setCustomerId(customerId);
                
		for (int i = 1; i < 100; i++) {
			//Faker faker = new Faker();
                        System.out.println("Bbbbb");
			result.add(new Customer("Tafadzwa", "Mashakada",String.valueOf(i),ThreadLocalRandom.current().nextLong(1_000_000)));
		}

		return result;
	}
}
