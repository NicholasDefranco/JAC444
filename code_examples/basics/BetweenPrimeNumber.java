import java.util.Scanner;
public class BetweenPrimeNumber{
  public static void main (String[] args){
    int num1;
    int num2;
    int numofvalue = 0;
    boolean prime = true;
    Scanner input = new Scanner (System.in);
    System.out.print("Enter the first number: ");
    num1 = input.nextInt();
    System.out.print("Enter the second number: ");
    num2 = input.nextInt();
    for (int i = num1 + 1; i < num2; i++){
      for (int j = 2; j < i/2;j++){
         numofvalue = 0;
         prime = false;
        if (i % j == 0 && numofvalue == 0) { 
          numofvalue = 1;
          prime = false;
         System.out.println(i + " is not prime.");
        }
        if (prime == true) {         
          System.out.println(i + " is prime.");
        }
        
      }
    }
  }
}