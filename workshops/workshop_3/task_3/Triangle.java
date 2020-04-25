package week4;

public class Triangle extends GeometricObject {

	double a = 0;
	double b = 0;
	double c = 0;

	public Triangle() {	}

	public Triangle(double a, double b, double c) {
		if(a > 0 && b > 0 && c > 0
				&& a + b > c && b + c > a && a + c > b) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public double geta() {
		return a;
	}

	public void seta(double a) {
		if(a < 0 || b + c <= a)
			return;

		this.a = a;
	}

	public double getb() {
		return b;
	}

	public void setb(double b) {
		if(b < 0 || a + c <= b)
			return;

		this.b = b;
	}

	public double getc() {
		return c;
	}

	public void setc(double c) {
		if(c < 0 || a + b <= c)
			return;

		this.c = c;
	}

	@Override
	public boolean isEmpty() {
		return a == 0;
	}

	@Override
	public double getArea() {
		if(isEmpty()) {
			return 0.0;
		} else {
			double p = getPerimiter() / 2;
			return Math.sqrt((p) * (p - a) * (p - b) * (p - c));
		}
	}

	@Override
	public double getPerimiter() {
		return !isEmpty() ? a + b + c : 0.0;
	}

	@Override
	public String toString() {
		return isEmpty() ? "Triangle is Empty" : "Triangle: side 1 = " + a + " b = " + b + " c = " + c;
	}

}
