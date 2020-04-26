import java.util.Scanner;
public class Adder{
  public static int num1, num2, answer, canswer, isright, counter = 1, points = 0;
  public Adder(int num1, int num2, int points, int counter){
    this.num1 = num1;
    this.num2 = num2;
    this.points = points;
    this.counter = counter;
  }
  public int check(){
  canswer = num1 + num2;
  //System.out.println(num1);
  //System.out.println(num2);
  //System.out.println(answer);
  if (answer == canswer){
    isright = 1;
  }
  else{
   isright = 0;
   //counter ++;
  }
  return isright;
  }
  public int points(){
    if(counter == 1){
  points += 5;
    }
    if(counter == 2){
     points +=3;
    }
    if(counter == 3){
     points += 1;
    }
    return points;
  }
  public static void main(String[] args){
    do{
    counter = 1;
    Scanner input = new Scanner(System.in);
    num1 = (int)(20 * Math.random() + 1);
    num2 = (int)(20 * Math.random() + 1);
    Adder question = new Adder(num1, num2, points, counter);
    System.out.print(num1 + " + " +  num2 + " = ");
    answer = input.nextInt();
    if(answer != 999){
    isright = question.check();
    if (isright == 1){
      points = question.points();
    }
    else{
     counter = 1;
    }
    while(isright == 0 && counter != 3 && answer != 999){
      counter++;
      System.out.print("Try again: ");
      answer = input.nextInt();
      if (answer!= 999){
      isright = question.check();
      if (isright == 1){
        points = question.points();
        counter = 3;
      }
    }

    }
    }
    }while(answer != 999);
    System.out.println("points: " + points);
    points = 0;
  }
}
