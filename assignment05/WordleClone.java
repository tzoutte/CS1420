/**
 * This application plays a wordle-like game with the user.
 * A list of five-letter words must exist in "five.txt" for this
 * application to run correctly.
 * 
 * Note that students will complete this application as part of
 * assignment #5.
 * 
 * @author Peter Jensen and Tyler Zoutte
 * @version February 7, 2023
 */
package assignment05;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * My wordle clone application.
 */
public class WordleClone
{
	/**
	 * Application entry point
	 * 
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		// Prepare the console scanner (note the variable name)
		Scanner console = new Scanner(System.in);

		// Print a nice welcome message.
		System.out.println("Welcome to my Wordle clone.");
		System.out.println("You have six guesses to guess the secret word.");
		System.out.println("Each guess is scored and printed back to you:");
		System.out.println("  Incorrect letters are replaced with -,");
		System.out.println("  Correctly placed letters are capitalized,");
		System.out.println("  Correct but misplaced letters are lowercase.");

		// Choose the winning, secret word from a text file of words.
		String secretWord;
		secretWord = pickRandomWord("five.txt");

		// Loop, allow the user to make guesses.
		int guessCount = 1;  // Which guess they're on.
		while (guessCount <= 6)
		{
			// Give prompt, input a guess.  For input robustness, take the first word
			//   on each line.  (Input a line, then scan the first word from that line.)
			System.out.print("Enter guess #" + guessCount + ": ");
			String line = console.nextLine();
			if (line.trim().length() == 0)  // Skip blank lines (remove whitespace from ends, check length)
				continue;
			Scanner lineScanner = new Scanner(line);  // A second, temporary Scanner
			String guess = lineScanner.next();
			lineScanner.close();

			// Validate the guess. (Check the word against the list of words.)
			// If the guess is not a valid word, restart the loop.
			if (isValidWord(guess,"five.txt") == false)
			{
				System.out.println("Not a word. Try again.");
				continue;
			}

			// They've made a guess, count it.
			guessCount++;

			// Reset the answer between guesses.
			String answer = secretWord;

			// Score it and display the results.
			String scoredGuess = scoreGuess(guess, secretWord); 
			System.out.println ("Guess: " + guess);
			System.out.println ("Score: " + scoredGuess);

			// Check for a win.  If the scoredGuess is all uppercase and
			//   matches the secret word, it's a win.  Display a message and
			//   end the program.
			if (scoredGuess.equals(secretWord.toUpperCase()))
			{
				System.out.println("You win!");
				return;
			}
		}

		// If the guess loop ends, they've used all their guesses
		//   (and not won).  Inform them of that.
		System.out.println("You lost.  The word was " + secretWord + ".");
		console.close();
	}
	
	/**
	 * Given a filename, this method returns a count of the number of
	 * words in the file.  (Note that word length is not checked here.)
	 *
	 * Returns -1 if the file reading fails.
	 * 
	 * @param filename the name of an existing text file
	 * @return the count of words in the file
	 */
	public static int countWords (String filename)
	{
			try (Scanner in = new Scanner(new File(filename));)
			{
				// Scan through all the words in the file and count them as it goes.
				int count = 0;
				while (in.hasNext())
				{
					in.next();
					count++;
				}
				return count;
			}
			catch (IOException e)
			{
				// If file reading fails.
				System.out.println("Could not read words: " + e.getMessage());
				return -1;
			}
	}

	/**
	 * Given a filename, this method will pick a random word from the file
	 * and return it as a string.
	 *
	 * Returns the filename if the file reading fails.
	 *
	 * @param filename the name of an existing text file
	 * @return a random word from the file
	 */
	public static String pickRandomWord (String filename)
	{
		try (Scanner in = new Scanner(new File(filename));)
		{
			int wordTotal = countWords(filename);
			// Generate a random number from 1 to the total number of words in the file.
			int random = (int) (Math.random() * wordTotal + 1);
			String randomWord = "";

			// Scan through the file until it reaches the corresponding word.
			for (int count = 0; count < random; count++)
				randomWord = in.next();
			return randomWord;
		}
		catch (IOException e)
		{
			// If file reading fails.
			System.out.println("Could not read words: " + e.getMessage());
			return filename;
		}
	}
	
