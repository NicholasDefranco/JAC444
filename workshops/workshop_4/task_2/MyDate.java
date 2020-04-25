package week5;

import java.sql.Date;

public class MyDate {

	// Note: if invalid data was received, data will be defaulted
	// to represent the current day
	private int year;
	private int month;
	private int day;

	private final static String[] MONTHS = {
		"January", "Febuary", "March", "April", "May", "June",
		"July", "August", "Spectember", "October", "November",
		"December"
	};

	// determines how many days are in a given
	// month within a given year.
	//
	// This code was given to all students in the OOP244 (Winter 2019)
	// Milestone 1 assignment. I did not write this function.
	// Full credit goes to Chris Szalwinski
	private static int mdays(int y, int m) {
		int days[] = {
				31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
				30, 31, -1
		};

		int month = m >= 1 && m <= 12 ? m : 13;
		month--;

		return days[month] + ((((month == 1 ? 1 : 0) *
				(((y % 4 == 0) && (y % 100 != 0)) ? 1 : 0) != 0)
				|| (y % 400 == 0)) ? 1 : 0);
	}

	// default constructor
	public MyDate() {
		setDate(System.currentTimeMillis());
	}

	// custom 1-arg constructor
	public MyDate(long elapsedTime) {
			setDate(elapsedTime);
	}

	// custom 3-arg constructor
	public MyDate(int y, int m, int d) {
		// instructions specified month should be zero-based.
		// Hence the condition for the variable m
		if(y > 0 && m >= 0 && m < 12 && d >= 1 && d <= mdays(y, m + 1)) {
			this.year = y;
			this.month = m;
			this.day = d;
		} else {
			setDate(System.currentTimeMillis());
		}
	}

	// accessors
	public int getYear() {
		return year;
	}

	public String getMonth() {
		return MONTHS[month];
	}

	public int getDay() {
		return day;
	}

	// sets the data members according to the date
	// represented by the parameter (milliseconds since Jan 1st 1970)
	public void setDate(long elapsedTime) {
		if(elapsedTime < 0 || elapsedTime > System.currentTimeMillis()) {
			elapsedTime = System.currentTimeMillis();
		}

		String[] strs = (new Date(elapsedTime)).toString().split("-");
		year = Integer.parseInt(strs[0]);

		// subtracting one is required for making the month data member
		// zero-based as the instructions require.
		month = Integer.parseInt(strs[1]) - 1;
		day = Integer.parseInt(strs[2]);

	}

	public String toString() {
		return MONTHS[month] + " " + day + " " + year;
	}

}
