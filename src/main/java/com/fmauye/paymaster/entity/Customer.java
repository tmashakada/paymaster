/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fmauye.paymaster.entity;

/**
 *
 * @author F5437172
 */

public class Customer {

	private String firstName;
	private String lastName;
	private String customerId;
	private Long billedRevenue;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String customerId, Long billedRevenue) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.billedRevenue = billedRevenue;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getBilledRevenue() {
		return billedRevenue;
	}

	public void setBilledRevenue(Long billedRevenue) {
		this.billedRevenue = billedRevenue;
	}

}