	/**
	 * Given a word and a filename, this method determines if the word
	 * is in the file.  True is returned if the word is in the file,
	 * and false is returned otherwise.  
	 * 
	 * Note that the word should not have any whitespace in it, or it 
	 * won't match anything scanned from the file.  (No special check
	 * is done here for that case.)  The reason is that this function
	 * uses the .next() function from the Scanner class, and this
	 * strips away whitespace.
	 * 
	 * @param word a String without whitespace
	 * @param filename the name of an existing text file
	 * @return true iff the word was found in the file.
	 */
	public static boolean isValidWord (String word, String filename)
	{
		try (Scanner in = new Scanner(new File(filename));)
		{
			// Scan through all the words in the file.
			while (in.hasNext())
			{
				// See if the given word is the same as the scanned word in the file.
				String fileWord = in.next();
				if (word.equals(fileWord))
				{
					return true;
				}
			}
			return false;
		}
		catch (IOException e)
		{
			// If file reading fails.
			System.out.println("Could not read words: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * This method returns a copy of the input String, but with the 
	 * character at the specified position changed to the given letter.
	 * Position must be a valid position in the String or the results
	 * are undefined.  
	 * 
	 * Note that this function does not alter the original String, it
	 * just returns a copy with a letter replaced.  Here is an example
	 * of how this method can be used.
	 * 
	 * word = replaceLetter(word, 1, 'a');
	 * 
	 * If word originally contained "put", the word would now contain
	 * "pat".   
	 * 
	 * 
	 * @param s any non-empty string
	 * @param position a valid position in the string
	 * @param letter a letter to put in the string
	 * @return a copy of the original string, with a letter replaced
	 */
	public static String replaceLetter(String s, int position, char letter)
	{
		// Break a string into two parts at a letter position, then replace that letter.
		String start = s.substring(0, position);
		String end = s.substring(position + 1, s.length());

		return start + letter + end;
	}
	
	/**
	 * Given a user's guess and a Wordle answer, this method 'scores' the guess.
	 * It returns something that looks like a copy of the guess:  Guess characters
	 * appear to be replaced with a '-' if they do not exist in the answer.  They
	 * remain unchanged if they exist in the answer but are in the wrong spot.
	 * They are changed to uppercase if they're in the correct spot.
	 * 
	 * This function requires five character strings of letters.
	 * 
	 * For example:
	 *      answer: miter
	 *      guess:  timid
	 *      score:  tIm--
	 *      
	 * Note that each letter in the guess or answer is only scored once.  Thus,
	 * even though there were multiple i's in the guess, only one was scored.
	 * 
	 * @param guess a five letter string
	 * @param answer a five letter string
	 * @return the wordle score for that guess
	 */
	public static String scoreGuess (String guess, String answer)
	{
		// The score (before we start) is a five character string of dashes.
		// (Create a score variable, initialize it to five dashes.)
		String score = "-----";

		// Score the correct letters first.  If there is a match,
		// put a capital letter in the score, then 'remove' the matching
		// letter in the answer.  For example:
		//    answer:                  abcde
		//    guess:                   ecccc
		//    adjust score like this:              --C--
		//    remove matching letter from answer:  ab-de
		//    remove matching letter from guess:   ec-cc
		// This way, that letter cannot be matched again later.
		// Notes:  We'll loop and do this for each position.  Also,
		// the replaceLetter helper function will be very useful here.
		// Finally, Character.toUpperCase(someChar) returns an
		// uppercase version of a character.

		// Loop through all the letters in the guess.
		for (int position = 0; position < guess.length(); position++)
		{
			// Create variables for individual letters as it loops for readability.
			String guessLetter = guess.substring(position, position + 1);
			String answerLetter = answer.substring(position, position + 1);

			// Replace the letter in the score (uppercase) if it equals the answer.
			// Then replace the letter in the guess and answer with "-" so it won't be counted again.
			if (guessLetter.equals(answerLetter))
			{
				char correctLetter = Character.toUpperCase(guess.charAt(position));
				score = replaceLetter(score, position, correctLetter);
				answer = replaceLetter(answer, position, '-');
				guess = replaceLetter(guess, position, '-');
			}

		}

		// Next score misplaced letters.  If there is a match,
		// put a capital letter in the score, then 'remove' the matching
		// letter in the answer.  For example:
		//    answer:                  ab-de
		//    guess:                   ec-cc
		//    adjust score like this:              e-C--
		//    remove matching letter from answer:  ab-d-
		//    remove matching letter from guess:   -c-cc
		// Again, every time an answer letter matches, remove it by
		// replacing it with a dash so that it won't match again.
		// Notes:  You'll need a doubly-nested loop for this.  One loop
		// loops on the answer position, the other loops on the guess
		// position.  (It doesn't matter which is the inner loop.)
		// You'll also want to skip any positions that have a '-' in them.
		// (Just 'continue' in that case.)

		// Loop through all the letters in the guess.
		for (int positionGuess = 0; positionGuess < guess.length(); positionGuess++)
		{
			// Create variable for individual letter as it loops.
			String guessLetter = guess.substring(positionGuess, positionGuess + 1);

			// If the letter is "-", there is no need to check it.
			if (guessLetter.equals("-"))
				continue;

			// Loop through all the letters in the answer.
			for (int positionAnswer = 0; positionAnswer < answer.length(); positionAnswer++)
			{
				// Create variable for individual letter as it loops.
				String answerLetter = answer.substring(positionAnswer, positionAnswer + 1);

				// If the letter is "-", there is no need to check it.
				if (answerLetter.equals("-"))
					continue;

				// Update guess letter from last loop (if it was changed to "-").
				guessLetter = guess.substring(positionGuess, positionGuess + 1);

				// If the letter is "-", there is no need to check it.
				if (guessLetter.equals("-"))
					continue;

				// Replace the letter in the score (lowercase) if it equals the answer and is not a "-".
				// Then replace the letter in the guess and answer with "-" so it won't be counted again.
				else if (guessLetter.equals(answerLetter))
				{
					score = replaceLetter(score, positionGuess, guess.charAt(positionGuess));
					answer = replaceLetter(answer, positionAnswer, '-');
					guess = replaceLetter(guess, positionGuess, '-');
				}
			}
		}

		// Done with scoring.  Return the score string.
		return score;
	}

}
