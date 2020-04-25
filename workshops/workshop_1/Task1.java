package Week2;

import java.util.Scanner;

public class Task1 {

	// constant array mapping an integer(its index) to its name.
	public static final String[] days = {
			"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday",
		    "Thursday", "Friday"
	};

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int year = 0;
		int month = 0;
		int day = 0;

		// prompt for year...
		do {
			System.out.print("Enter year: (e.g., 2012): ");
			year = in.nextInt();
		} while(year < 0);

		// prompt for month...
		do {
			System.out.print("Enter month: 1-12: ");
			month = in.nextInt();
		} while(month < 1 || month > 12);

		// January and February are considered to be 13
		// and 14 respectively in the formula and must
		// refer to the previous year
		if(month == 1) {
			month = 13;
			year--;
		} else if(month == 2) {
			month = 14;
			year--;
		}

		// prompt for day...
		do {
			System.out.print("Enter the day of the month: 1-31: ");
			day = in.nextInt();
		} while(day < 1 || day > 31);

		int weekday = (day + ((13 * (month + 1)) / 5) +
					(year % 100) + ((year % 100) / 4) +
					((year / 100) / 4) + (5 * (year / 100))) % 7;

		System.out.print("Day of the week is " + days[weekday]);

		in.close();

	}


}
