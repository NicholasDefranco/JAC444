import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Buttons extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -5093575046135069324L;

	private static GridBagLayout gridbag = new GridBagLayout();
	private static GridBagConstraints c = new GridBagConstraints();

	public Buttons() {
		// basic configuration...
		this.setTitle("Buttons");
		this.setSize(500, 240);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
	}

	// sets configuration options on a component and returns configured component
	// (returning reference allows me to nest calls to other methods as I did in my init() method)
	private static JComponent configComp(JComponent comp, Dimension d) throws IllegalArgumentException {
		if(comp == null)
			throw new IllegalArgumentException("comp cannot be NULL");

		if(d != null)
			comp.setPreferredSize(d);


		gridbag.setConstraints(comp, c);
		return comp;
	}

	public void init() {

		// bottom section
		JPanel bot = new JPanel(new BorderLayout());
		// first row
		JPanel first = new JPanel(gridbag);
		c.insets = new Insets(2, 2, 2, 2);
		first.add(configComp(new JButton("C"), new Dimension(80, 60)));
		first.add(configComp(new JTextField("Programming is fun!"), new Dimension(410, 60)));
		//

		bot.add(first, BorderLayout.NORTH);

		// second row
		JPanel second = new JPanel(gridbag);
		Dimension d = new Dimension(245, 60);
		c.fill = GridBagConstraints.HORIZONTAL;
		second.add(configComp(new JButton("D"), d));
		c.gridx = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		second.add(configComp(new JButton("E"), d));
		//

		bot.add(second, BorderLayout.CENTER);

		this.add(bot, BorderLayout.SOUTH);

		// top section
		JPanel top = new JPanel(gridbag);
		d = new Dimension(70, 25);
		c.insets = new Insets(10, 10, 10, 10);
		top.add(configComp(new JButton("Q"), d));
		c.gridx = 4;
		top.add(configComp(new JButton("B"), d));
		//

		this.add(top, BorderLayout.NORTH);

		// Finalizing...
		this.setVisible(true);

	}

}
