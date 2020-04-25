import java.util.Scanner;

class CircleApp {

	public static void main(String[] args) {
		Circle c1 = new Circle();
//		System.out.println("c1's radius is " + c1.radius);
		System.out.println("c1's radius is " + c1.getRadius());
		System.out.println("c1's color is " + Circle.getColor());

		Circle c2 = new Circle(10);
		System.out.println("c2's radius is " + c2.getRadius());
		System.out.println("c2's color is " + c1.getColor());
		Circle.setColor("Blue");
		System.out.println("c2's color is changed to " + Circle.getColor());
		System.out.println(Circle.getColor());
		c2.setRadius(20);
		System.out.println("c2's radius is changed to " + c2.getRadius());
		double a = c2.getArea();
		System.out.println("c2's area is " + a);

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter radius of your circle: ");
		double r = input.nextDouble();
		Circle c3 = new Circle(r);
		System.out.println("c3's radius is " + c3.getRadius());

		System.out.print("Please enter an integer number: ");
		int n = input.nextInt();
		int square = Circle.squareFn(n);
		System.out.println(n + "^2 = " + square);
	}

}
