package week3;

import java.util.Scanner;

// Methods were simply commented with a number as they are already
// documented in the instructions
public class Task3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Validator v;

		long num = 0L;
		System.out.println("Enter a credit card number as a long integer: ");
		num = in.nextLong();

		v = new Validator(num);
		System.out.println(num + " is " + (v.isValid() ? "valid" : "invalid"));

		in.close();

	}

}

class Validator {

	private long num = 0L;

	// default constructor
	public Validator() {}

	// one-arg constructor
	public Validator(long num) {
		setNum(num);
	}

	// accessor method for num
	public long getNum() {
		return num;
	}

	// Validator will only validate positive numbers
	public void setNum(long num) {
		if(num > 0)
			this.num = num;
		else
			num = 0L;
	}

	// returns true if object is in safe empty state
	private boolean isEmpty() {
		return num == 0L;
	}

	// Method 1
	public boolean isValid() {
		int dig = numOfDigits(num);

		return !isEmpty() && dig >= 13 && dig <= 16 &&
				isValidPrefix() &&
				(sumOfDoubledDigits(num) +
				sumOfOddDigits(num)) % 10 == 0;
	}

	// Method 2
	private long sumOfDoubledDigits(long num) {

		int sum = 0;
		while(num > 0) {
			num /= 10;

			sum += sumOfDigits((int)(num % 10 * 2));

			num /= 10;
		}
		return sum;
	}

	// Method 3
	private int sumOfDigits(int num) {
		return num >= 10 ? num / 10 + num % 10 : num;
	}

	// Method 4
	private int sumOfOddDigits(long num) {
		int sum = 0;
		while(num > 0) {
			sum += num % 10;
			num /= 100;
		}
		return sum;
	}

	// Method 5
	public boolean isValidPrefix() {
		int n = (int) (num / (Math.pow(10, (numOfDigits(num) - 2))));
		return n / 10 == 4 || n / 10 == 5 || n / 10 == 6 || n == 37;
	}

	// Method 6
	private int numOfDigits(long num) {
		int digits = 0;
		while(num > 0) {
			num /= 10;
			digits++;
		}
		return digits;
	}

	/*
	// Method 7 - I do not have a use for this method
	private long kDigits(long num, int k) {
		return num % (long)Math.pow(10, k);
	}
	*/

}
