package com.mps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee{
	private int id;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int yearOfJoining;
	double salary;
	
	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}
	
}

public class Exp4 {
	
	//1) find out count of male and female employees present in the company
	
	public static void getCountOfMaleNFemale(List<Employee> employeeList) {
		Map<String, Long> result = employeeList.stream()
				             .collect(Collectors.groupingBy(Employee :: getGender, Collectors.counting()));		
		
		System.out.println(result);
	}
	
	//2) Write a program to print the name of all departments in the company
	
	public static void getDepartmentNames(List<Employee> employeeList) {
		employeeList.stream()
		            .map(Employee :: getDepartment)
		            .distinct()
		            .forEach(System.out ::println);
	}
	
	//3) find the average age of Male and Female Employees
	public static void getAverageGenderAge(List<Employee> employeeList) {
		Map<String, Double> avgData = 
				employeeList.stream()
				            .collect(Collectors.groupingBy(Employee :: getGender,
				            		Collectors.averagingInt(Employee :: getAge)));
		
		System.out.println(avgData);
	}
	
	//4) get the name of employees who joined after 2019
	public static void getNameOfEmployees(List<Employee> employeeList) {
		employeeList.stream().filter(emp -> emp.getYearOfJoining() > 2019)
		                     .map(Employee :: getName)
		                     .forEach(System.out::println);
	}
	
	//5) count the number of employees from each department
	public static void countByDept(List<Employee> employeeList) {
		Map<String, Long> cntResult = 
				employeeList.stream()
				.collect(Collectors.groupingBy(Employee :: getDepartment,
						Collectors.counting()));
		
		cntResult.forEach((k,v)-> System.out.println(k+" "+v));
	}
	
	//6) find out the average salary each department
	public static void averageSalaryOfDept(List<Employee> employeeList) {
		Map<String, Double> result = 
				employeeList.stream()
				.collect(Collectors.groupingBy(Employee :: getDepartment,
						Collectors.averagingDouble(Employee :: getSalary)));
		
		result.forEach((k,v)-> System.out.println(k+" --> "+v));
	}
	
	//7) find out the oldest employee, his/her age and department
	public static void oldestEmployeeAgeNDept(List<Employee> employeeList) {
		Optional<Employee> oldEmp = 
				employeeList.stream()
				.max(Comparator.comparing(Employee :: getAge));
		
		Employee empData = oldEmp.get();
		
		System.out.println("Name :"+empData.getName());
		System.out.println("Age :"+empData.getAge());
		System.out.println("Department :"+empData.getDepartment());
	}
	
	//8) find out the average and total salary of the company
	public static void averageNTotalSal(List<Employee> employeesList) {
		DoubleSummaryStatistics empSalResult =
				employeesList.stream()
				.collect(Collectors.summarizingDouble(Employee :: getSalary));
		
		System.out.println("Average Salary : "+empSalResult.getAverage());
		System.out.println("Total Salary :"+empSalResult.getSum());
	}
	
	//9) list down employees from each department
	public static void listEmpFromEachDpt(List<Employee> employeesList) {
		Map<String, List<Employee>> empListDpt = 
				employeesList.stream()
				.collect(Collectors.groupingBy(Employee :: getDepartment));
		
		for(String k : empListDpt.keySet()) {
			System.out.println("Departments :: "+k);
			List<Employee> emp = empListDpt.get(k);
			
			for(Employee dt : emp) {
				System.out.println(dt);
			}
		}
	}
	
	//10) find out the highest experience employee in the company
	public static void getSeniorEmployee(List<Employee> employeesList) {
		Optional<Employee> seniorEmp = 
				employeesList.stream()
				.sorted(Comparator.comparing(Employee :: getYearOfJoining))
				.findFirst();
		
		Employee empData = seniorEmp.get();
		System.out.println("Senior Employee from the company : ");
		System.out.println("===========");
		System.out.println("ID : "+empData.getId());
		System.out.println("Age : "+empData.getAge());
		System.out.println("Name : "+empData.getName());
		
		
	}
	
	
	public static void main(String a[]) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList.add(new Employee(111, "Jyan Sarda", 32, "Male","SME", 2010, 25000.0));
		employeeList.add(new Employee(112, "Ayan Sarr", 33, "Male","SDE", 2014, 26000.0));
		employeeList.add(new Employee(113, "Lyan Sdar", 35, "Female","SDE", 2015, 27000.0));
		employeeList.add(new Employee(114, "pyan Sardr", 2, "Male","SDE", 2018, 28000.0));
		employeeList.add(new Employee(115, "Ryan Sardar", 23, "Male","HR", 2022, 29000.0));
		employeeList.add(new Employee(116, "Qyan ardar", 81, "Female","SDE", 2021, 22000.0));
		employeeList.add(new Employee(117, "Vyan dar", 67, "Male","SDE", 2023, 21000.0));
		employeeList.add(new Employee(118, "Kyan rdar", 68, "Male","SDE", 2011, 26600.0));
		employeeList.add(new Employee(119, "Syan Sardar", 12, "Female","HR", 2024, 22300.0));
		employeeList.add(new Employee(110, "Wyan ar", 78, "Male","SDE", 2025, 26700.0));
		employeeList.add(new Employee(121, "Nyan r", 56, "Male","SME", 2013, 25600.0));
		employeeList.add(new Employee(122, "Xyan Saar", 65, "Male","SDE", 2012, 27900.0));
		
		//Exp4.getCountOfMaleNFemale(employeeList);
		
		//Exp4.getDepartmentNames(employeeList);
		
		//Exp4.getAverageGenderAge(employeeList);
		
		//Exp4.getNameOfEmployees(employeeList);
		
		//Exp4.countByDept(employeeList);
		
		//Exp4.averageSalaryOfDept(employeeList);
		
		//Exp4.oldestEmployeeAgeNDept(employeeList);
		
		//Exp4.averageNTotalSal(employeeList);
		
		//Exp4.listEmpFromEachDpt(employeeList);
		
		Exp4.getSeniorEmployee(employeeList);
	}

}
