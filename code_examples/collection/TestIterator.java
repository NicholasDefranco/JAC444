package collection;

import java.util.*;

public class TestIterator {
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();
		collection.add("Toronto");
		collection.add("Hamilton");
		collection.add("London");
		collection.add("Ottawa");

		System.out.println(collection);

		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().toUpperCase() + " ");
		}

		iterator.remove();

		System.out.println(collection);


//		System.out.print("\n" + collection);
        for (String city: collection)
           System.out.print(city.toUpperCase() + " ");


	}
}
