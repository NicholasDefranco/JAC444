package file;

import java.io.*;
import java.util.*;

public class ReplaceText {
	public static void main(String[] args) throws Exception {

		File parentDir = new File("src/file");

//		String[] newArgs = {"source.txt", "destination.txt", "Hossein", "Jamges"};


		// Check command line parameter usage
		if (args.length != 4) {
			System.out.println(
				"Usage: java ReplaceText sourceFile targetFile oldString newString");
			System.out.println(args.length);
			System.exit(1);
		}

		// Check if source file exists
		File sourceFile = new File(parentDir, args[0]);
//		System.out.println(sourceFile.getName());
		if (!sourceFile.exists()) {
			System.out.println("Source file " + args[0] + " does not exist");
			System.exit(2);
		}

		// Check if target file exists
		File targetFile = new File(parentDir, args[1]);
		if (targetFile.exists()) {
			System.out.println("Target file " + args[1] + " already exists");
			System.exit(3);
		}

		try (
			// Create input and output files
			Scanner input = new Scanner(sourceFile);
			PrintWriter output = new PrintWriter(targetFile);
				)
		{
			while (input.hasNext()) {
				String s1 = input.nextLine();
				String s2 = s1.replaceAll(args[2], args[3]);
//				System.out.println(s2);
				output.println(s2);
			}
		}
	}
}
