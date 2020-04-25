package file_binary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStreams {

	public static void main(String[] args) {

//		File parentDir = new File("src/file_binary");
//		File file = new File(parentDir, "temp.dat");
		File file = new File("src/file_binary/temp.dat");


		try (FileOutputStream output = new FileOutputStream(file);) {
			for (int i = -1; i <= 256; i++)
				output.write(i); // each i is casted to a byte and stored in the file
		} catch (Exception e) {
			// TODO: handle exception
		}

		try (FileInputStream input = new FileInputStream(file);) {
			int nextByte;
			while ((nextByte = input.read()) != -1) {
				System.out.print(nextByte + ", ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
