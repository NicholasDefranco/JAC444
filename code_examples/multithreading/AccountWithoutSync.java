package multithreading;

import java.util.concurrent.*;

public class AccountWithoutSync {
	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
//		ExecutorService executor = Executors.newFixedThreadPool(10);

		// Create and launch 100 threads
		for (int i = 0; i < 2000; i++) {
			executor.execute(new AddAPennyTask());
		}

		executor.shutdown();

		// Wait until all tasks are finished
		while (!executor.isTerminated()) {
		}

		System.out.println("What is balance? " + account.getBalance());
	}

	// A thread for adding a penny to the account
	private static class AddAPennyTask implements Runnable {
		public void run() {
			synchronized (account) {// critical point(lines 29-32), there will be a luck on account and no threads can access to the account object
//				System.out.println(account.getBalance());
				account.deposit(1);
			}
		}
	}

	// An inner class for account
	private static class Account {
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

//		public synchronized void deposit(int amount) {
		public void deposit(int amount) {
			int newBalance = balance + amount;
			balance = balance + amount;

			// This delay is deliberately added to magnify the
			// data-corruption problem and make it easy to see.
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException ex) {
//			}

			balance = newBalance;
		}
	}
}
