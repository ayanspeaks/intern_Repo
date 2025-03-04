package com.cls;

import java.util.Iterator;
import java.util.TreeSet;

public class Exp2 {
	
	public static void main(String a[]) {
		
		//Collection data = new TreeSet();
		//Set data = new TreeSet();
		
		TreeSet<String> data = new TreeSet<>();
		
		data.add("java");
		data.add("e");
		data.add("a");
		data.add("ok");
		data.add("r");
		data.add("cpp");
		data.add("ayan");
		
		System.out.println(data.reversed());
		
		Iterator<String> itr = data.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		data.forEach(x -> System.out.println(x));
		
		System.out.println(data.subSet("king", "sky"));
		
		//System.out.println(data.t);
	}
	
	

}
