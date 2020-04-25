import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {

	public static boolean contains(String str, String comp) {
		boolean contains = false;
		for(int i = 0; i < comp.length() && !contains; i++)
			for(int j = 0; j < str.length() && !contains; j++)
				if(comp.charAt(i) == str.charAt(j))
					contains = true;

		return contains;
	}

	public static void updateMap(Map<String, Integer> map, String[] sarr) {
		for(String s : sarr) {
			// first condition is necessary because if there are delimiting characters
			// 	beside each other in the file, it will add an empty string to the string array
			// second condition is a simple check for invalid words
			// last condition ensures the word doesn't contain invalid characters for regular words in the dictionary

			// (for ex: - character can exist within a word but cannot be at the start of a word)
			if(s.length() > 0 && Character.isAlphabetic(s.charAt(0)) && !contains(s, "_~+*=<>\\#@%^&|$0123456789")) {
					map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
			}
		}
	}

	public static void main(String[] args) {

		// check if the user provided the correct amount of command-line arguments
		if(args.length != 1) {
			System.err.println("Usage: file_name");
			System.exit(1);
		}

		try (Scanner in = new Scanner(new File(args[0]))) {

			final String regex = "[`,;.:?\'\"()\\[\\]{}!/]|\\s";

			// I used as a HashMap is efficient for retrieval
			HashMap<String, Integer> map = new HashMap<>();
			while(in.hasNext()) {
				// the split method will split the string into separate strings on all punctuation characters.
				updateMap(map, in.nextLine().toLowerCase().split(regex));
			}

			// An array list is required to be able to sort the contents
			// as the contents of a HashMap cannot be sorted

			// An array is list excels at random access making it the best
			// option for a collection that needs to be sorted
			ArrayList<String> arr = new ArrayList<>(map.keySet());
			arr.sort((str, str2) -> {
				return str.compareTo(str2);
			});

			// loop through each element in the array and print
			// the information
		    arr.forEach((str) -> {
				System.out.println(str + ": " + map.get(str));
			});

		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (Exception e) {
			// catch all for safety
			System.err.println(e);
		} finally {

		}

	}

}
