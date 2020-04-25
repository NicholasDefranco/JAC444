package week5;

public class Employee extends Person {

	private String office;
	private MyDate hireDate;

	private double salary = 45000.0;

	// custom constructor
	public Employee(String n, String a, String p, String e, String o, double s, MyDate d) throws IllegalArgumentException {
		super(n, a, p, e);

		if(s <= 0.0)
			throw new IllegalArgumentException("Failure constructing " + getName() + ": Salary cannot be negative nor zero");

		office = o;
		hireDate = d;


	}

	// accessors
	public String getOffice() {
		return office;
	}

	public double getSalary() {
		return salary;
	}

	public MyDate getHireDate() {
		return hireDate;
	}

	public String toString() {
		return super.toString() + "  Office: " + office + "  Salary: " + salary + "  Hired: " + hireDate;
	}

}
