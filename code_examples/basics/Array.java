import java.util.*;
import java.lang.*;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter an integer: ");

		Scanner input = new Scanner(System.in);
		int a = input.nextInt();

		double myArray[] = new double[a];

		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = Math.random() * 100;
		}

		double sumOfmyArray = 0;
		for (int i = 0; i < myArray.length; i++) {
			sumOfmyArray += myArray[i];
		}

		double max = 0;
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] > max) {
				max = myArray[i];
			}
		}

		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = (float) myArray[i];
			System.out.printf("%.2f%s", myArray[i], " ");
		}
		System.out.printf("%s%.2f%s", "\n", sumOfmyArray, " is the sum of the array.");
		System.out.printf("%s%.2f%s", "\n", max, " is the max value of the array.");
	}

}
