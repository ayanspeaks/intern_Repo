package com.fls;

import java.io.BufferedReader;
import java.io.FileReader;

public class CharRead {
	
	public static void main(String a[]) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try
		{
			fr = new FileReader("src/chartest.txt");
			
			br = new BufferedReader(fr);
			
			System.out.println(br.readLine());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
				fr.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
