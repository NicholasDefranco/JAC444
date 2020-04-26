package erdvgre;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class hvj extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel panel;
	JButton button;
	JSlider slider;

	public hvj() {
		this.setTitle("title");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		panel = new JPanel();

		panel.setLayout(new GridBagLayout());

		button = new JButton("button");

		button.addActionListener(ae -> System.out.println("hujdeu"));

		addComp(panel, button, 0, 1, 100, 40, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE);

		slider = new JSlider();
		slider.addChangeListener(ce -> System.out.println(slider.getValue()));

		addComp(panel, slider, 1, 1, 200, 10, GridBagConstraints.SOUTH,
				GridBagConstraints.NONE);


		this.add(panel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.pack();
		this.setVisible(true);

	}

	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos,
			int compWidth, int compHeight, int place, int stretch) {

		GridBagConstraints gridConstraints = new GridBagConstraints();

		gridConstraints.gridx = xPos;
		gridConstraints.gridy = yPos;
		gridConstraints.gridwidth = compWidth;
		gridConstraints.gridheight = compHeight;
		gridConstraints.weightx = 100;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(5, 5, 5, 5);
		gridConstraints.anchor = place;
		gridConstraints.fill = stretch;

		thePanel.add(comp, gridConstraints);

	}

	public static void main(String[] args) {
		new hvj();
	}

}
