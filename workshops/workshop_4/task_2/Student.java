package week5;

public class Student extends Person {

	// enumeration
	private final StatusType status;

	// custom constructor
	public Student(String n, String a, String p, String e, StatusType t) {
		super(n, a, p, e);
		status = t;
	}

	// accessor
	public StatusType getStatus() {
		return status;
	}

	public String toString() {
		return super.toString() + "  Status: " + status;
	}

}
