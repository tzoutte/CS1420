package lab05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class FilterWords
{
        public static void main (String[]args)
        {
            try (Scanner in = new Scanner(new File("words.txt"));
                 PrintWriter out = new PrintWriter(new File("five.txt"));)
            {
                while (in.hasNext())
                {
                    String word;
                    word = in.next();
                    if (word.length() == 5)
                        out.println(word);
                }
            }
            catch (IOException e)
            {
                System.out.println("Could not read the words: " + e.getMessage());
                return; // Exit main now
            }

            System.out.println(WordleHelper.countWords("five.txt"));
            System.out.println(WordleHelper.replaceLetter("read", 1,'e'));
        }
}
