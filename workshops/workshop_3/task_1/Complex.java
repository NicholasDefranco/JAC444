package week4;

public class Complex implements Cloneable {
	private double a = 0.0;
	private double b = 0.0;

	public Complex() {}

	public Complex(double a) {
		this.a = a;
	}

	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public Complex add(Complex c) {
		return new Complex(this.a + c.a, this.b + c.b);
	}

	public Complex subtract(Complex c) {
		return new Complex(this.a - c.a, this.b - c.b);
	}

	public Complex multiply(Complex c) {
		return new Complex(this.a * c.a - this.b * c.b, this.b * c.a + this.a * c.b);
	}

	public Complex divide(Complex c) throws ArithmeticException {
		if(c.a == 0 && c.b == 0)
			throw new ArithmeticException("division by zero");

		return new Complex((this.a * c.a + this.b * c.b) / (c.a * c.a + c.b * c.b), (this.b * c.a - this.a * c.b) / (c.a * c.a + c.b * c.b));
	}

	public double absolute() {
		return Math.sqrt(this.a * this.a + this.b * this.b);
	}

	public double getRealPart() {
		return a;
	}

	public double getImaginaryPart() {
		return b;
	}

	public String toString() {
		return "(" + a + (b == 0 ? ")" : " + " + b + "i)");
	}

	@Override
	public Complex clone() throws CloneNotSupportedException {
		return (Complex)super.clone();
	}

}
