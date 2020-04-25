package week6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Read {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir") + "/src/week6/gutenberg_shakespeare.txt");
		File f = new File(System.getProperty("user.dir") + "/src/week6/gutenberg_shakespere.txt");
		File f2 = new File(System.getProperty("user.dir") + "/src/week6/file");
		
		try {
			Scanner in = new Scanner(f);
			
			while(in.hasNext()) {
				System.out.println(in.nextLine());
			}
			
			in.close();
		} catch(IOException e) {
			
		}
		
		
		try {
			
			FileInputStream in = new FileInputStream(f);
			FileOutputStream out = new FileOutputStream(f2, true);
			
			byte[] arr = in.readAllBytes();
			
			out.write(arr);
			
			in.close();
			out.close();
			
		} catch(IOException e) {
			
		}
		
	}

}
