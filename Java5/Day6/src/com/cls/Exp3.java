package com.cls;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

class Book{
	private int id;
	private String name;
	private String author;
	private int price;
	
	public Book(int i, String string, String string2, int j) {
		
	}
	
	public Book(int id, String name, String authod, int price, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(name, other.name)
				&& price == other.price;
	}
	
	class NameComparator1 implements Comparator<Book>{
	
		@Override
	public int compare(Book o1, Book o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

public class Exp3 {
	
	public static void main(String a[]) {
		TreeSet<Book> data = new TreeSet<>(new NameComparator1());
		
		data.add(new Book(101, "Football", "Messi", 12));
		data.add(new Book(102, "java", "Mess", 15));
		data.add(new Book(109, "Foot", "mes", 21));
		data.add(new Book(100, "foo", "mei", 10));
		
		System.out.println(data);
		
		data.forEach(book -> System.out.println(book.getId() + " "+ book.getName()+ " " + book.getAuthor()));
		
		data.parallelStream()
		.filter(bk -> bk.getPrice() >= 10 && bk.getPrice() <= 20)
		.forEach(book -> System.out.println(book.getId() + " "+ book.getName()+ " " + book.getAuthor()));
		
		data.stream()
		    .filter(book ->
		Character.isUpperCase(book.getName().charAt(0)))
		    .forEach(book ->
		    System.out.println(book.getId() + " " + book.getName() + " " + book.getAuthor()));
		
	}

}
