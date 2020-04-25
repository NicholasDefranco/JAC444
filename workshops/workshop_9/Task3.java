
import java.util.HashSet;
import java.util.Iterator;

// NOTE: even though an exception is thrown the application
// will still run as the exception only affected the second
// thread. The first thread will still be able to add new
// elements in the set.
public class Task3 {

	// constant for the amount of elements to be
	// added in the hash set
	public static final int NUM_ELEMENTS = 8;

	public static HashSet<Integer> set;

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {

			// first thread is responsible for creating the thread...
			set = new HashSet<>();
			// ...as well as populating the thread
			try {
				for(int i = 0; i < NUM_ELEMENTS; i++) {
					set.add(i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			while(set == null);

			// second thread will iterate through the
			// set as the first thread is added new elements
			// this will ultimately cause an exception
			Iterator<Integer> iter = set.iterator();
			try {
				while(iter.hasNext()) {
					System.out.println(iter.next());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();

		// sleeping ensures the first the thread has a
		// chance to initialize the set and insert
		// at least one element
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// starting this thread will cause a
		// ConcurrentModificationException!
		t2.start();

	}

}
