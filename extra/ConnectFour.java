package com.game.src.main;

import java.util.Scanner;

// all do while loops in the check methods do the same thing which is why 
//only one is more heavily commented than the others

public class ConnectFour{
  
  public String icon; // this will save the letter that shows up on the board
  public static int counter = 0; // increments every time when there is the same icon together. If there are four in a row a player wins.
  public String name; // saves the name of a player
  public static int col, ucol; // col is to save the col the user inputted while ucol is for temporary storage.
  
  //class Constructor
  public ConnectFour(){
  col = 0; // default value
  Scanner input = new Scanner (System.in); // user input
  System.out.println("Enter a name: "); 
  name = input.next(); // gets a name
   System.out.println("Enter a icon *NOTE: this will only take the first character*");
  icon = input.next().substring(0, 1); // gets icon
  }
 
  // returns the icon
  public String getIcon(){
    return(icon); 
  }
  
  
  public int turn(String[][] array){
    int row = 5; // default value. It is the lowest row number on the board 
    Scanner input = new Scanner(System.in); //user input
    boolean quit; // used to force out of a loop when neccessary
    
    //makes sure user inputs correct info
    do{
      quit = true;
      
    System.out.println("col"); 
    col = input.nextInt();  // collects col from user

    //makes sure input from player was valid and loops if it wasn't
    
    if(quit == true){
    col -- ;
    if(col > 7 || col < 0){
      System.out.println("That's not a valid option");
    }
    
    else if(!(array[0][col] == "[ ]")){
      System.out.println("It's full there");
      quit = false;
    }
    }
    }while(col > 7 || col < -1 || quit == false);

    boolean done = false;
    // this loop will make sure the icon is placed in the lowest spot availible in that coloum number
    do{
    
    if(array[row][col] == "[ ]"){ // if spot is empty...
      array[row][col] = "[" + icon + "]"; // place icon there.
      done = true;
    }
    else{ // if not...
    row --; // decrease row number to check a higher spot.
     
    }

    
    }while(done == false && row >= 0);

    
    return(row);
  }
  
  
  // return the game board
  public static void getBoard(String[][] array, String icon, String icon2, String name, String name2){
    System.out.println("icon " + icon + " is " + name + " and icon " + icon2 + " is " + name2);
    
    // displays coloum number
    System.out.println("  1  2  3  4  5  6  7");
    
    // diplays the board
    for(int r = 0; r < array.length; r++){
      System.out.print(r + 1); // displays row number
      for(int c = 0; c < 7; c++){

       System.out.print(array[r][c]);

      }
      System.out.println();
    }
  }
  
  public boolean WinnerCheckV(String[][] array, int[][] array2, int row){
   // *onlys needs to chceck downward since there will never be an icon above the last icon a player places*
    
    do{
      
      // if spot is equal to the corresponding icon increment a counter
    if(array[row][col].equals("[" + icon + "]") && (array2[row][col] == 0)){
      
      counter ++;
      // if the counter is equal to 4 return true
      if(counter >= 4){
        counter = 0;
        return(true);
        
       
      }
      else{
        
    array2[row][col] = 1;
    
    // makes sure row never greater than the boards dimensions
      if(row < 5){
    row ++;
      }
    
    }
    }
    else{
      // force exit if spot is not equal to correct icon
     row = 6; 
    }
    }while(row <= 5);
    counter = 0;
    // if counter did not equal 4, exit the loop and return false
    return(false);
    }
  
  public boolean WinnerCheckH(String[][] array, int[][] array2, int row){

    // must check left and right
    
    
    int ucol = col; // this is done to make sure the col the user inputted is not lost
   int OGUcol = ucol; // used to reset the col
   
    do{
    if(array[row][ucol].equals("[" + icon + "]") && (array2[row][ucol] == 0)){
      
      counter ++;
      if(counter >= 4){
      counter = 0;
    return(true);
    
    }
      else{
    array2[row][ucol] = 1;
    
    if(ucol > 0){
    ucol --;
    }
    
    }
    
    }else{
     ucol = -1; 
    }
    }while(ucol >= 0);
   
    
    ucol = OGUcol;
    counter --;
    resetCheck(array2);
    do{
    if(array[row][ucol].equals("[" + icon + "]") && (array2[row][ucol] == 0)){
      counter ++;
      if(counter >= 4){
      counter = 0;
    return(true);
    
    }
      else{
    array2[row][ucol] = 1;
      
      
    if(ucol < 6){
    ucol ++;
    }
      }
    }else{
     ucol = 9; 
    }
    }while(ucol <= 7);
   counter = 0;
    return(false);
    
    }
    
