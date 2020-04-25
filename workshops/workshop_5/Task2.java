package week6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {

	public static void main(String[] args) {
		// check if user gave the correct options...
		if(args.length != 1) {
			System.err.println("Usage: file_name");
			System.exit(1);
		}
		
		File f = new File(args[0]);
		try (FileInputStream in = new FileInputStream(f)) {
			// if a line contains an selection, iteration
			// or exception handling construct keyword
			// AND the next line contains ONLY a ({)
			// opening brace character (excluding whitespace 
			// characters), that part of the code is
			// using "next-line brace style" which 
			// must be fixed
			String str = new String(in.readAllBytes()).
					replaceAll("(if|do|while|for|try|catch|finally|class|\\(.*\\))([^{\n]*)(\n|\r\n|\n\r)+\\s*\\{[\t ]*", "$1$2{");
			FileOutputStream out = new FileOutputStream(f);
			out.write(str.getBytes());
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		} catch(IOException e) {
			System.err.println(e);
			System.exit(2);
		}
	}

}
