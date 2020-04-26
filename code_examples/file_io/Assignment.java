import java.io.*;
import java.util.Scanner;
public class Assignment{
  public static void main(String[] args){
  File Assignment = new File("Test2.txt");
  FileReader in;
  BufferedReader readFile;
  String lineOfText;
  
  try{
  in = new FileReader(Assignment);
  readFile = new BufferedReader(in);
  while((lineOfText = readFile.readLine()) != null){
  System.out.println(lineOfText);  
  }
  readFile.close();
  in.close();
  }catch(FileNotFoundException e){
   System.out.println("File does not exist or could not be found."); 
   System.err.println("FileNotFoundException: " + e.getMessage());
  }catch(IOException e){
   System.out.println("Problem reading file.");
   System.out.println("IOException: " + e.getMessage());
  }
}
}