  public boolean WinnerCheckD(String[][] array, int[][] array2, int row){
    
    // checks all diagonal directions
    
    int ucol = col;
    int OGUcol = ucol;
    
    int OGrow = row; // used to reset the row after each do while
    
    do{
    if(array[row][ucol].equals("[" + icon + "]") && (array2[row][ucol] == 0)){
      counter ++;
      if(counter >= 4){
        counter = 0;
    return(true);
    
    }
      else{
    array2[row][ucol] = 1;
    
    if(ucol > 0 && row > 0){
    ucol --;
    row --;
    }
    }
    
    
    
    }else{
     ucol = -1; 
    }
    }while(ucol >= 0 && row >= 0);
    ucol = OGUcol;
    row = OGrow;
    counter = 0;
    resetCheck(array2);
   
    do{
    if(array[row][ucol].equals("[" + icon + "]") && (array2[row][ucol] == 0)){
      
      counter ++;
      if(counter >= 4){
        counter = 0;
    return(true);
    
    }
      else{
      
    array2[row][ucol] = 1;
      
      
    if(ucol < 6 && row < 6){
    ucol ++;
    row ++;
    }
      }
    }else{
     ucol = 9; 
    }
    }while(ucol <= 7 && row <= 5);
    
    ucol = OGUcol;
    row = OGrow;
    counter = 0;
    resetCheck(array2);
    
    do{
    if(array[row][ucol].equals("[" + icon + "]") && (array2[row][ucol] == 0)){
     
      counter ++;

      if(counter >= 4){
        counter = 0;
    return(true);
    
    }
      else{
      
    array2[row][ucol] = 1;
      
      
    if(ucol > 0 && row < 6){
    ucol --;
    row ++;
    }
      }
    }else{
      
     ucol = -1; 
    }
    }while(ucol >= 0 && row <= 5);
    counter = 0;
    return(false);
  }
 
  // gives all indexes of the checking array a value of zero
  public static void resetCheck(int[][] array2){
    for(int i = 0; i < 6; i++){
    for(int j = 0; j < 7; j++){
      array2[i][j] = 0;
    }
  }
  }
  
  // checks whether or not it's a tie 
  public static boolean fullCheck(String array[][]){
    int counter = 0;
    for(int i = 0; i < 6; i++){
    for(int j = 0; j < 7; j++){
      if(array[i][j] != "[ ]"){
        counter  ++;
      }
    }
  }
    if(counter == array.length * array[0].length){
     System.out.println("tie game"); 
     return(true);
    }
    return(false);
  }
    
  public static void main(String[] args){ 
    int p = 1;
    // used with the checkers 
    // methods return values to these variables
    boolean win = false, win2 = false, win3 = false, done = false;
    
    
  System.out.println("Get four in a row to win!");
  System.out.println("good luck!\n");
  
    // allocate space to these arrays
  int checker[][] = new int [6][7];
  String[][] board = new String[6][7];
  
  // initialize the board
   for(int r = 0; r < board.length; r++){
      for(int c = 0; c < 7; c++){
        board[r][c] = "[ ]";
        }
      }
  
   // player setup
   System.out.println("Player 1");
  ConnectFour Player1 = new ConnectFour();
  System.out.println("Player 2");
  ConnectFour Player2 = new ConnectFour();
  
  // intailizes checker array
  resetCheck(checker);
  
  // displays board
    getBoard(board, Player1.icon, Player2.icon, Player1.name, Player2.name);
    
    // game loop
  do{   
    
    // allow player input
  System.out.println(Player1.name + "'s turn");
  int row = Player1.turn(board);
  
  // display board
  getBoard(board, Player1.icon, Player2.icon, Player1.name, Player2.name);
  
  // checkers. They all start checking the last place the player put their icon.
  win = Player1.WinnerCheckV(board, checker, row);
  resetCheck(checker);
  win2 = Player1.WinnerCheckH(board, checker, row);
  resetCheck(checker);
  win3 = Player1.WinnerCheckD(board, checker, row);
  resetCheck(checker);
  
  // chceks to see whether or not player 1 has won
  if(win == false && win2 == false && win3 == false){
    
    // allow player input
  System.out.println(Player2.name + "'s turn");
  row = Player2.turn(board);
  
  // display board
  getBoard(board, Player1.icon, Player2.icon, Player1.name, Player2.name);
  
  // checkers. They all start checking the last place the player put their icon.
  win = Player2.WinnerCheckV(board, checker, row);
  resetCheck(checker);
  win2 = Player2.WinnerCheckH(board, checker, row);
  resetCheck(checker);
  win3 = Player1.WinnerCheckD(board, checker, row);
  resetCheck(checker);
  
  }
  else{ // if player 1 won...
   System.out.println(Player1.name  + " wins!"); 
   p = 2; // ...make sure the "player 2 wins" code is not run"
  }
  
  // checks for a tie
  done = fullCheck(board);
  
  // exits when a player has won
  }while(win == false && win2 == false && win3 == false && done == false);
  
  // if player 2 wins
  if(p == 1 && done == false){
   System.out.println(Player2.name + " wins!"); 
  }
  }
}