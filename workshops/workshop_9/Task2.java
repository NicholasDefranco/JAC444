
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2 {

	// constant for the amount of threads
	public final static int THREAD_AMOUNT = 1000;

	// CustomInteger is my wrapper class for an integer
	public static CustomInteger sum;

	// Initialize my Customer integer instance inside static block
	static {
		sum = new CustomInteger();
	}

	public static void main(String[] args) {

		// create a pool of 1000 threads
		ExecutorService executor = Executors.newCachedThreadPool();

		// give each thread in the pool a task of
		// incrementing the sum
		for(int i = 0; i < THREAD_AMOUNT; i++) {
			executor.execute(() -> {
				sum.increment();
			});
		}

		// stop accepting new tasks
		executor.shutdown();

		// wait for all threads to finish
		while(!executor.isTerminated());

		// The incrementing operations may have interleaved
		System.out.println("The value of the integer is: " + sum);

	}

}
