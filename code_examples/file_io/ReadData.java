package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {
	public static void main(String[] args) throws FileNotFoundException {
		// Create a File instance
		File file = new File("src/file/goal1.txt");

		// Create a Scanner for the file
//		Scanner input = new Scanner(file);

		// Read data from a file
		try ( Scanner input = new Scanner(file); ) {
			while (input.hasNext()) {
				String firstName = input.next();
				String lastName = input.next();
				int score = input.nextInt();
				System.out.println(firstName + " " + lastName);
			}
		}
	}
}
