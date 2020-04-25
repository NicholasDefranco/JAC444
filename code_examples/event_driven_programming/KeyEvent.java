package EventDrievn;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class KeyEvent extends JFrame {
  private KeyboardPanel keyboardPanel = new KeyboardPanel();

  /** Initialize UI */
  public KeyEvent() {
    // Add the keyboard panel to accept and display user input
    keyboardPanel.setBackground(Color.YELLOW);
    this.add(keyboardPanel);

    // Set focus
    // Only a focused component can receive KeyEvent.
    // To make a component focusable, set its focusable property to true.
    keyboardPanel.setFocusable(true);
  }

  /** Main method */
  public static void main(String[] args) {
    KeyEvent frame = new KeyEvent();
    frame.setTitle("KeyEventDemo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

  // Inner class: KeyboardPanel for receiving key input
  static class KeyboardPanel extends JPanel {
	  private int x = 100;
	  private int y = 100;
	  private char keyChar = 'A'; // Default key
//	  private int keyCode = 0;

	    public KeyboardPanel() {
	      addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	          switch (e.getKeyCode()) {
	            case KeyEvent.VK_DOWN: y += 10; break;
	            case KeyEvent.VK_UP: y -= 10; break;
	            case KeyEvent.VK_LEFT: x -= 10; break;
	            case KeyEvent.VK_RIGHT: x += 10; break;
	            default: keyChar = e.getKeyChar();
//	            default: keyCode = e.getKeyCode();
//	            System.out.println(e.getKeyCode());
//	            System.out.println((int)('a'));

	          }

	          repaint();
	        }
	      });


    }

    /** Draw the character */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
//      g.setBackground();
      g.drawString(String.valueOf(keyChar), x, y);
//      g.drawString(String.valueOf(keyCode), x, y);
    }
  }
}
