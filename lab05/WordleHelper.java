package lab05;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordleHelper {
    public static void main (String[] args)
    {
        System.out.println(countWords("five.txt"));
        System.out.println(replaceLetter("reed",1,'e'));
    }
    /**
     * Given a filename, this method returns a count of the number of
     * words in the file.  (Note that word length is not checked here.)
     * <p>
     * Returns -1 if the file reading fails.
     *
     * @param filename the name of an existing text file
     * @return the count of words in the file
     */
    public static int countWords(String filename)
    {
        try (Scanner in = new Scanner(new File(filename));)
        {
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
            System.out.println("Could not read words: " + e.getMessage());
            return -1;
        }
    }

    /**
     * This method returns a copy of the input String, but with the
     * character at the specified position changed to the given letter.
     * Position must be a valid position in the String or the results
     * are undefined.
     * <p>
     * Note that this function does not alter the original String, it
     * just returns a copy with a letter replaced.  Here is an example
     * of how this method can be used.
     * <p>
     * word = replaceLetter(word, 1, 'a');
     * <p>
     * If word originally contained "put", the word would now contain
     * "pat".
     *
     * @param s        any non-empty string
     * @param position a valid position in the string
     * @param letter   a letter to put in the string
     * @return a copy of the original string, with a letter replaced
     */
    public static String replaceLetter(String s, int position, char letter)
    {
        String start = s.substring(0, position);
        String end = s.substring(position + 1, s.length());

        System.out.println(start);
        System.out.println(letter);
        System.out.println(end);
        return start + letter + end;
    }
}
