import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ColourGame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -5703615086630718897L;

	public ColourGame() {
		// basic configuration...
		this.setTitle("Colour Game");
		this.setSize(650, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// sets font options on a label and adds it to a newly created panel
	// which is returned
	private static JPanel createCentredLabel(String text, int size, Color colour) throws IllegalArgumentException {
		if(size < 0)
			throw new IllegalArgumentException("Size cannot be negative");

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel label = new JLabel(text);
		label.setFont(new Font("Times New Roman", Font.BOLD, size));

		if(colour != null)
			label.setForeground(colour);

		panel.add(label);
		return panel;
	}

	// sets constraints on the component and adds it to a newly created panel
	// which is returned
	private static JPanel createCentredComponent(JComponent comp, Insets insets, Dimension d) throws IllegalArgumentException {
		if(comp == null || insets == null)
			throw new IllegalArgumentException("Value of JComponent or Insets is NULL");

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		JPanel panel = new JPanel(gridbag);
		c.insets = insets;

		if(d != null)
			comp.setPreferredSize(d);

		gridbag.setConstraints(comp, c);
		panel.add(comp);
		return panel;
	}

	public void init() {
		// main panel
		JPanel panel = new JPanel(new BorderLayout(0, 20));

		// Bottom section
		panel.add(createCentredComponent(new JLabel("> Choose the colour of the provided items"), new Insets(90, 0, 0, 0), null), BorderLayout.CENTER);
		panel.add(createCentredComponent(new JButton("Start"), new Insets(10, 10, 10, 10), new Dimension(580, 60)), BorderLayout.SOUTH);

		// Top section
		JPanel topPanel = new JPanel(new BorderLayout(-9, -9));
		topPanel.add(createCentredLabel("Welcome", 20, null), BorderLayout.NORTH);
		topPanel.add(createCentredLabel("to the", 17, null), BorderLayout.CENTER);
		topPanel.add(createCentredLabel("Colour Game", 20, Color.red), BorderLayout.SOUTH);
		panel.add(topPanel, BorderLayout.NORTH);

		// Finalizing...
		this.add(panel);
		this.setVisible(true);
	}

}
