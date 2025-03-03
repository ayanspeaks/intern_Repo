package com.cls;

import java.util.Enumeration;
import java.util.Stack;

public class Exp2 {
	
	public static void main(String a[]) {
		
		Stack data = new Stack();
		
		data.add(10);
		data.add("cpp");
		data.add(20);
		data.add("java");
		data.add(10);
		data.add(33.44f);
		data.add(22.22d);
		data.add(8833l);
		data.add('A');
		data.add(false);
		
		System.out.println(data);
		
		System.out.println(data.peek());
		
		data.push("king");
		
		System.out.println(data.peek());
		
		System.out.println(data.pop());
		
		System.out.println(data.peek());
		
		System.out.println(data.search(10));
		
		System.out.println(data.empty());
		
		data.clear();
		
		System.out.println(data);
		
		Enumeration itr = data.elements();
		
		while(itr.hasMoreElements()) {
			System.out.println(itr.nextElement());
		}
	}

}
