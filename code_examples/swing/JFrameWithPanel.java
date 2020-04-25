package swing;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyJFrameUsingJPanel extends JFrame {

	private JButton jbtOk;
	private JButton jbtCancel;
	private JPanel panel;

	public MyJFrameUsingJPanel(String title) {

		panel = new JPanel();

		jbtOk = new JButton("OK");
//		this.jbtOk.setText("New OK");
		panel.add(jbtOk);

		jbtCancel = new JButton("Cancel");
		panel.add(jbtCancel);

		this.add(panel);
		this.setTitle(title);
		this.setSize(400, 300); // Set the frame size
//		this.pack();
		this.setLocationRelativeTo(null);// Center a frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // Display the frame
		this.setResizable(false);
	}

	public static void main(String[] args) {
		MyJFrameUsingJPanel myFrame = new MyJFrameUsingJPanel("My Frame");
	}
}
