public class CircleFromGeomrtricObject extends GeometricObject {
	private double radius = 1.0;

	public CircleFromGeomrtricObject() {

	}

	public CircleFromGeomrtricObject(double radius) {
//		super("blue", false);
//		super();
		this.radius = radius;
//		super("blue", false);
	}

	public CircleFromGeomrtricObject(double newRadius, String newColor, boolean newFilled) {
		this.radius = newRadius;
//		this(newRadius);
		setColor(newColor);
		setFilled(newFilled);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double newRadius) {
		radius = newRadius;
	}

	public void printCircle() {
		System.out.println(this.toString());
		System.out.println(super.toString());
	}

//	@Override
	public String toString(int i) {
		return super.toString() +
				", radius is " + radius;
	}

	public static void main(String[] args) {
		CircleFromGeomrtricObject c1 = new CircleFromGeomrtricObject(10.0);
		c1.printCircle();
//		Circle c2 = new Circle(20.0);
//		c2.printCircle();
//		System.out.println(c1.toString());
//		System.out.println(c1.getRadius());
//		System.out.println(c1.getColor());
	}
}
