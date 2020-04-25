package Excpetion;
import java.util.*;

public class InputMismatchException {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag = true;

		do {
			try {
				System.out.println("Enter an integer ");
				int number = input.nextInt();
				System.out.println("The number is " + number);
				flag = false;
			} catch (InputMismatchException ex123) {
				System.out.println(ex123.getMessage());
				ex123.printStackTrace();
				System.out.println("Try again");
				input.nextLine();
			}
		} while (flag);

//		input.close();
	}
}
