package collection;

import java.util.*;

public class TestMethodsInCollection {
	public static void main(String[] args) {
		// Create set1
		Set<String> set1 = new HashSet<>();

		// Add strings to set1
		set1.add("London");
		set1.add("Paris");
		set1.add("New York");
		set1.add("Toronto");
		set1.add("Beijing");

		System.out.println("set1 is " + set1);
		System.out.println(set1.size() + " elements in set1");
//
//		// Delete a string from set1
		set1.remove("London");
		System.out.println("\nset1 is " + set1);
		System.out.println(set1.size() + " elements in set1");
//
//		// Create set2
		Set<String> set2 = new HashSet<>();
//
//		// Add strings to set2
		set2.add("London");
		set2.add("Berlin");
		set2.add("Paris");
		System.out.println("\nset2 is " + set2);
		System.out.println(set2.size() + " elements in set2");
//
		System.out.println("\nIs Rome in set2? " + set2.contains("Rome"));
//
		set1.addAll(set2);// all elements of set2 will be added to set1, but no duplicate
		System.out.println("\nAfter adding set2 to set1, set1 is " + set1);
//
		set1.removeAll(set2);
		System.out.println("After removing set2 from set1, set1 is " + set1);
//
		set1.retainAll(set2);// keep common elements between set2 and set1
		System.out.println("After removing common elements in set2 " + "from set1, set1 is " + set1);
	}
}
