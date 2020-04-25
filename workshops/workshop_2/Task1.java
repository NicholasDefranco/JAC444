package week3;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {

		// constant array of strings
		final String[] words = {
				"flukey", "filmmaker", "real",
				"herald", "mealtime", "simon",
				"censures", "woolen", "bagpipe"
		};

		final int NUM_OF_LETTERS_IN_ALPHA = 26;

		// if the letter was already guessed, its index will be true
		boolean[] alphabet = new boolean[NUM_OF_LETTERS_IN_ALPHA];

		Random r = new Random();
		Scanner in = new Scanner(System.in);
		char again = 'y';

		while(again == 'y') {

			// setting up all progress data
			int misses = 0;
			int correct = 0;
			int select = r.nextInt(words.length);

			for(int i = 0; i < alphabet.length; i++) {
				alphabet[i] = false;
			}

			// StringBuilder allows for changing specific
			// character in a String
			StringBuilder progress = new StringBuilder(
					words[select].replaceAll(".", "*")
			);

			// correct will be equal to the amount of correctly
			// guessed characters currently in the word
			while(correct < words[select].length()) {
				char c = 'x';
				// ensures the character received in an alphabetic
				// character
				do {
					System.out.print("(Guess) Enter a letter in word " + progress + " > ");
					c = in.nextLine().toLowerCase().charAt(0);
				} while(!Character.isAlphabetic(c));

				if(alphabet[c - 'a']) { // already guessed that!
					System.out.println(c + " was already guessed");
				} else {
					int index = words[select].indexOf(c);
					alphabet[c - 'a'] = true;
					if(index < 0) { // incorrect
						misses++;
						System.out.println(c + " is not in the word");
					} else { // correct guess
						// in case there's more than one of the same character
						while(index >= 0) {
							correct++;
							progress.setCharAt(index, c);
							index = words[select].indexOf(c, index + 1);
						}
					}
				}
			}

			// game complete
			System.out.println("The word is " + words[select] + ". You missed " + misses + " time(s)");
			do {
				System.out.print("Do you want to guess another word? Enter y or n > ");
				again = in.nextLine().toLowerCase().charAt(0);
			} while(again != 'y' && again != 'n');

		}

		in.close();

	}


}
