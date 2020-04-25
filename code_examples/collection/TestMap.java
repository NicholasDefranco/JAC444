package collection;

import java.util.*;
import java.util.Map.Entry;

public class TestMap {
	public static void main(String[] args) {
		// Create a HashMap
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Smith", 30); // its like an add in the collections , it adds an entry
		hashMap.put("Anderson", 31);
		hashMap.put("Lewis", 29);
		hashMap.put("Cook", 29);

		System.out.println("Display entries in HashMap");
		System.out.println(hashMap + "\n");

		// Create a LinkedHashMap
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("Smith", 30);
		linkedHashMap.put("Anderson", 31);
		linkedHashMap.put("Lewis", 29);
		linkedHashMap.put("Cook", 29);
//
		// Display the age for Lewis
		System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis")); // get, you give the key, it returns its value

		System.out.println("Display entries in LinkedHashMap");
		System.out.println(linkedHashMap);

		System.out.println();
		Set<Entry<String, Integer>> entrySet = linkedHashMap.entrySet();// returns a set of entries// you can use a set of entry instead of the map

		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry);
			System.out.println(entry.getKey() + " -> " + entry.getValue() );
		}
	}
}
