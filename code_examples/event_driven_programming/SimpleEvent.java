package EventDrievn;

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleEvent extends JFrame {

	public JButton jbtOK;
	public JButton jbtCancel;
	// public JLabel jlbl;

	public static void main(String[] a) {
		SimpleEvent myFrame = new SimpleEvent();
		myFrame.pack();
		myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

	public SimpleEvent() {

		jbtOK = new JButton("OK");
		jbtCancel = new JButton("Cancel");
		// jlbl = new JLabel();
		JPanel panel = new JPanel();

		panel.add(jbtOK);
		panel.add(jbtCancel);
		// panel.add(jlbl);

		this.add(panel);

//		OKListener okListener = new OKListener();
//		CancelListener cancelListener = new CancelListener();
		ButtonListener buttonListener = new ButtonListener();

//		jbtOK.addActionListener(okListener);
//		jbtCancel.addActionListener(new CancelListener());
		jbtOK.addActionListener(buttonListener);
		jbtCancel.addActionListener(buttonListener);
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == jbtOK)
				System.out.println("OK cliked");
			else if (event.getSource() == jbtCancel)
				System.out.println("Cancel cliked");

		}
	}
}



// class OKListener implements ActionListener {
// @Override
// public void actionPerformed(ActionEvent event) {
// System.out.println("OK cliked");
//// jlbl.setText("OK");
//// if (event.getSource() == jbtOK)
//// System.out.println("OK cliked");
//// else if (event.getSource() == jbtCancel)
//// System.out.println("Cancel cliked");
//
// }
// }

// class CancelListener implements ActionListener {
// @Override
// public void actionPerformed(ActionEvent event) {
// System.out.println("Cancel cliked");
//
// }
// }
