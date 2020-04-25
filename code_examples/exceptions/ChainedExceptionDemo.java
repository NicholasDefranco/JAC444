
package Excpetion;
public class TestCircleWithException {
	public static void main(String[] args) {
		try {
			CircleWithException c1 = new CircleWithException(5);
			CircleWithException c2 = new CircleWithException(-5);
			CircleWithException c3 = new CircleWithException(0);
			System.out.println(c1.getRadius());
			System.out.println(c2.getRadius());
			System.out.println(c3.getRadius());
		}
		catch (IllegalArgumentException ex) {
//			System.out.println(ex);
//			ex.printStackTrace();
		}

		System.out.println("Number of objects created: " + CircleWithException.getNumberOfObjects());

	}
}
