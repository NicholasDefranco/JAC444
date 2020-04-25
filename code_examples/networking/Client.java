package networking;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Client extends JFrame {
	Socket socket = null; // if we do not initialize it then we get an exception later on
	// Text field for receiving radius
	private JTextField jtf = new JTextField();

	// Text area to display contents
	private JTextArea jta = new JTextArea();

	// IO streams
	private DataOutputStream toServer;
	private DataInputStream fromServer;

	public Client() {
		// Panel p to hold the label and text field
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JLabel("Enter radius:   "), BorderLayout.WEST);
		p.add(jtf, BorderLayout.CENTER);
//		jtf.setHorizontalAlignment(JTextField.RIGHT);

		setLayout(new BorderLayout());
		add(p, BorderLayout.NORTH);
		add(new JScrollPane(jta), BorderLayout.CENTER);

		jtf.addActionListener(new TextFieldListener());

		setTitle("Client");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // It is necessary to show the frame here!

		try {
			socket = new Socket("localhost", 8000);
//			socket = createSocket("localhost", 8000);
			jta.setFont(new Font("Dialog", Font.PLAIN, 18));
			jta.append("Server is up now!\n");
//			System.out.println("local port: " + socket.getLocalPort());

			// Create an input stream to receive data from the server
			fromServer = new DataInputStream(socket.getInputStream());
			// Create an output stream to send data to the server
			toServer = new DataOutputStream(socket.getOutputStream());
		}
		catch (IOException ex) {
			jta.append(ex.toString() + '\n');
		}
	}

//	@SuppressWarnings("resource")
//	public static Socket createSocket(String serverAddress, int serverPort) {
//		Socket socket;
//		try {
//			socket = new Socket(serverAddress, serverPort);
////		} catch (UnknownHostException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
//		} catch (IOException e) {
//			socket = createSocket(serverAddress, serverPort);
//		}
//		return socket;
//	}

	private class TextFieldListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// Get the radius from the text field
				double radius = Double.parseDouble(jtf.getText().trim()); // trim delete the whitespace of beginning and end

				// Send the radius to the server
				toServer.writeDouble(radius);


				// Get area from the server
				double area = fromServer.readDouble();

				// Display to the text area
				jta.append("Radius is " + radius + "\n");
				jta.append("Area received from the server is " + area + '\n');
			}
			catch (NumberFormatException ex) {
				jta.append("You should enter a number!\n");
			}
			catch (Exception ex) {
				System.err.println(ex);
			}
		}
	}

	public static void main(String[] args) {
		new Client();
	}

}
