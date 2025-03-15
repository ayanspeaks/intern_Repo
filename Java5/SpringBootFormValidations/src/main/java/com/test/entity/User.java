package com.test.entity;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "user5")
//@NamedNativeQuery(name = "user5.firstName", query = "select u from user5 u where u.firstName=?1")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message = "first name required")
	private String firstName;
	
	@NotEmpty(message = "last name required")
	private String lastName;

	@NotEmpty(message = "gender required")
	private String Gender;
	
	private String[] Food;
	
	@NotEmpty(message="from city is required")
	private String cityFrom;
	
	@NotEmpty(message="to city is required")
	private String cityTo;
	
	@NotEmpty
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private String jDate;
	
	@NotEmpty
	private String[] seat;
	
	public User() {
		
	}
	
	
	
	public User(String firstName, String lastName, String gender, String[] food, String cityFrom,
			@NotEmpty(message = "to city is required") String cityTo, @NotEmpty String jDate, @NotEmpty String[] seat) {
		this.firstName = firstName;
		this.lastName = lastName;
		Gender = gender;
		Food = food;
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.jDate = jDate;
		this.seat = seat;
	}


	public boolean validate(String u1, String p2) {
		if(u1.equals(p2)) {
			return true;
		}
		return false;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



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



	public String getGender() {
		return Gender;
	}



	public void setGender(String gender) {
		Gender = gender;
	}



	public String[] getFood() {
		return Food;
	}



	public void setFood(String[] food) {
		Food = food;
	}



	public String getCityFrom() {
		return cityFrom;
	}



	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}



	public String getCityTo() {
		return cityTo;
	}



	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}



	public String getjDate() {
		return jDate;
	}



	public void setjDate(String jDate) {
		this.jDate = jDate;
	}



	public String[] getSeat() {
		return seat;
	}



	public void setSeat(String[] seat) {
		this.seat = seat;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Gender=" + Gender
				+ ", Food=" + Arrays.toString(Food) + ", cityFrom=" + cityFrom + ", cityTo=" + cityTo + ", jDate="
				+ jDate + ", seat=" + Arrays.toString(seat) + "]";
	}
}

