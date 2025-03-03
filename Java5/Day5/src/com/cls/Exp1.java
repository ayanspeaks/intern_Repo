package com.cls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exp1 {
	
	public static void main(String a[]) {
		
		//Collection data = new ArrayList();
		
		//List data = new ArrayList();
		
		//ArrayList data = new ArrayList();
		
		LinkedList data = new LinkedList();
		
		data.add(6);
		data.add("ayan");
		data.add(12);
		data.add("cpp");
		data.add(18);
		data.add(33.44f);
		data.add(22.22d);
		data.add(8833l);
		data.add('A');
		data.add(false);
		
		System.out.println(data);
		
		System.out.println(data.size());
		
		data.set(5, "Ayan");
		
		System.out.println(data);
		
		data.remove(6);
		
		System.out.println(data);
		
		System.out.println(data.get(8));
		
		System.out.println(data.contains(12));
		
		System.out.println(data.getFirst()+" "+data.getLast());
		
		for(Object obj : data) {
			System.out.println(obj);
		}
		
		//Iterator itr = data.iterator();
		
		ListIterator ltr = data.listIterator();
		
		while(ltr.hasNext()) {
			System.out.println(ltr.next());
		}
		
		while(ltr.hasNext()) {
			System.out.println(ltr.previous());
		}
	}
}
