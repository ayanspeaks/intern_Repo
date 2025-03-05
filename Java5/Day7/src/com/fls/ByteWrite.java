package com.fls;

import java.io.File;
import java.io.FileOutputStream;

public class ByteWrite {
	
	public static void main(String a[]) {
		FileOutputStream fout = null;
		try {
			File file = new File("src/bytetest.txt");
			
			fout = new FileOutputStream(file);
			
			String msg = "This is simple byte stream write and read example";
			
			fout.write(msg.getBytes());
			
			System.out.println("Done.");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			try {
				if(fout == null) {
					fout.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
