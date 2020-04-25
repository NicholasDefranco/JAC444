package week6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task1 {

	public static void main(String[] args) {
		// check if user gave the correct options...
		if(args.length != 2) {
			System.err.println("Usage: text_to_remove file_name");
			System.exit(1);
		}
		
		File f = new File(args[1]);
		try (FileInputStream in = new FileInputStream(f)) {
			// simply read all the bytes in the file, convert
			// a string, and replace all matches with an
			// empty string
			String s = new String(in.readAllBytes());
			FileOutputStream out = new FileOutputStream(f);
			out.write(s.replaceAll(args[0], "").getBytes());
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
