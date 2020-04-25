package file;

import java.io.*;
import java.util.*;

public class WriteDataWithAutoClose {
	public static void main(String[] args) throws IOException {

		File parentDir = new File("src/file/");// create an object of file type
		File file = new File(parentDir, "Goal.txt");

//		if (file.exists()) {
//			System.out.println("File already exists");
//			System.exit(1);
//		}

		// Create a file


		try ( PrintWriter output = new PrintWriter(file);
		Scanner sc = new Scanner(file);) {
//		try ( PrintWriter output = new PrintWriter(file);) {

			// Write formatted output to the file
			output.print("fname lname ");
			output.println(70);
			output.print("FirstName LastName FL ");
			output.println(85);
		}


	}
}
