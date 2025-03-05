package com.fls;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Exp2 {
	
	public static void main(String a[]) {
		Path srcpath = Paths.get("src/bytetest.txt");
		Path trgtpath = Paths.get("src/chartest.txt");
		
		try
		{
			Path path = Files.copy(srcpath, trgtpath, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("Target file location : "+path);
			
			System.out.println("Copied content : "+new String(Files.readAllBytes(path)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
