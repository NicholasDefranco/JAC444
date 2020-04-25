package EventDrievn;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AnonymousListener extends JFrame {
	public AnonymousListener() {
		// Create four buttons
		JButton jbtNew = new JButton("New");
		JButton jbtOpen = new JButton("Open");
		JButton jbtSave = new JButton("Save");
		JButton jbtPrint = new JButton("Print");

		// Create a panel to hold buttons
		JPanel panel = new JPanel();
		panel.add(jbtNew);
		panel.add(jbtOpen);
		panel.add(jbtSave);
		panel.add(jbtPrint);

		this.add(panel);

		// Create and register anonymous inner-class listener
		jbtNew.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Process New");
				}
		});

		jbtOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Open");
			}
		});

		jbtSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Process Save");
			}
		});

		jbtPrint.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Process Print");
				}
		});
	}

	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new AnonymousListener();
		frame.setTitle("AnonymousListenerDemo");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		pack() method automatically sizes the frame
//		according to the size of the components placed in it.
		frame.pack();
		frame.setVisible(true);
	}
}
