package Week2;

import java.util.Random;
import java.util.Scanner;

public class Task3 {

	// mapping integers to all possible plays
	public static final int SCISSOR = 0;
	public static final int ROCK = 1;
	public static final int PAPER = 2;

	// constant array mapping an integer(its index) to its name.
	public static final String[] opts = {
		"Scissor", "Rock", "Paper"
	};

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Random r = new Random();
		int play = 0;
		int com = 0;

		// prompt for player's choice...
		do {
			System.out.print("scissor (0), rock (1), paper (2): ");
			play = in.nextInt();
		} while(play < 0 || play > 2);

		// computer player generates a value...
		com = r.nextInt(3);

		System.out.print("The computer is " + opts[com] +
					". You are " + opts[play]);

		// determine result...
		if(play == com) {
			System.out.print(" too. It is a draw");
		} else if(com == SCISSOR && play == PAPER ||
				com == ROCK && play == SCISSOR ||
				com == PAPER && play == ROCK) {
			System.out.println(". You lost");
		} else {
			System.out.println(". You won");
		}

		in.close();

	}

}
