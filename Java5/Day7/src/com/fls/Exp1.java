package com.fls;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Exp1 {
	
	public static void main(String a[]) {
		
		Path path = Paths.get("src/bytetest.txt");
		
		//File file = new File("src/bytetest.txt");
		
		try
		{
			byte[] bs = Files.readAllBytes(path);
			
			List<String> linesData = Files.readAllLines(path);
			
			System.out.println("Reading byte data : "+new String(bs));
			System.out.println("Reading list of lines : "+linesData);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
