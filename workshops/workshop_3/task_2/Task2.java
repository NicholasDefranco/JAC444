package week4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

	public static Random r = new Random();

	public static int getRandom(int... numbers) {
		return numbers[r.nextInt(numbers.length)];
	}

	public static void main(String[] args) {
		r.setSeed(System.currentTimeMillis());

		// quick test
		System.out.println("getRandom(2, 6, 17, 13): " + getRandom(2, 6, 17, 13));

		Scanner in = new Scanner(System.in);

		System.out.println("Enter as many integers as you wish, CTRL+D will exit");

		// temporary storage for inputed integers
		ArrayList<Integer> arr = new ArrayList<>();

		// get input data
		/*Scanner parse = null;
		while(in.hasNextLine()) {
			String str = in.nextLine();

			parse = new Scanner(str);
			boolean informed = false;
			while(parse.hasNext()) {
				if(parse.hasNextInt()) {
					arr.add(parse.nextInt());
				} else {
					if(!informed) {
						System.out.println("Enter only numbers (if the line contained any numbers however, they were accepted)");
						informed = true;
					}
					parse.next();
				}
			}
			parse.close();
		} */

		// get input data - alternative way
		while(in.hasNextLine()) {
			String str = in.nextLine();
			boolean informed = false;

			String[] strs = str.split("[ ]+");
			for(int i = 0; i < strs.length; i++) {
				try {
					arr.add(Integer.parseInt(strs[i]));
				} catch(NumberFormatException e) {
					if(!informed) {
						System.out.println("Enter only numbers (if the line contained any numbers however, they were accepted)");
						informed = true;
					}
				}
			}
		}

		if(arr.size() > 0) {
			// convert ArrayList of Integers to int array...
			int[] a = new int[arr.size()];

			for(int i = 0; i < arr.size(); i++)
				a[i] = arr.get(i);

			System.out.println("Random number selected: " + getRandom(a));
		} else {
			System.out.println("No numbers given");
		}

		in.close();

	}

}
