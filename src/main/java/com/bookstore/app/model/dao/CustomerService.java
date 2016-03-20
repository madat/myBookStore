package com.bookstore.app.model.dao;

import org.springframework.stereotype.Component;

import com.bookstore.app.model.bo.Customer;

@Component
public class CustomerService {
	
	public void saveUser(Customer cust){
		System.out.println(" new user is="+cust.getName());
	}
	
	
	public Customer getUser(String userName){
		Customer cust=new Customer();
		cust.setName(userName);
		cust.setEmail(userName+"@gmail.com");
		return cust;
	}
	
	public boolean isValidLogin(String name,String pswd){
		if(name.equalsIgnoreCase("madat")&&pswd.equalsIgnoreCase("madat")){
			return true;
		}
		return false;
	}

}
