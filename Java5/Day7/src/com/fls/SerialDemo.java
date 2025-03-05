package com.fls;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SerialDemo {
	
	public static void main(String a[]) {
		
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		
		System.out.println("enter id : ");
		
		int id = sc.nextInt();
		
		System.out.println("enter name ");
		
		String name = sc.next();
		
		System.out.println("enter city");
		
		String city = sc.next();
		
		System.out.println("enter pincode");
		
		int pincode = sc.nextInt();
		
		Customer cstObj = new Customer(id, name, city, pincode);
		
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream objout = null;
		
		try
		{
			fout = new FileOutputStream("src/customer.txt");
			
			bout = new BufferedOutputStream(fout);
			
			objout = new ObjectOutputStream(bout);
			
			objout.writeObject(cstObj);
			
			System.out.println("Done.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				objout.close();
				bout.close();
				fout.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
