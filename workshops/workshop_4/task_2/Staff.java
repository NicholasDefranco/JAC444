package week5;

public class Staff extends Employee {

	private String title;

	// custom constructor
	public Staff(String n, String a, String p, String e, String o, double s, MyDate d, String t) {
		super(n, a, p, e, o, s, d);
		title = t;
	}

	// accessors
	public String getTitle() {
		return title;
	}

	public String toString() {
		return super.toString() + "  Title: \"" + title + '\"';
	}

}
