import java.lang.Comparable;
public class answers implements Comparable{
  public static int count, row, col;
  public answers(int co, int r, int c){
   int count = co; 
    int row = r;
    int col = c;
  }
  public void setCount(int newCount){
   count = newCount; 
  }
  public void setRow(int newRow){
   row = newRow; 
  }
  public void setCol(int newCol){
   col = newCol; 
  }
  public int getCount(){
   return(count); 
  }
  public int getRow(){
   return(row); 
  }
  public int getCol(){
   return(col); 
  }
  public String toString(){
  String statement; 
    statement = "Colony at (" + row + "," + col + ") with size " + count;
    return(statement);
  }
  public int compareTo(Object a){
  answers testa = (answers)a;
    
    if(count < testa.getCount()){
     return(-1); 
    }else if(count == testa.getCount()){
     return(0); 
    }else{
     return(1); 
    }
  }
}