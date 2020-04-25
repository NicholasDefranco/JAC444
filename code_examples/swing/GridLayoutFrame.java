package swing;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.GridLayout;

//@SuppressWarnings("serial")
public class GridLayoutFrame extends JFrame {

    public GridLayoutFrame() {
        // Set GridLayout, 3 rows, 2 columns, and gaps 5 between
        // components horizontally and vertically
        setLayout(new GridLayout(3, 6, 20, 20));

        // Add labels and text fields to the frame
        add(new JLabel("First Name"));
        add(new JTextField(8));
        add(new JLabel("MI"));
        add(new JTextField(10));
        add(new JLabel("Last Name"));
        add(new JTextField(10));
    }

    /** Main method */
    public static void main(String[] args) {
        GridLayoutFrame frame = new GridLayoutFrame();
        frame.setTitle("ShowGridLayout");
        frame.setSize(300, 125);
//        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
