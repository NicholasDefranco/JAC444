public class Circle {
	private double radius = 1;
	private static String color = "White";

	public Circle () {

	}

	public Circle (double newRadius) {
		radius = newRadius;
	}

	public double getArea() {
		return radius * radius * 3.14;
	}

	public double getPerimeter() {
		return 2 * radius * 3.14;
	}

	public void setRadius(double newRadius) {
		if (newRadius > 0)
			radius = newRadius;
		else
			System.out.println("You cannot set Radius to be non-positive");
	}

	public double getRadius() {
		return radius;
	}

	public static String getColor() {
		return  color;
	}

	public static void setColor(String newColor) {
		color = newColor;
	}

	public static int squareFn(int num) {
		return num * num;
	}
}
