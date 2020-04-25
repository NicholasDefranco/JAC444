package networking;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Server extends JFrame {
	// Text area for displaying contents
	private JTextArea jta = new JTextArea();
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream inputFromClient;
	private DataOutputStream outputToClient;
	private int port = 8000;

	public Server() {
		// Place text area on the frame
		setLayout(new BorderLayout());
		jta.setFont(new Font("Dialog", Font.PLAIN, 18));
		add(new JScrollPane(jta), BorderLayout.CENTER);

		setTitle("Server");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // It is necessary to show the frame here!

		try { // eg, host name is not found , or it is wrong

			// Create a server socket
			serverSocket = new ServerSocket(port);
			jta.append("Server started at " + new Date() + '\n');
			jta.append("Waiting for Connection ...\n");

			// server Listen for a connection request to client
			socket = serverSocket.accept(); //accept() works like nextInt(), waits until client send request
			jta.append("Connection Established!!!\n");

			// Create data input and output streams // when the connection stablished, now each side should create output and input on top of the socket
			inputFromClient = new DataInputStream(socket.getInputStream()); // input from reading
			outputToClient = new DataOutputStream(socket.getOutputStream());// output for writing


			while (true) { // since we keep reading the data (radius from the client and return area)
				try {
					// Receive radius from the client
					double radius = inputFromClient.readDouble();
					jta.append("Radius received from client: " + radius + '\n');

					if (radius == 0) // for the output, client do not continue , and stop
						break;

					// Compute area
					double area = radius * radius * Math.PI;

					// Send area back to the client, client would like to send radius to server and server calculate the area and send it to client
					outputToClient.writeDouble(area);
					jta.append("Area found: " + area + '\n');
				} catch (java.net.SocketException ex) { //  if connection stops, then there is no excetion happens
					// Listen for a connection request
					jta.append("Waiting for Connection ...\n");
					socket = serverSocket.accept();
					jta.append("Connection Established!!!\n");
					// Create data input and output streams
					inputFromClient = new DataInputStream(socket.getInputStream());
					outputToClient = new DataOutputStream(socket.getOutputStream());
				}

			}
		} catch(IOException ex) {
			System.err.println(ex);
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}
