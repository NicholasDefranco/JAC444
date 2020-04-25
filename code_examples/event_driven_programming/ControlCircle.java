package EventDrievn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ControlCircle extends JFrame {
	private JButton jbtEnlarge = new JButton("Enlarge");
	private JButton jbtShrink = new JButton("Shrink");
	private CirclePanel canvas = new CirclePanel();

	public ControlCircle() {
		JPanel panel = new JPanel(); // Use the panel to group buttons
		panel.add(jbtEnlarge);
		panel.add(jbtShrink);

		this.add(canvas, BorderLayout.CENTER); // Add canvas to center
		this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame

		jbtEnlarge.addActionListener(new EnlargeListener());
		jbtShrink.addActionListener(new ShrinkListener());
	}

	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new _05ControlCircle();
		frame.setTitle("ControlCircle");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	class EnlargeListener implements ActionListener {	// Inner class
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.enlarge();
		}
	}

	class ShrinkListener implements ActionListener {	// Inner class
		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.shrink();
		}
	}

	class CirclePanel extends JPanel {	// Inner class
		private int radius = 10; // Default circle radius

		/** Enlarge the circle */
		public void enlarge() {
//			radius++;
			radius += 30;
			this.repaint();
		}

		/** Shrink the circle */
		public void shrink() {
//			radius--;
			radius -= 4;
			this.repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
		}
	}
}
