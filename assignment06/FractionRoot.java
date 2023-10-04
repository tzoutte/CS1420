/**
 * This class uses methods from the fraction class to calculate the approximate square root
 * of a user input fraction. It loops through an iterative formula a certain amount of times
 * specified by the user.
 *
 * @author Tyler J. Zoutte
 * @version February 13, 2023
 */
package assignment06;

import java.util.Scanner;

public class FractionRoot
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);

        // Prompt user to input a numerator and denominator, then make it into a fraction.
        System.out.print("Input a numerator and denominator: ");
        long numerator = in.nextInt();
        long denominator = in.nextInt();
        Fraction input = new Fraction(numerator, denominator);

        // Prompt user to input an approximation count, the number of times for the formula to loop.
        System.out.print("Input an approximation count: ");
        int approxCount = in.nextInt();

        // Loop through the formula up to the approximation count replacing current X with next X each time.
        Fraction currentX = input.divide(new Fraction(2));
        for (int count = 0; count < approxCount; count++)
        {
            Fraction nextX = new Fraction(1, 2).multiply((currentX.add(input.divide(currentX))));
            currentX = nextX;
        }

        // Display the approximate square root as a fraction.
        System.out.println("The square root of " + input + " is approximately " + currentX + ".");
    }
}
