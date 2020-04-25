package week6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task3 {

	public static void main(String[] args) {
		// check if user gave the correct options...
		if(args.length != 1) {
			System.err.println("Usage: file_name");
			System.exit(1);
		}
			
		File f = new File(args[0]);
		try (FileInputStream in = new FileInputStream(f)) {
			byte[] arr = in.readAllBytes();
			int l = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == '\n') {
					l++;
				}
			}
			// or
			//String[] lines = new String(arr).split("\r\n|\n");
			// and use lines.length to get the amount of lines
			System.out.printf("lines: %d words: %d chars: %d\n", l, 
						new String(arr).split("\\s+").length, arr.length);
			// \s+ matches one or more whitespace characters
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		} catch(IOException e) {
			System.err.println(e);
			System.exit(2);
		}
	}

}
