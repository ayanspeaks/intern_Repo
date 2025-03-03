package com.cls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
	
}

class NameComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
public class Exp4 {
	
	public static void main(String a[]) {
		
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee(4, "Ayan", 1234));
		empList.add(new Employee(5, "Anik", 342));
		empList.add(new Employee(2, "Arnab", 423));
		empList.add(new Employee(1, "Sujay", 323));
		empList.add(new Employee(3, "Deb", 844));
		
		Iterator<Employee> itr = empList.iterator();
		
		System.out.println("Before sorting employee data");
		
		while(itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println("ID :"+emp.getId()+" Name : "+ emp.getName()+" Salary : "+emp.getSalary());
		}
		
		Collections.sort(empList);
		
		System.out.println("after sorting employee data");
		
		for(Employee emp : empList) {
			System.out.println("ID :"+emp.getId()+" Name : "+ emp.getName()+" Salary : "+emp.getSalary());
		}
		
		Collections.sort(empList, new NameComparator());
		
		System.out.println("based bane sorting data");
		
		for(Employee emp : empList) {
			System.out.println("ID :"+emp.getId()+" Name : "+ emp.getName()+" Salary : "+emp.getSalary());
		}
		
	}

}
