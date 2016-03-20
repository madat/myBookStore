package com.bookstore.app.model.bo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	
	@NotNull
	@Size(min=5)
	private String name;
	
	@NotNull
	private String email;

	private String firstName;

	private String lastName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
