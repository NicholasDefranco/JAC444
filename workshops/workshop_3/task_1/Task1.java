package week4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

	public static Scanner in = new Scanner(System.in);

	// prompts user for a real and imaginary part of a complex
	// number to create a complex number
	public static Complex getComplexNum() {
		boolean done = false;
		Complex c = null;
		do {
			System.out.print("> ");
			try {
				c = new Complex(in.nextDouble(), in.nextDouble());
				done = true;
			} catch(InputMismatchException e) {
				System.out.println("Please enter two numbers");
			}
			// clear input buffer
			in.nextLine();
		} while(!done);
		return c;
	}

	public static void main(String[] args) {

		// prompt for data
		System.out.println("Enter the first complex number ");
		Complex c1 = getComplexNum();
		System.out.println("Enter the second complex number ");
		Complex c2 = getComplexNum();

		// print results of calculations
		System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
		System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
		System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));

		try {
			System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
		} catch(ArithmeticException e) {
			System.out.println(e);
		}

		System.out.println("|" + c1 + "| = " + c1.absolute());
	}

}
