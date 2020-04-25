package week5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random(System.currentTimeMillis());

		// instructions specified the array must have 100
		// elements
		final int LENGTH = 100;

		// set up array
		int[] arr = new int[LENGTH];
		for(int i = 0; i < LENGTH; i++) {
			arr[i] = r.nextInt();
		}

		// collect input from user and validate the input
		// if the user has entered bad data, an exception will
		// be thrown based on the error caused
		boolean done = false;
		do {
			System.out.print("Enter an index: ");
			try {
				System.out.println("The value at the index is: " + arr[in.nextInt()]);
				done = true;
			} catch(InputMismatchException e) {
				// System.out PrintStream object were used in catches
				// instead of System.err because the two streams could
				// interleave in the output
				System.out.println(e + ": You must provide an integer.");
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			} finally {
				in.nextLine();
			}
		} while(!done);

		in.close();

	}

}
