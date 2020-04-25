import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Task1 {

	// text area
	public static JTextArea area = new JTextArea();

	// sets up a frame with a text area
	public static void init() {

		JFrame f = new JFrame("Concurrent Output");
		JPanel p = new JPanel();

		area.setPreferredSize(new Dimension(450, 250));
		area.setLineWrap(true);

		p.add(area);
		f.add(p);

		f.setSize(450, 250);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		///// This code was taken from the code example
		Runnable printA = new PrintCh('a', 100);
		Runnable printB = new PrintCh('b', 100);
		Runnable print100 = new PrintNums(100);

		Thread thread1 = new Thread(printA);
	    Thread thread2 = new Thread(printB);
	    Thread thread3 = new Thread(print100);

	    thread1.setPriority(Thread.MAX_PRIORITY);

	    thread1.start();
	    thread2.start();
	    thread3.start();
	    ///////


	    // ensure the threads finish before
	    // showing the result to the user
	    try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	    init();
	}
}

// This rest of this code was taken exactly from the code example
class PrintCh implements Runnable {
	private char charToPrint;
	private int times;

	public PrintCh(char c, int t) {
		charToPrint = c;
		times = t;
	}

	public void run() {
		for (int i = 0; i < times; i++) {
			Task1.area.append(charToPrint + " "); // slight change here
		}
	}
}


class PrintNums implements Runnable {
	private int lastNum;


	public PrintNums(int n) {
		lastNum = n;
	}

	public void run() {
		for (int i = 1; i <= lastNum; i++) {
			Task1.area.append(i + " "); // slight change here
			Thread.yield();
		}
	}
}
