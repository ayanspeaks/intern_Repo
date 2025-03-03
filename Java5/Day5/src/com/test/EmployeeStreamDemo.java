package com.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int age;
    String gender;
    int yoj; // Year of Joining
    double salary;

    public Employee(int id, String name, int age, String gender, int yoj, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.yoj = yoj;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id && yoj == employee.yoj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yoj);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", yoj=" + yoj +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeStreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
        		new Employee(105, "Ayan", 23, "Male", 2018, 54000),
                new Employee(104, "Bhusan", 25, "Male", 2021, 62000),
                new Employee(103, "Chirag", 28, "Male", 2019, 55000),
                new Employee(102, "Sohani", 40, "Female", 2022, 75490),
                new Employee(101, "Adway", 21, "Male", 2023, 69990),
                new Employee(104, "Bhusan", 25, "Male", 2021, 62000),
                new Employee(102, "Sohani", 40, "Female", 2022, 75490)
        );
        
        // 1. Print employees whose name starts with 'A'
        char specificChar = 'A';
        System.out.println("Employees whose name starts with '" + specificChar + "':");
        employees.stream()
                .filter(emp -> emp.name.startsWith(String.valueOf(specificChar)))
                .forEach(System.out::println);

        // 2. Employees who joined after 2020
        System.out.println("\nEmployees who joined after 2020:");
        List<Employee> joinedAfter2020 = employees.stream()
                .filter(emp -> emp.yoj > 2020)
                .collect(Collectors.toList());

        joinedAfter2020.forEach(System.out::println);

        // 3. Employees who joined after 2020 in sorted order (based on yoj) and store in new list
        List<Employee> sortedJoinedAfter2020 = employees.stream()
                .filter(emp -> emp.yoj > 2020)
                .sorted(Comparator.comparingInt(emp -> emp.yoj))
                .collect(Collectors.toList());

        System.out.println("\nSorted Employees who joined after 2020:");
        sortedJoinedAfter2020.forEach(System.out::println);

        // 4. Count occurrences of each employee
        System.out.println("\nEmployee count (including duplicates):");
        Map<Employee, Long> employeeCount = employees.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        employeeCount.forEach((employee, count) -> 
            System.out.println(employee + " -> Count: " + count));

        // 5. Print only distinct employees
        System.out.println("\nDistinct Employees:");
        employees.stream()
                .distinct() // Removes duplicates based on equals() and hashCode()
                .forEach(System.out::println);
    }
}