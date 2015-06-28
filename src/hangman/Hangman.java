//M Faisal Sheikhani
//My first upload to GitHub
//Instructor: Mike Shipley
//6/27/2015
package hangman;

import java.util.Arrays;
import java.util.Scanner;
public class Hangman {

	public static void main(String[] args) {

		String myWord ="utah";															// The secret word "All small case Characters"
		char [] myWordArray = myWord.toCharArray();										// Creating a char array out of myWord
		char [] myUnderScoreArray = myWord.replaceAll("(.)","_").toCharArray()	;		// Copying the myWordArray char into a new char array and replacing all the letters with an underscore
																						// This regex (.) will replace each character in the myWord with _
		Scanner input = new Scanner(System.in);		

		boolean correctGuess;															// A variable to store if the user had a correct guess or not
		int wrongGuessCounter = 6;														// A variable that decreases with each wrong guess

		for (char el : myUnderScoreArray){												// Printing each element of myarray2 with a space separation
			System.out.print(el +" ");
		}
		
		System.out.printf("   (lives left %d) " , wrongGuessCounter);
		System.out.println();

		while ((wrongGuessCounter != 0) && (Arrays.equals(myWordArray, myUnderScoreArray) != true)){	// While loop as long the user has lives and has not guessed the world								
			correctGuess = false;																		// Set the correctGuess to false at the beginning to clear any previous value 
			System.out.print("Your guess: " ); 
			char guess = input.next().toLowerCase().charAt(0);											// Read the first char of the user input and convert it to lower case

			for (char el : myWordArray){			    												// For each letter of myWord Array
				if (el == guess){																		// If the letter is equal to the user input		
					int theGuessIndex = myWord.indexOf(el);												// Save the index of that letter into variable theGuessIndex		
					correctGuess = true;																// Set correctGuess to true 			
					while (theGuessIndex >= 0) {														// And look for repeated letters in the word	
						myUnderScoreArray[theGuessIndex] = el;											// Change the corresponding underscore in myUnderScoreArray into the guessed letter
						theGuessIndex = myWord.indexOf(guess, theGuessIndex + 1);				        // Move to the next repeated letter if found
					}			    					    		
				}		    	
			}

			if (correctGuess == false){																	// If the letter is NOT equal to the user input
				wrongGuessCounter -= 1;																	// Decrease the user's lives
			}

			for (char el : myUnderScoreArray){															// Printing each element of myarray2 with a space separation
				System.out.print(el +" ");																// To show any changes in the array
			}
			
			System.out.printf("   (lives left %d)\n" , wrongGuessCounter);								// Print user's lives			
			System.out.println();			

		}

		if (Arrays.equals(myWordArray, myUnderScoreArray) == true)										// Check if the word is guessed
			System.out.println("congratulations!");
		else 																							// Or NOT guessed
			System.out.printf("The word was %s - try again\n" , myWord );

	}
}
