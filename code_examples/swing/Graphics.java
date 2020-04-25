package EventDrievn;

import javax.swing.*;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Graphics extends JFrame {
	public Graphics() {
		add(new NewPanel());
	}

	public static void main(String[] args) {
		Graphics frame = new Graphics();
		frame.setTitle("TestPaintComponent");
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class NewPanel extends JPanel {
//	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 0, 50, 50);
		g.drawString("MCT337N1Q", 0, 40);
	}
}
