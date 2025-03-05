package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Studata{
	public
		int id;
		String name;
		int age;
		int marks;
		String city;
	
	public Studata(int id, String name, int age,int marks, String city){
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.city = city;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public int getAge() {
		return age;
	}

//	public void setAge(int age) {
//		this.age = age;
//	}

	public int getMarks() {
		return marks;
	}

//	public void setMarks(int marks) {
//		this.marks = marks;
//	}

	public String getCity() {
		return city;
	}

//	public void setCity(String city) {
//		this.city = city;
//	}
	
	
}

public class Exp2 {
	public static void main(String[] args) {
		try {
//			
			Studata[] Stud = {
					new Studata(101,"Iron Man",22,98,"NYC"),
					new Studata(102,"Captain America",32,92,"WDC"),
					new Studata(103,"Spider Man",12,94,"MIAMI"),
					new Studata(104,"Ant Man",23,95,"NYC"),
					new Studata(105,"Bat Man",26,96,"FLORIDA"),
					new Studata(106,"Cat Man",29,88,"GEORGIA"),
					new Studata(107,"Rat Man",30,93,"WDC"),
					new Studata(108,"Fish Man",20,91,"MIAMI"),
					new Studata(109,"Nick Fury",25,99,"WDC"),
					new Studata(110,"Lion King",28,90,"TORONTO")
			};
			
//			Load the driver Class
			Class.forName("com.mysql.jdbc.Driver");
			
//			Create Connection Object
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root@39");
			
//			Create Statement Object
			Statement stmt = con.createStatement();
			
//			SQL Query
			String sql = "CREATE TABLE enemies(id INT PRIMARY KEY, name VARCHAR(50), age INT, marks INT, city VARCHAR(50))";
			
//			Execute Query
			stmt.execute(sql);
			
			
			
			
//			Insert data into table
			for(Studata item : Stud) {
				stmt.execute("insert into enemies values("
						+item.getId()+", '"+item.getName()+"', "+item.getAge()+", "+item.getMarks()+", '"+item.getCity()+"');");
			}
			
//			Close the connection Object
			con.close();
			
			System.out.println("Done");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}