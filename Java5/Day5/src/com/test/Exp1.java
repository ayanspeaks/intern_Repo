package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableImpl implements Runnable{
	public void run() {
		System.out.println("run() from a different thread than Main");
	}
}
public class Exp1 {
	
	static ExecutorService executor = Executors.newFixedThreadPool(2);
	
	public static void main(String a[]) {
		
		RunnableImpl task = new RunnableImpl();
		Thread thread = new Thread(task);
		thread.start();
		
		executor.submit(task);
		executor.shutdown();
	}

}
