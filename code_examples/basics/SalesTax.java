package test;

import java.util.Scanner;

public class SalesTax {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter purchase amount: ");
		double purchaseAmount = input.nextDouble();
		double tax = purchaseAmount * 0.06;
		System.out.println("Sales tax is $" + (int) (tax * 100) / 100);
		System.out.printf("Sales tax is $%.2f\n", tax);
		
		System.out.println((int)(128.9 + 0.5));
		int value = 0;
		value = 2147483647 + 1;
		
		System.out.println(value);
	}
}
