package test;

public class LinearEquation {

	public static void main(String[] args) {
		
		final double a = 3.4;
		final double b = 50.2;
		final double c = 2.1;
		final double d = 0.55;
		final double e = 44.5;
		final double f = 5.9;
		
		double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
		double y = ((a * f) - (e * c)) / ((a * d) - (b * c));
		
		System.out.println("x is " + x);
		System.out.println("y is " + y);
	
	}
		
}
