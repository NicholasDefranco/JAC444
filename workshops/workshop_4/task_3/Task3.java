package week5;

public class Task3 {

	public static int countDigits(int num) {
		int digits = 0;
		while(num > 0) {
			num /= 10;
			digits++;
		}
		return digits;
	}

	public static void main(String[] args) {
		// change this to change the amount of rows
		final int ROWS = 8;

		// // countDigits function used for proper formatting
		final int WIDTH = countDigits((int)(Math.pow(2, ROWS))) + 1;

		// creating the triangle
		for(int i = 0; i < ROWS; i++) {
			int j = 0;
			System.out.printf("%" + (ROWS - i) * WIDTH + "s", "");
			for(; j < (i * 2 + 1) / 2; j++)
				System.out.printf("%" + (WIDTH - 1) + "d ", 1 << j);
			for(; j >= 0; j--)
				System.out.printf("%" + (WIDTH - 1) + "d ", 1 << j);
			System.out.println();
		}

	}

}
