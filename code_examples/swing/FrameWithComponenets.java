package swing;
import javax.swing.*;

public class FrameWithComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame1 = new JFrame("MyFrameWithComponents");
		JButton jbtok = new JButton("ok");
		frame1.add(jbtok);
		JButton jbtcancel = new JButton("cancel");
		frame1.add(jbtcancel);

		frame1.setSize(400, 300);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);

	}

}
