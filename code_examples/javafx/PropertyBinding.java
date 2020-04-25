package JavaFx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class PropertyBinding {
	public static void main(String[] args) {
		DoubleProperty d1 = new SimpleDoubleProperty(3);
		DoubleProperty d2 = new SimpleDoubleProperty(2);
		d1.bind(d2);
		System.out.println("d1 is " + d1.getValue() + " and d2 is "
				+ d2.getValue());
		d1.setValue(70.2);
		System.out.println("d1 is " + d1.getValue() + " and d2 is "
				+ d2.getValue());
	}
}
