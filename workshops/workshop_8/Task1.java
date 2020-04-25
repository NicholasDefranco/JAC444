import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Task1 {

	// Data Structures cannot store data of primitive data type
	// Their associating wrapper class must be used
	// In this case The Character class was used instead of the char type.
	public static HashSet<Character> set = new HashSet<>();

	static {
		// static initialization block is ran once upon
		// the creation of the class

		// This is perfect for initializing static members
		// of a class as they only need to be initialized
		// once
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Enter a file name: ");
		try (Scanner fin = new Scanner(new File(in.nextLine()))) {
			int vowels = 0;
			int consonants = 0;
			while(fin.hasNext()) {
				// the toUpperCase() call is to ensure case-insensitive operations
				char[] line = fin.nextLine().toUpperCase().toCharArray();
				// the for each loop uses an iterator implicitly
				for(char c : line) {
					if(set.contains(c))
						vowels++;
					else if(Character.isAlphabetic(c)) // safeguard to ensure non letters (such as hyphens) are not counted as consonants
						consonants++;
				}
			}
			System.out.printf("The number of vowels is %d and the number of consonants is %d\n", vowels, consonants);
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch(Exception e) {
			// catch all for safety
			System.err.println(e);
		} finally {
			in.close();
		}


	}

}
