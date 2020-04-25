package week4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		boolean done = false;

		Triangle t = null;

		// get triangle data
		do {
			System.out.print("Enter the three sides: ");
			try {
				t = new Triangle(in.nextDouble(), in.nextDouble(), in.nextDouble());
				done = true;
			} catch(InputMismatchException e) {
				System.out.println("Please Enter 3 numbers");
				done = false;
			} finally {
				in.nextLine();
			}
		} while(!done);

		// prompt user if the triangle is filled
		if(!t.isEmpty()) {
			int filled = 0;
			do {

				System.out.print("Is the triangle filled? (1. yes 0. no): ");
				try {
					filled = in.nextInt();
				} catch(InputMismatchException e) {
					System.out.println("Enter 1 for yes and 0 for no");
					filled = -1;
				} finally {
					in.nextLine();
				}

			} while(filled < 0 || filled > 1);

			t.setFilled(filled == 1);

			// prompt user for the colour of the triangle
			done = false;
			do {
				try {
					System.out.print("Enter the colour (R G B): ");
					t.setColor(in.nextInt(), in.nextInt(), in.nextInt());
					done = true;
				} catch(InputMismatchException e) {
					System.out.println("Enter 3 integers");
					done = false;
				} finally {
					in.nextLine();
				}
			} while(!done);

		} else {
			System.out.println("Invalid triangle (This triangle cannot exist)");
		}

		// print data collected
		if(!t.isEmpty()) {
			System.out.println("\n***Triangle's infomation***");
			System.out.println(t);
			System.out.println("Perimiter = " + t.getPerimiter());
			System.out.println("Area = " + t.getArea());
			System.out.println("Colour: " + t.getColor());
			System.out.println("filled: " + t.isFilled());
		}

		in.close();
	}

}
