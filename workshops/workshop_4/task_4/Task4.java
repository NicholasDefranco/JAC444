package week5;

public class Task4 {

	public static int countDigits(int num) {
		int digits = 0;
		while(num > 0) {
			num /= 10;
			digits++;
		}
		return digits;
	}

	public static void main(String[] args) {
		// change this to change the amount of rows and columns
		final int MAX = 12;

		// countDigits function used for proper formatting
		final int WIDTH = countDigits(MAX * MAX) + 1;

		// Print top row...
		System.out.printf("%" + (WIDTH - 1) + "c", ' ');
		for(int i = 1; i <= MAX; i++) {
			System.out.printf("%" + WIDTH + "d", i);
		}
		System.out.println();

		// print second row (the row containing only dashes)...
		for(int i = 0; i <= MAX; i++) {
			for(int j = 0; j < WIDTH; j++) {
				System.out.print("-");
			}
		}
		System.out.println();

		// print the rest of the table...
		for(int i = 1; i <= MAX; i++) {
			System.out.printf("%-" + (WIDTH - 2) + "d|", i);
			for(int j = 1; j <= MAX; j++) {
				System.out.printf("%" + WIDTH + "d", i * j);
			}
			System.out.println();
		}
	}

}
