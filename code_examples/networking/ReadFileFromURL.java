package networking;

import java.net.URL;
import java.util.Scanner;

public class ReadFileFromURL {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.print("Enter a URL: ");
		String URLString = new Scanner(System.in).next();
//		Scanner sc = new Scanner(System.in);
//		String URLString = sc.next();

		try {
			URL url = new URL(URLString);
			int count = 0;
			int i = 1;
			Scanner input = new Scanner(url.openStream());
			while (input.hasNext()) {
				String line = input.nextLine();
				System.out.println("Line #"+ i+ ": "+ line);
				count += line.length();
				i++;
			}

			System.out.println("The file size is " + count + "bytes");
			input.close();
		}
		catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors: no such file");
		}
	}
}
