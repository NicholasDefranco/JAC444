import java.util.Scanner;
public class bird{
  public static int age;
  public bird(int a){ 
  age = a;
  }
  public void setAge(int newAge){
    age = newAge;
  }
  public int getAge(){
  return(age);
  }
  public String toString(){
   String s;
   s = "bird's age is: " + age;
     return(s);
  }
  
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    bird[] test = new bird[3];
    for(int i = 0; i < test.length; i++){
     test[i] = new bird(0);
    }
    //for(int i = 0; i < test.length; i++){
      //int age = input.nextInt();
     test[0].setAge(10); 
     test[1].setAge(16);
     //System.out.println(test[1]);
     test[2].setAge(19);
    //}
    for(int j = 0; j < test.length; j++){
    System.out.println(test[j]); 
    }
  }
}