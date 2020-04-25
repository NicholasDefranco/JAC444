package week5;

public class Faculty extends Employee {

	private final static int MAX_TIME = 24;

	// 24 hour time was used
	// default time is 9:00 - 5:00
	private int start = 9;
	private int end = 17;

	// enumeration
	private Rank rank = Rank.D;

	// custom constructor
	public Faculty(String n, String a, String p, String e, String o, double s, MyDate d, int st, int en, Rank r) {
		super(n, a, p, e, o, s, d);
		this.rank = r;

		if(st < end && en < MAX_TIME && st > 0) {
			this.start = st;
			this.end = en;
		}
	}

	// accessors
	public String getHours() {
		return start + " - " + end;
	}

	public Rank getRank() {
		return rank;
	}

	// NOTE: since the start and end times are integers, they can only represent
	// full hours. Thus, I concatenated the string ":00" to the end of the
	// times specified by the data members
	public String toString() {
		return super.toString() + "  Rank: " + rank + "  Hours: " + start + ":00 - " + end + ":00";
	}

}
