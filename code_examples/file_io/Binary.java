package week6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binary {

	public static void main(String[] args) {
		try {
			byte[] arr = {
					3, 1, 8, 9, 6
			};
			
			FileOutputStream f = new FileOutputStream(new File("file"));
			f.write(arr);
			f.close();
			
			FileInputStream f2 = new FileInputStream(new File("file"));
			
			System.out.println(f2.readAllBytes());
			
			f2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		}
		
	}

}
