import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Colours extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -4272553635603653475L;

	private static GridBagLayout gridbag = new GridBagLayout();
	private static GridBagConstraints c = new GridBagConstraints();

	private static final String[] colours = {
		"Red", "Blue", "Green", "Black", "White"
	};

	public Colours() {
		// basic configuration...
		this.setTitle("Colors");
		this.setSize(610, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
	}

	// sets constraints on component and adds it to the panel
	private static void insertComp(JPanel p, JComponent comp, Dimension d) {
		if(p == null || comp == null)
			throw new IllegalArgumentException("the panel and the component cannot be NULL");

		if(d != null)
			comp.setPreferredSize(d);

		gridbag.setConstraints(comp, c);
		p.add(comp);
	}

	public void init() {
		JPanel panel = new JPanel(new BorderLayout());

		// top section
		c.insets = new Insets(7, 7, 7, 7);
		JPanel comboPanel = new JPanel(gridbag);
		JComboBox<String> colourList = new JComboBox<>(colours);
		colourList.setPreferredSize(new Dimension(500, 30));
		gridbag.setConstraints(colourList, c);
		comboPanel.add(colourList);
		panel.add(comboPanel, BorderLayout.NORTH);

		JPanel checkPanel = new JPanel(new FlowLayout());
		checkPanel.add(new JCheckBox());
		checkPanel.add(new JLabel("Background"));
		checkPanel.add(new JCheckBox());
		checkPanel.add(new JLabel("Foreground"));
		panel.add(checkPanel, BorderLayout.CENTER);

		// bottom section
		JPanel botPanel = new JPanel(gridbag);
		c.insets = new Insets(10, 10, 10, 15);
		Dimension d = new Dimension(90, 25);
		insertComp(botPanel, new JButton("Ok"), d);
		insertComp(botPanel, new JButton("Cancel"), d);
		this.add(botPanel, BorderLayout.SOUTH);

		// finalizing...
		this.add(panel, BorderLayout.NORTH);
		this.setVisible(true);
	}
}
