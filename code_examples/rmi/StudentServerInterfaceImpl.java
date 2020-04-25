package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class StudentServerInterfaceImpl
		extends UnicastRemoteObject
		implements StudentServerInterface {

	/**
	 *
	 */
//	private static final long serialVersionUID = 7885832327511563989L;
	// Stores scores in a map indexed by name
	private Map<String, Double> scores = new HashMap<String, Double>();

	public StudentServerInterfaceImpl() throws RemoteException {
		initializeStudent();
	}

	/** Initialize student information */
	protected void initializeStudent() {
		scores.put("John", Double.valueOf(90.5));
		scores.put("James", Double.valueOf(100));
//		scores.put("Michael", Double.valueOf(98.5));
//		System.out.println(scores);
	}

	/**
	 * Implement the findScore method from the Student interface
	 */
	public double findScore(String name) throws RemoteException {
		Double d = (Double) scores.get(name);
		if (d == null) {
			System.out.println("Student " + name + " is not found ");
			return -1;
		} else {
			System.out.println("Student " + name + "\'s score is " + d.doubleValue());
			return d.doubleValue();
		}
	}
}
