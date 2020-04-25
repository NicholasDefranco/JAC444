package Excpetion;
import java.util.Scanner;

public class QuotientWithException {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two integers
		System.out.print("Enter two integers: ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();

		try {
			System.out.println("try begins ...");
			System.out.println(n1 + " / " + n2 + " is " + n1 / n2);
			System.out.println(n2 + " / " + n1 + " is " + n2 / n1);
			System.out.println("try ends ...");
		} catch (ArithmeticException ex) { // If an Arithmetic Exception occurs
			System.out.println("Exception: an integer "
					+ "cannot be divided by zero ");
		}
		System.out.println("Execution continues ...");

		input.close();
	}
}
