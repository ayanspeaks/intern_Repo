package com.cls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Exp3 {
	
	public static void main(String[] args) {
		
		ArrayList<String> listNames = new ArrayList<>();
		
		listNames.add("java");
		listNames.add("cpp");
		listNames.add("mern");
		listNames.add("aws");
		listNames.add("hibernate");
		listNames.add("java");
		
		Iterator<String> itr = listNames.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		ListIterator<String> ltr = listNames.listIterator();
		
		while(ltr.hasPrevious()) {
			System.out.println(ltr.previous());
		}
		
		for(String dt : listNames) {
			System.out.println(dt);
		}
		
		Collections.sort(listNames);//ascending order
		
		Collections.sort(listNames.reversed());//reverse order
		
		System.out.println(listNames);
	}

}
