package week5;

import java.util.ArrayList;

public class Task2 {

	public static void main(String[] args) {

		// create and populate array list with instances
		// of the newly created custom classes...
		ArrayList<Person> arr = new ArrayList<>();
		arr.add(new Person("billy", "123 Main St", "123456789", "billy@email.com"));
		arr.add(new Student("bob", "321 Cool St", "987654321", "bob@email.com", StatusType.FRESHMAN));
		arr.add(new Employee("emp", "789 Wow St", "564738291", "emp@email.com", "B1200", 50000.0, new MyDate(-System.currentTimeMillis())));
		arr.add(new Faculty("Fac", "789 Some St", "564738291", "fac@email.com", "B1200", 50000.0, new MyDate(2019, 2, 28), 8, 4, Rank.B));
		arr.add(new Faculty("InvalidDateFac", "789 CPP St", "564738291", "invaliddatefac@email.com", "B1200", 50000.0, new MyDate(2019, 1, 29), 8, 4, Rank.D));
		arr.add(new Faculty("InvalidDateFac2", "789 CPP St", "564738291", "invaliddatefac2@email.com", "B1200", 50000.0, new MyDate(2019, 12, 15), 8, 4, Rank.D));
		arr.add(new Staff("staff", "789 Java St", "564738291", "staff@email.com", "B1200", 50000.0, new MyDate(), "Cool Title"));

		try {
			arr.add(new Staff("InvlidSalStaff", "789 Java St", "564738291", "invalidsalstaff@email.com", "B1200", -10000.0, new MyDate(), "Cool Title"));
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}

		// print the information to the screen...
		System.out.println("Information");
		System.out.println("-----------");
		for(Person p : arr) {
			System.out.println(p);
		}

	}

}
