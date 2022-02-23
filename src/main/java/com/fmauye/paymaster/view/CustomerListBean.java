package com.fmauye.paymaster.view;

import com.fmauye.paymaster.entity.Customer;
import com.fmauye.paymaster.service.CustomerServiceImpl;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;



@Named
@ViewScoped
public class CustomerListBean implements Serializable {



	private List<Customer> customers;
	private List<Customer> filteredCustomerList;
	private List<Customer> selectedCustomerList;

       @Autowired
	private CustomerServiceImpl customerService;

	@PostConstruct
	public void init() {
            
            System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVn");
		customers = customerService.createRandomCustomers();
	}

	public String getTotalRevenue() {
		if (this.customers == null) {
			return "0";
		}

		Long totalRevenue = customers.stream().mapToLong(Customer::getBilledRevenue).sum();
		return new DecimalFormat("###,###.###").format(totalRevenue);
	}

	public void deleteCustomers() {
            /**
		for (Customer customer : selectedCustomerList) {
			this.customerService.deleteCustomer(customer);

			if (filteredCustomerList != null) {
				this.filteredCustomerList.remove(customer);
			}

			this.customers = customerService.getCustomers();
		}
                **/
	}

	public List<Customer> getCustomers() {
            
            System.out.println("My Datatatattata");
            customers= customerService.createRandomCustomers();
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Customer> getFilteredCustomerList() {
		return filteredCustomerList;
	}

	public void setFilteredCustomerList(List<Customer> filteredCustomerList) {
		this.filteredCustomerList = filteredCustomerList;
	}

	public List<Customer> getSelectedCustomerList() {
		return selectedCustomerList;
	}

	public void setSelectedCustomerList(List<Customer> selectedCustomerList) {
		this.selectedCustomerList = selectedCustomerList;
	}
}
