package com.fls;

public class Customer {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String city;
	private transient int pinCode;
	
	public Customer() {
		
	}
	
	public Customer(int id, String name, String city, int pinCode) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.pinCode = pinCode;
	}

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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + ", pinCode=" + pinCode + "]";
	}
	

}
