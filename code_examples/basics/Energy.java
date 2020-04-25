package test;

import java.util.Scanner;

public class Energy {

	public static void main(String[] args) {
		
		double mass = 0.0;
		double init = 0.0;
		double fin = 0.0;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the amount of water in kg: ");
		mass = in.nextDouble();
		
		System.out.print("Enter the initial temperature of the water: ");
		init = in.nextDouble();
		
		System.out.print("Enter the final temparature of the water: ");
		fin = in.nextDouble();
		
		System.out.println("The energy needed to heat the water is: " + 
					mass * (fin - init) * 4184 + " joules");
		
	}

}
