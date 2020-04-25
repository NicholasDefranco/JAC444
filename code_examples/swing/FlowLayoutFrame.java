package swing;
import java.awt.*;

import javax.swing.*;

public class FlowLayoutFrame extends JFrame {

	public FlowLayoutFrame(){

//		FlowLayout myFlowLayout = new FlowLayout(FlowLayout.RIGHT, 20, 30);
		setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 30));

//		JLabel jlbl1 = new JLabel("First Name");
		add(new JLabel("First Name"));// adding "this"
		add(new JTextField(8));
		add(new JLabel("MI"));
		add(new JTextField(2));
		add(new JLabel("Last Name"));
		add(new JTextField(20));
	}

	public static void main(String[] args){
		FlowLayoutFrame myFrame = new FlowLayoutFrame();
		myFrame.setSize(250,250);
		myFrame.setVisible(true);
	}

}
