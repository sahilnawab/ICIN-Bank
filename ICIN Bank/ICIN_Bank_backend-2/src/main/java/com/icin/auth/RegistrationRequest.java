package com.icin.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class RegistrationRequest {

	@NotBlank(message = "First Name should not be blank")
	private String firstName;

	@NotBlank(message = "Last Name should not be blank")
	private String lastName;

	@NotBlank(message = "email should not be blank")
	@Email(message = "email is not valid")
	private String email;

	@NotBlank(message = "phone should not be blank")
	private String phone;

	@NotBlank(message = "password should not be blank")
	private String password;

//	@NotBlank(message = "age should not be blank")
	private int age;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public RegistrationRequest() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationRequest(@NotBlank(message = "First Name should not be blank") String firstName,
			@NotBlank(message = "Last Name should not be blank") String lastName,
			@NotBlank(message = "email should not be blank") @Email(message = "email is not valid") String email,
			@NotBlank(message = "phone should not be blank") String phone,
			@NotBlank(message = "password should not be blank") String password,
			@NotBlank(message = "age should not be blank") int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.age = age;
	}
	
	

}
