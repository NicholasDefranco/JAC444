package Excpetion;
import java.util.Scanner;

public class Quotient {
public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	// Prompt the user to enter two integers
	System.out.print("Enter two integers: ");
	int n1 = input.nextInt();
	int n2 = input.nextInt();

	System.out.println(n1 + " / " + n2 + " is " + (n1 / n2));

//	if (n2 != 0)
//		System.out.println(n1 + " / " + n2 + " is " + (n1 / n2));
//	else
//		System.out.println("Divisor cannot be zero ");

//	input.close();
	}
}
