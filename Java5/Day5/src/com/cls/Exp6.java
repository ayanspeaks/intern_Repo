package com.cls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//using comparable and comparator sorting the data based on id, name, and age
//comparable from java.lang.*; package it is functional interface
//int compareTo(Object o);

class Customer implements Comparable<Customer>{
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	private int id;
	
	private String name;
	
	private String city;
	
	public Customer() {
		
	}
	
	public Customer(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
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

	@Override
	public int compareTo(Customer o) {
		return this.id-o.id;
	}
	
	
}
public class Exp6 {
	
	public static void main(String a[]) {
		
		List<Customer>cstList = new ArrayList<>();
		
		cstList.add(new Customer(5, "Ayan", "Kolkata"));
		cstList.add(new Customer(2, "Aya", "Kolkat"));
		cstList.add(new Customer(5, "Ay", "Kolka"));
		cstList.add(new Customer(5, "A", "Kolk"));
		cstList.add(new Customer(5, "Aa", "Kol"));
		
		Collections.sort(cstList);
		
		cstList.forEach(cst -> System.out.println(cst.getId()+" "+ cst.getName()+" "+cst.getCity()));
		
		//USING STREAM API PRINT NAMES WITH FILTER METHOD STARTS WITH CHARS
		
		cstList.stream()
		.filter(cst -> cst.getName().startsWith("D"))
		.forEach(dt -> System.out.println(dt));
		
		//using stream API for sorting the customer data
		
		cstList.parallelStream()
		.sorted(Comparator.comparing(Customer :: getName))
		.forEach(cst -> System.out.println(cst.getId()+" "+cst.getName()+" "+cst.getCity()));
		
		//create new list and store formated data
		
		List<Customer> frmtData = 
			                    cstList.stream()
			                    .sorted(Comparator.comparing(Customer :: getName))
			                    .collect(Collectors.toList());
		frmtData.forEach(cst -> System.out.println(cst.getId()+" "+cst.getName()+" "+cst.getCity()));
	}

}
