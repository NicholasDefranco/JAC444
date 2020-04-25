package collection;

import java.util.*;

public class TestHashSet {
	public static void main(String[] args) {
		// Create a hash set
		Set<String> set = new HashSet<String>();

		// Add strings to the set
		set.add("London"); // set does not accept duplicate, by default there is no order, but treeset accepts order
		set.add("Paris");
		set.add("New York");
		set.add("Toronto");
		set.add("Beijing");
		set.add("New York");

		System.out.println(set);


		System.out.println();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println("\n");
		// Display the elements in the hash set
		for (String s : set) {
			System.out.print(s.toUpperCase() + " ");
		}

		System.out.println();
		// Process the elements using a forEach method
		System.out.println();

	}
}
