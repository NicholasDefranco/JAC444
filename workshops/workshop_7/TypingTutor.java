import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class TypingTutor extends JFrame {
	// constants
	private static final long serialVersionUID = -8605678760403561630L;
	private static final Color DEFUALTCOLOUR = new JButton().getBackground();

	private static final int HEIGHT = 55;

	private static final int TILDE = 192;
	private static final int PLUS = 61;
	private static final int COLON = 59;
	private static final int QUESTION = 47;


	// data members
	private JTextArea area = new JTextArea();
	private HashMap<Integer, JButton> map = new HashMap<>();

	private boolean upper = false;
	private boolean caps = false;
	private boolean shift = false;
	private int currCol = 0;

	// mouse listener
		private MouseListener mouselistener = new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				int off = area.getCaretPosition();
				try {
					currCol = off - area.getLineStartOffset(area.getLineOfOffset(off));
				} catch (BadLocationException e1) {}
			}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		};

		// key listener
		private KeyListener keylistener = new KeyListener() {
				public void keyTyped(KeyEvent e) {
					JButton but = map.get(e.getKeyCode());
					if(but == null)
						return;

					if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
						caps = !caps;
						but.setBackground(caps ? Color.GRAY : DEFUALTCOLOUR);
					} else {
						but.setBackground(Color.GRAY);
					}
				}

				@Override
				public void keyPressed(KeyEvent e) {
					JButton but = map.get(e.getKeyCode());
					if(but == null)
						return;

					if(e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
						caps = !caps;
						but.setBackground(caps ? Color.GRAY : DEFUALTCOLOUR);
					} else {
						but.setBackground(Color.GRAY);
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					JButton but = map.get(e.getKeyCode());
					if(but == null || e.getKeyCode() == KeyEvent.VK_CAPS_LOCK)
						return;

					but.setBackground(DEFUALTCOLOUR);
				}
			};


		// button listener
		private ActionListener keyListen = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e)
	        {
				if(e.getActionCommand().equalsIgnoreCase("TAB")) {
					area.replaceSelection("\t");
				} else if(e.getActionCommand().equalsIgnoreCase("CAPS")) {
					upper = !upper;
					((JButton)e.getSource()).setForeground(upper ? Color.BLUE : Color.BLACK);
				} else if(e.getActionCommand().equalsIgnoreCase("ENTER")) {
					area.replaceSelection("\n");
				} else if(e.getActionCommand().equalsIgnoreCase("Shift")) {
					shift = true;
					((JButton)e.getSource()).setForeground(Color.BLUE);
				} else if(e.getActionCommand().equalsIgnoreCase("Backspace")) {
					try {
						area.getDocument().remove(area.getCaretPosition() - 1, 1);
					} catch (BadLocationException e1) {}
	        	} else if(e.getActionCommand().equals(">")) {
	        		int curr = area.getCaretPosition();
	        		area.setCaretPosition(curr + 1);
	        		try {
						currCol = curr - area.getLineStartOffset(area.getLineOfOffset(curr));
					} catch (BadLocationException e1) {}
	        	} else if(e.getActionCommand().equals("<")) {
	        		int curr = area.getCaretPosition();
	        		area.setCaretPosition(curr - 1);
	        		try {
						currCol = curr - area.getLineStartOffset(area.getLineOfOffset(curr));
					} catch (BadLocationException e1) {}
	        	} else if(e.getActionCommand().equals("/\\")) {
	        		changeRow(-1);
	        	} else if(e.getActionCommand().equals("\\/")) {
	        		changeRow(1);
	        	} else {
	        		int curr = area.getCaretPosition();
					area.replaceSelection(upper ^ shift ? e.getActionCommand() : e.getActionCommand().toLowerCase());
					try {
						currCol = curr - area.getLineStartOffset(area.getLineOfOffset(curr));
					} catch (BadLocationException e1) {}
					if(shift) {
						shift = false;
						map.get(KeyEvent.VK_SHIFT).setForeground(Color.BLACK);
					}
				}
	        }
	    };

	// setup
	public TypingTutor() {
		this.setTitle("Typing Tutor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(860, 550);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	// moves cursor to another line (row) given the number of lines
	// to move relative to the current line
	public void changeRow(int n) {
		int off = area.getCaretPosition();
		try {
			int line = area.getLineOfOffset(off);
			int offPrevEnd = area.getLineEndOffset(line + n);
			int offPrevStart = area.getLineStartOffset(line + n);
			if(currCol > offPrevEnd - offPrevStart) {
				area.setCaretPosition(offPrevEnd);
			} else {
				area.setCaretPosition(offPrevStart + currCol);
			}
		} catch (BadLocationException e1) {}
	}


    // creates a new button given data received in the parameter list
    // and adds it to the hashmap
	private void createButton(JComponent c, String text, int code, int width) {
		JButton b = new JButton(text);

		b.setPreferredSize(new Dimension(width, HEIGHT));
		b.setBackground(DEFUALTCOLOUR);
        b.addActionListener(keyListen);

		c.add(b);
		map.put(code, b);
	}
	private void createButton(JComponent c, String text, int code) {
		createButton(c, text, code, HEIGHT);
	}

	public void init() {
		// top section - labels and text area
		JPanel top = new JPanel(new BorderLayout());

		JPanel labels = new JPanel(new BorderLayout());
		JLabel l = new JLabel("       Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.");
		top.add(l, BorderLayout.NORTH);
		JLabel l2 = new JLabel("       Note: Clicking the buttons with your mouse will not perform any action.");
		top.add(l2, BorderLayout.CENTER);
		labels.add(top, BorderLayout.NORTH);

		JPanel paneArea = new JPanel(new FlowLayout());
		paneArea.add(new JLabel("     "));
		area.setPreferredSize(new Dimension(830, 175));
		area.setFocusable(true);
		area.setLineWrap(true);
		area.addMouseListener(mouselistener);
		area.addKeyListener(keylistener);
		paneArea.add(area);

		top.add(paneArea, BorderLayout.SOUTH);
		////


		// bottom - keyboard section
		JPanel keyboard = new JPanel(new BorderLayout());
		keyboard.add(new JLabel(" "), BorderLayout.NORTH);
		JPanel bot = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		bot.add(new JLabel("       "));

		createButton(bot, "~", TILDE);
		createButton(bot, "1", KeyEvent.VK_1);
		createButton(bot, "2", KeyEvent.VK_2);
		createButton(bot, "3", KeyEvent.VK_3);
		createButton(bot, "4", KeyEvent.VK_4);
		createButton(bot, "5", KeyEvent.VK_5);
		createButton(bot, "6", KeyEvent.VK_6);
		createButton(bot, "7", KeyEvent.VK_7);
		createButton(bot, "8", KeyEvent.VK_8);
		createButton(bot, "9", KeyEvent.VK_9);
		createButton(bot, "0", KeyEvent.VK_0);
		createButton(bot, "-", KeyEvent.VK_MINUS);
		createButton(bot, "+", PLUS);
		createButton(bot, "Backspace", KeyEvent.VK_BACK_SPACE, 110);

		createButton(bot, "Tab", KeyEvent.VK_TAB, 80);
		createButton(bot, "Q", KeyEvent.VK_Q);
		createButton(bot, "W", KeyEvent.VK_W);
		createButton(bot, "E", KeyEvent.VK_E);
		createButton(bot, "R", KeyEvent.VK_R);
		createButton(bot, "T", KeyEvent.VK_T);
		createButton(bot, "Y", KeyEvent.VK_Y);
		createButton(bot, "U", KeyEvent.VK_U);
		createButton(bot, "I", KeyEvent.VK_I);
		createButton(bot, "O", KeyEvent.VK_O);
		createButton(bot, "P", KeyEvent.VK_P);
		createButton(bot, "[", (int) '[');
		createButton(bot, "]", (int) ']');
		createButton(bot, "\\", KeyEvent.VK_BACK_SLASH);
		createButton(bot, "Caps", KeyEvent.VK_CAPS_LOCK, 80);
		createButton(bot, "A", KeyEvent.VK_A);
		createButton(bot, "S", KeyEvent.VK_S);
		createButton(bot, "D", KeyEvent.VK_D);
		createButton(bot, "F", KeyEvent.VK_F);
		createButton(bot, "G", KeyEvent.VK_G);
		createButton(bot, "H", KeyEvent.VK_H);
		createButton(bot, "J", KeyEvent.VK_J);
		createButton(bot, "K", KeyEvent.VK_K);
		createButton(bot, "L", KeyEvent.VK_L);
		createButton(bot, ":", COLON);
		createButton(bot, "\"", KeyEvent.VK_QUOTE);
		createButton(bot, "Enter", KeyEvent.VK_ENTER, 110);
		createButton(bot, "Shift", KeyEvent.VK_SHIFT, 110);
		createButton(bot, "Z", KeyEvent.VK_Z);
		createButton(bot, "X", KeyEvent.VK_X);
		createButton(bot, "C", KeyEvent.VK_C);
		createButton(bot, "V", KeyEvent.VK_V);
		createButton(bot, "B", KeyEvent.VK_B);
		createButton(bot, "N", KeyEvent.VK_N);
		createButton(bot, "M", KeyEvent.VK_M);
		createButton(bot, ",", KeyEvent.VK_COMMA);
		createButton(bot, ".", KeyEvent.VK_PERIOD);
		createButton(bot, "?", QUESTION);

		bot.add(new JLabel("      "));
		JPanel upPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 28, 0));
		createButton(bot, "/\\", KeyEvent.VK_UP);
		bot.add(upPane);

		JPanel spacePane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 70, 0));
		spacePane.add(new JLabel("                 "));
		JPanel arrowPane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		arrowPane.add(new JLabel("             "));
		createButton(spacePane, " ", KeyEvent.VK_SPACE, 300);
		createButton(arrowPane, "<", KeyEvent.VK_LEFT);
		createButton(arrowPane, "\\/", KeyEvent.VK_DOWN);
		createButton(arrowPane, ">", KeyEvent.VK_RIGHT);
		bot.add(spacePane);
		bot.add(arrowPane);

		keyboard.add(bot);

		this.add(keyboard, BorderLayout.CENTER);
		////

		// finalizing...
		this.add(labels, BorderLayout.NORTH);
		this.setVisible(true);
	}

}
