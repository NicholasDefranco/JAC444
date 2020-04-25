package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentServerInterface extends Remote {
	/**
	 * Return the score for the specified name
	 *
	 * @param name the student name
	 * @return a double score or �1 if the student is not found
	 */
	public double findScore(String name) throws RemoteException;
}
