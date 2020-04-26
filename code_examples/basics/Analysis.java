import java.util.Scanner;
public class Analysis{
  public static int max = 0, min = 0, lq, w, r;
  public static int maximum(int[] array){
  max = array[0];
  for(int q = 0; q < array.length; q++){
    if(array[q] > max){
      max = array[q];
    }
  }
  return(max);
  }
  
  public static int minimum(int[] array){
  min = array[0];
  for(int q = 0; q < array.length; q++){
    if(array[q] < min){
      min = array[q];
    }
  }
  return(min);
  }
  
  public static int median(int[] input){
  int[] count = new int[51];
  for(int i = 0; i < input.length; i++){
    count[input[i]]++;
  }
  int index = count.length-1; //50
  for(int i = count.length-2; i >=0; i--){ // 49
    if(count[i] >= count[index]){
     index = i;
    }
  }
  return(index);
  }
    
  public static void histogram(int[] input){
    int[] histogram = new int[10];
    for(int i = 0; i < input.length; i++){
      if(input[i] >= 1 && input[i] <= 5){
        histogram[0] ++;
      }
      else if(input[i] >= 6 && input[i] <= 10){
        histogram[1] ++;
      }
      else if(input[i] >= 11 && input[i] <= 15){
        histogram[2] ++;
      }
      else if(input[i] >= 16 && input[i] <= 20){
        histogram[3] ++;
      }
      else if(input[i] >= 21 && input[i] <= 25){
        histogram[4] ++;
      }
      else if(input[i] >= 26 && input[i] <= 30){
        histogram[5] ++;
      }
      else if(input[i] >= 31 && input[i] <= 35){
        histogram[6] ++;
      }
      else if(input[i] >= 36 && input[i] <= 40){
        histogram[7] ++;
      }
      else if(input[i] >= 41 && input[i] <= 45){
        histogram[8] ++;
      }
      else if(input[i] >= 46 && input[i] <= 50){
        histogram[9] ++;
      }
    }
    w = 1;
    r = 0;
    for(int q = 0; q < histogram.length; q ++){
     System.out.print((w - 1) + " - " + (w + 4) + " : ");
     while (r < histogram[q]){
     System.out.print("*");
     r++;
     }
     r = 0;
     w += 5;
     System.out.println();
    }
  }  
    
  public static void main(String[] args){
  Scanner input = new Scanner(System.in);
  int avg = 0;
  int anums;
  do{
  System.out.println("How many numbers?(between 0 and 20)");
  anums = input.nextInt();
  if(anums > 20 || anums < 0){
    System.out.println("That's not a valid number.");
  }
  }while(anums > 20 || anums < 0);
  int[] user = new int[anums];
  for(int i = 0; i < user.length; i++){
    do{
    System.out.println("Enter a number between 1 and 50.");
  user[i] = input.nextInt();
  if(user[i] > 50 || user[i] < 0){
    System.out.println("That's not a valid number.");
  }
    }while(user[i] > 50 || user[i] < 0);
  avg += user[i];
  }
  avg /= user.length; 
  System.out.println("The average is " +  avg);
  System.out.println("The max number is: " + maximum(user));
  System.out.println("The min number is: " + minimum(user));
  System.out.println("The median is: " + median(user));
  histogram(user);
  
  }
}