package collection;

import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good afternoon. Have a good class. Have a good Java time. Have fun!!!";

		// Create a Map to hold words as key and count as value
		Map<String, Integer> map = new LinkedHashMap<>();

		String[] words = text.split("[\\s\\W]");
//		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();

			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		// Display key and value for each entry
		for (String key: map.keySet()) {
			System.out.println(key + "\t" + map.get(key));
		}
	}
}
