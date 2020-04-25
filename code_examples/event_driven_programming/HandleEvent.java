package EventDrievn;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
//import java.util.*;
//import java.util.Date;


@SuppressWarnings("serial")
public class HandleEvent extends JFrame {
	public HandleEvent() {

		// Create two buttons
		JButton jbtOK = new JButton("OK");
		JButton jbtCancel = new JButton("Cancel");

		// Create a panel to hold buttons
		JPanel panel = new JPanel();
		panel.add(jbtOK);
		panel.add(jbtCancel);

		add(panel); // Add panel to the frame

		// Register listeners
		OKListenerClass listener1 = new OKListenerClass();	// create listener
		CancelListenerClass listener2 = new CancelListenerClass();

		// register OKListenerClass listener with the button jbtOK
		jbtOK.addActionListener(listener1);
		// When the OK button is clicked, the actionPerformed(ActionEvent) method
		// in OKListenerClass is invoked to process the event.

		// register CancelListenerClass listener with the button jbtCancel
		jbtCancel.addActionListener(listener2);
	}

	public static void main(String[] args) {
		JFrame frame = new _02HandleEvent();
		frame.setTitle("Handle Event");
		frame.setSize(200, 150);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

// Each listener class implements ActionListener to process ActionEvent

class OKListenerClass implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK button clicked");
		System.out.println(e.getSource());
//		System.out.println(new Date(e.getWhen()));
//		System.out.println(e.getWhen());
//		System.out.println(e.getActionCommand());
//		System.out.println(e.getModifiers());
	}
}

class CancelListenerClass implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Cancel button clicked");
//		System.out.println(e.getModifiers());
	}
}
