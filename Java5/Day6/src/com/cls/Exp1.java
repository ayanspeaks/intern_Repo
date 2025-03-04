package com.cls;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Exp1 {
	
	public static void main(String a[]) {
		
		//Collection data = new HashSet();
		//Set data = new HashSet();
		
		//HashSet data = new HashSet();
		
		LinkedHashSet data = new LinkedHashSet();
		
		data.add("java");
		data.add(100);
		data.add('a');
		data.add("java");
		data.add(100);
		data.add(10);
		data.add(33.33f);
		data.add(22.22d);
		data.add(false);
		data.add("ayan");
		
		System.out.println(data);
		
		Iterator itr = data.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//java 8 new features
		data.forEach(x -> System.out.println(x));
		
	}

}
