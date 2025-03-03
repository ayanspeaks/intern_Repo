package com.test;
import java.util.*;
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
                new Employee(101, "Alice", 30, "Female", 2018, 50000),
                new Employee(102, "Bob", 35, "Male", 2021, 60000),
                new Employee(103, "Charlie", 28, "Male", 2019, 55000),
                new Employee(104, "David", 40, "Male", 2022, 65000),
                new Employee(105, "Eve", 25, "Female", 2023, 70000)
        );

        // 1. Print employees whose name starts with a specific character (e.g., 'A')
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
    }
}
