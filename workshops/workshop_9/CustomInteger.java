// Integer wrapper class
public class CustomInteger {

	private int i = 0;
	public CustomInteger() {}

	// swap these lines to see output
	// with and without synchronization.
	// public void increment() {
	public synchronized void increment() {
		i++;
	}

	public String toString() {
		return "" + i;
	}

}
