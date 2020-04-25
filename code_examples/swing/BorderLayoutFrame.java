package swing;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

//@SuppressWarnings("serial")
public class BorderLayoutFrame extends JFrame {

	public BorderLayoutFrame() {
		// Set BorderLayout with horizontal gap 5 and vertical gap 10
		setLayout(new BorderLayout(20, 40));

		JButton jbtNorth = new JButton("North");
		Color color = new Color(0,0,255);
		jbtNorth.setBackground(color);
		jbtNorth.setForeground(new Color(255,0,0));//set color

		jbtNorth.setBackground(Color.BLUE);


		// Add buttons to the frame
		add(new JButton("East"), BorderLayout.EAST);
		add(new JButton("South"), BorderLayout.SOUTH);
		add(new JButton("West"), BorderLayout.WEST);
		add(jbtNorth, BorderLayout.NORTH);
		add(new JButton("Center"), BorderLayout.CENTER);
	}

	/** Main method */
	public static void main(String[] args) {
		BorderLayoutFrame frame = new BorderLayoutFrame();
		frame.setTitle("ShowBorderLayout");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		frame.setResizable(false);
		frame.setVisible(true);
	}

}
