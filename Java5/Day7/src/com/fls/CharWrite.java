package com.fls;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CharWrite {
	
	public static void main(String a[]) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try
		{
			fw = new FileWriter("src/chartest.txt");
			
			bw = new BufferedWriter(fw);
			
			String msg = "This is simple example on char stream write and read";
			
			bw.write(msg);
			
			System.out.println("Done.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try
			{
				fw.close();
				bw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
