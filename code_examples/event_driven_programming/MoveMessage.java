package EventDrievn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MoveMessage extends JFrame {
  public _09MoveMessageDemo() {

	// Create a MovableMessagePanel instance for moving a message
    MovableMessagePanel p = new MovableMessagePanel("Hi");

    // Place the message panel in the frame
    setLayout(new BorderLayout());
    this.add(p);
  }

  /** Main method */
  public static void main(String[] args) {
    MoveMessage frame = new MoveMessage();
    frame.setTitle("MoveMessageDemo");
    frame.setSize(200, 100);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  // Inner class: MovableMessagePanel draws a message
  static class MovableMessagePanel extends JPanel {
    private String message = "Welcome to JAC444S1Q";
    private int x = 20;
    private int y = 20;

    /** Construct a panel to draw string s */
    public MovableMessagePanel(String s) {
      this.message = s;
      this.addMouseMotionListener(new MouseMotionListener() {
        /** Handle mouse-dragged event */
        public void mouseDragged(MouseEvent e) {
          // Get the new location and repaint the screen
          x = e.getX();
          y = e.getY();
          repaint();
        }

        /** Handle mouse-moved event */
        public void mouseMoved(MouseEvent e) {
        }
      });
    }

    /** Paint the component */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawString(message, x, y);
    }
  }
}
