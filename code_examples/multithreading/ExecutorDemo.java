package multithreading;

import java.util.concurrent.*;

public class ExecutorDemo {
	public static void main(String[] args) {
		// Create a fixed thread pool with maximum three threads
//		ExecutorService executor = Executors.newFixedThreadPool(1);
//		ExecutorService executor = Executors.newFixedThreadPool(2);
		ExecutorService executor = Executors.newCachedThreadPool();

		// Submit runnable tasks to the executor
		executor.execute(new PrintChar('a', 10000));
		executor.execute(new PrintChar('b', 10000));
		executor.execute(new PrintNum(500));


		// Shut down the executor
		executor.shutdown();// no new task is allowed to be executed

		try {
			executor.execute(new PrintChar('c', 2000));		// try to execute a new task throws exception
		} catch (RejectedExecutionException ex) {
			System.out.println("\nYou cannot execute any new Task");
		}

	}
}
