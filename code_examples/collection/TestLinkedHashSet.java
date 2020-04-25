package collection;

import java.util.*;

public class TestLinkedHashSet {// linkedhash set, there is order but no duplicate
	public static void main(String[] args) {
		// Create a hash set
		Set<String> set = new LinkedHashSet<>();

		// Add strings to the set
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("Toronto");
		set.add("Beijing");
		set.add("New York");
		//set.add("Toronto");

		System.out.println(set);

		// Display the elements in the hash set
		for (String element : set)
			System.out.print(element.toLowerCase() + " ");
	}
}
