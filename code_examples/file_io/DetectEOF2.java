package file_binary;

import java.io.*;

public class DetectEOF2 {
	public static void main(String[] args) {
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("test.dat"));
				DataInputStream input = new DataInputStream(new FileInputStream("test.dat"));) {
			output.writeDouble(4.5);
			output.writeDouble(43.25);
			output.writeDouble(3.2);

			while (true)
				System.out.println(input.readDouble());

		} catch (EOFException ex) {
			System.out.println("All data were read");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
