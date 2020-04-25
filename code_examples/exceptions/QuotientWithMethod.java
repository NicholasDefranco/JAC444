package Excpetion;
import java.util.Scanner;

public class QuotientWithMethod {
	public static int quotient1(int n1, int n2) throws ArithmeticException {
		if (n2 == 0)
			throw new ArithmeticException("Divisor cannot be zero");

		return n1 / n2;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two integers
		System.out.print("Enter two integers: ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		try {
			int result = quotient1(n1, n2);
			System.out.println(n1 + " / " + n2 + " is " + result);
		}
		catch (ArithmeticException ex) {
			System.out.println("baaad");
		}


		System.out.println("Execution continues ...");

//		input.close();
	}
}
