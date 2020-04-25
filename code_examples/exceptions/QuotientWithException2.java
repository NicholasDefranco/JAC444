
package Excpetion;
import java.util.Scanner;

public class QuotientWithException2 {
	public static int quotient(int n1, int n2) {
		if (n2 == 0)
			throw new ArithmeticException();

		return n1 / n2;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two integers
		System.out.print("Enter two integers: ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();

		try {
			int result2 = quotient(n1, n2);
			System.out.println(n1 + " / " + n2 + " is " + result2);
		} catch (ArithmeticException ex) { // If an Arithmetic Exception occurs
//			System.out.println("Exception: an integer "
//					+ "cannot be divided by zero ");
			System.out.println(ex.getMessage());
		}

		System.out.println("Execution continues ...");

//		input.close();
	}
}
