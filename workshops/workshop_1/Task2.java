package Week2;

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {

		double principle = 0.0;
		double balance = 0.0;
		double monthlyInterestRate = 0.0;
		double interest = 0.0;
		double annualRate = 0.0;
		int years = 0;

		Scanner in = new Scanner(System.in);

		// Prompt for a loan amount
		do {
			System.out.print("Loan Amount: ");
			principle = in.nextDouble();
		} while(principle <= 0.0);

		balance = principle;

		// Prompt for an amount of years
		do {
			System.out.print("Number of Years: ");
			years = in.nextInt();
		} while(years <= 0);

		// Prompt for an annual interest rate
		do {
			System.out.print("Annual Interest Rate: ");
			annualRate = in.nextDouble() / 100;
		} while(annualRate <= 0.0 || annualRate > 1.0);

		// calculate monthly interest rate...
		monthlyInterestRate = Math.pow((1 + annualRate), 1.0/12.0) - 1;

		// calculate monthly payment...
		double monthlyPayment = (principle * monthlyInterestRate)
				/ (1 - (Math.pow(1 / (1 + monthlyInterestRate),
				years * 12)));

		System.out.printf("\nMonthly Payment: %.2f\n", monthlyPayment);

		// calculate total payment...
		double totalPayment = monthlyPayment * (years * 12);

		System.out.printf("Total Payment: %.2f\n\n", totalPayment);

		System.out.println("Payment#\tInterest\tPrinciple\tBalance");

		// Amortization schedule creation...
		for (int i = 1; i <= years * 12; i++) {

			interest = monthlyInterestRate * balance;
			principle = monthlyPayment - interest;
			balance = balance - principle;

			// since floating point operations are approximate,
			// there can be a possibility of the result balance
			// being less then zero (however, extremely close
			// to zero).
			// This if statement, prevents -0.00 to be printed to
			// the screen.
			if(balance < 0.0)
				balance = 0.0;

			System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\n",
						i, interest, principle, balance);
		}

		in.close();

	}

}
