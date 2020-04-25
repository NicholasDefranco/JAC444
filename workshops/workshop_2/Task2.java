package week3;

import java.util.Scanner;

class Location {

	private int x = -1;
	private int y = -1;

	// two-arg constructor
	public Location(int x, int y) {
		if(x >= 0 && y >= 0) {
			this.x = x;
			this.y = y;
		}
	}

	// returns a reference to an instance of Location which contains
	// the coordinates of the location will the max value in 2-D array
	// passed
	public static Location locateLargest(double[][] a) {
		double max = Double.MIN_VALUE;
		int maxRow = 0;
		int maxCol = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] > max) {
					max = a[i][j];
					maxRow = i;
					maxCol = j;
				}
			}
		}
		return new Location(maxRow, maxCol);
	}

	// accessor methods
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	// called when object is printed to the screen
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}


public class Task2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns in the array: ");
		int rows = in.nextInt();
		int cols = in.nextInt();
		double[][] nums = new double[rows][cols];

		System.out.println("Enter the array:");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				nums[i][j] = in.nextDouble();
			}
		}

		Location l = Location.locateLargest(nums);
		System.out.println("The location of the largest element is " +
					nums[l.getX()][l.getY()] + " at " + l);

		in.close();

	}
}
