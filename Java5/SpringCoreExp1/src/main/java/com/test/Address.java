package com.test;

public class Address {
	
	private String state;
	private String cnty;
	private int pin;
	
	public Address() {
		
	}
	
	public Address(String state, String cnty, int pin) {
		this.state = state;
		this.cnty = cnty;
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCnty() {
		return cnty;
	}

	public void setCnty(String cnty) {
		this.cnty = cnty;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", cnty=" + cnty + ", pin=" + pin + "]";
	}
	
	
	
}
