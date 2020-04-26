import java.lang.Math;
import java.util.Scanner;
public class BacteriaGrowth{
  public static void main(String[] args){
    double y;//final
      double n;//initial
      double k;// constant
      double t; //time
      Scanner input = new Scanner(System.in);
      System.out.print("Enter initial bacteria amount: ");
      n = input.nextDouble();
      System.out.print("Enter a constant value for k: ");
      k = input.nextDouble();
      System.out.print("Enter the growth time period in hours: ");
      t = input.nextDouble
        ();
      
      y = n * (Math.exp (k*t));
        //y = n * y;
      
      System.out.println(y + " will be present after " + t + " hours.");
  }
}