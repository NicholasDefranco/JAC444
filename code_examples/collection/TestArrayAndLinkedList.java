package collection;

import java.util.*;

public class TestArrayAndLinkedList {
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1); // 1 is autoboxed to new Integer(1)
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(0, 10);
		arrayList.add(3, 30);

		System.out.println("A list of integers in the array list:");
		System.out.println(arrayList);
//
		LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);
		linkedList.add(1, "red");
		linkedList.removeLast();// only for linkelist, remove the last element
		linkedList.addFirst("green");

		System.out.println("A list of integers in the linked list:");
		System.out.println(linkedList);
//
		System.out.println("Display the linked list forward:");
		ListIterator<Object> listIterator = linkedList.listIterator();
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();
//
		System.out.println("Display the linked list backward:");
		listIterator = linkedList.listIterator(linkedList.size() + 1 );
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}
	}
}
