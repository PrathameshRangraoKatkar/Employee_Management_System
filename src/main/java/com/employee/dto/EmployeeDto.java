package com.employee.dto;



import jakarta.validation.constraints.NotNull;

public class EmployeeDto {
     
	private int id;
	@NotNull(message="Name cannot be blank")
	private String name;
	
	@NotNull(message="email cannot be blank")
	private String email;
	@NotNull(message="phone cannot be blank")
	private String phone;
	@NotNull(message="adress cannot be blank")
	private String adress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
}
