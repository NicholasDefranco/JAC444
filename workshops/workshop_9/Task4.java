
import java.util.HashSet;
import java.util.Iterator;

// NOTE: This class is nearly identical to the Task3 class

// Another NOTE: you must wait some time before seeing some
// output as all the elements must be added first
// (by the first thread) before the second thread
// is able to traverse due to synchronization.
public class Task4 {

	// constant for the amount of elements to be
	// added in the hash set
	public static final int NUM_ELEMENTS = 6;

	public static HashSet<Integer> set;

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			set = new HashSet<>();

			// the synchronized block ensures all operations
			// performed on the set are synchronized
			// Thus, no exceptions will be thrown
			synchronized(set) {
				try {
					for(int i = 0; i < NUM_ELEMENTS; i++) {
						set.add(i);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			// wait until the other thread initialized the thread
			while(set == null);

			// the synchronized block ensures all operations
			// performed on the set are synchronized
			// Thus, no exceptions will be thrown
			synchronized(set) {
				Iterator<Integer> iter = set.iterator();
				try {
					while(iter.hasNext()) {
						System.out.println(iter.next());
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// threads will no longer cause an exception
		t1.start();
		t2.start();
	}

}
