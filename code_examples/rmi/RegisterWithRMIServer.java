package rmi;
import java.rmi.registry.*;

public class RegisterWithRMIServer {
	/** Main method */
	public static void main(String[] args) {
		try {
			StudentServerInterface obj = new StudentServerInterfaceImpl();
			Registry registry1 = LocateRegistry.getRegistry();
			registry1.rebind("student", obj);
//			System.out.println("Student server " + obj.toString() + " registered");
			System.out.println("Student server student1 registered");

//			$01StudentServerInterface obj2 = new $02StudentServerInterfaceImpl();
//			Registry registry2 = LocateRegistry.getRegistry("localhost", 1100);
//			registry2.rebind("student2", obj2);
////			System.out.println("Student server " + obj.toString() + " registered");
//			System.out.println("Student server student2 registered");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
