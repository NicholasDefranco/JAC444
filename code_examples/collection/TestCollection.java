package collection;

import java.util.*;

public class TestCollection {
	public static void main(String[] args) {
		ArrayList<String> collection1 = new ArrayList<String>();// creates an empty list
		collection1.add("Toronto");
		collection1.add("Hamilton");
		collection1.add("London");
		collection1.add("Ottawa");
		collection1.add("Hamilton");

		System.out.println("A list of cities in collection1:");
		System.out.println(collection1);

		System.out.println("\nIs Hamilton in collection1? " + collection1.contains("Hamilton"));// contains() check if String contains another substring or not. It returns boolean value so it can use directly inside if statements.

		collection1.remove("Hamilton");
		System.out.println(collection1);
		System.out.println("\n" + collection1.size() + " cities are in collection1 now");

		Collection<String> collection2 = new ArrayList<String>();
		collection2.add("Waterloo");
		collection2.add("Kingston");
		collection2.add("Brampton");
		collection2.add("Toronto");

		System.out.println("\nA list of cities in collection2:");
		System.out.println(collection2);

		ArrayList<String> c1 = new ArrayList<String>(collection1);// all the elements of collection will be copied in the new list
		c1.addAll(collection2);
		System.out.println("\nCities in collection1 or collection2: ");
		System.out.println(c1);

		c1 = new ArrayList<String>(collection1);
		c1.retainAll(collection2);// keep the elements that are common in c1 and collection2, it only affects c1, doesnt change collection2
		System.out.print("\nCities in collection1 and collection2: ");
		System.out.println(c1);
		System.out.println(collection2);//No changes in collection2

		c1 = new ArrayList<String>(collection1);
		c1.removeAll(collection2);// all commons elements between c1 and collection2 will be deleted from c1, collecion2 does not change
		System.out.print("\nCities in collection1, but not in 2: ");
		System.out.println(c1);
		//System.out.println(collection2);
	}
}
