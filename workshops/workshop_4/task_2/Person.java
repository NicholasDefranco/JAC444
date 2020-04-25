package week5;

public class Person {

	private String name;
	private String addr;
	private String phone;
	private String email;

	// custom constructor
	public Person(String n, String a, String p, String e) {
		name = n;
		addr = a;
		phone = p;
		email = e;
	}

	// accessors
	public final String getName() {
		return name;
	}

	public final String getAddress() {
		return addr;
	}

	public final String getPhone() {
		return phone;
	}

	public final String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return this.getClass() + " Name: " + name + "  Email: " + email;
	}


}
