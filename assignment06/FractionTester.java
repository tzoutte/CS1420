/**
 * This class tests methods from the Fraction class that display fractions
 * as a string, get the numerator and denominator values of fractions, do addition, subtraction, multiplication and
 * division on fractions.
 *
 * @author Tyler J. Zoutte
 * @version February 13, 2023
 */
package assignment06;

public class FractionTester
{
    public static void main(String[] args)
    {
        System.out.println("Fraction tester:");

        // Create three new fractions
        Fraction f = new Fraction (2,3);
        Fraction g = new Fraction (1,4);
        Fraction h = new Fraction (5,1);

        // Print out the values of f, g, and h
        System.out.println("Fraction f contains: " + f);
        System.out.println("Fraction g contains: " + g);
        System.out.println("Fraction h contains: " + h);

        // Test get numerator and get denominator
        System.out.println("G's denominator is: " + g.getDenominator());
        System.out.println("F's numerator is: " + f.getNumerator());

        // Multiplication tests
        System.out.println("F multiplied by G is: " + f.multiply(g));
        System.out.println("G multiplied by H is: " + g.multiply(h));

        // Division tests
        System.out.println("F divided by G is: " + f.divide(g));
        System.out.println("G divided by H is: " + g.divide(h));

        // Set boolean to true, it is modified to false if any test fails
        boolean passed = true;

        // Tests multiplication and converting a fraction to a double
        {
            Fraction a = new Fraction (5, 3);
            Fraction b = new Fraction (1,4);
            Fraction c = a.multiply(b);
            System.out.println(a + " * " + b + " =  " + c);
            if (a.getNumerator() != 5 || a.getDenominator() != 3 || b.getNumerator() != 1 || b.getDenominator() != 4
                || c.getNumerator() != 5 || c.getDenominator() != 12 || c.toDouble() != (double) 5 / 12)
            {
                System.out.println("Error - did not complete correctly.");
                passed = false;
            }
        }

        // Tests division, converting fractions to strings, and getting numerator/denominator
        {
            Fraction a = new Fraction (5, 3);
            Fraction b = new Fraction (1,4);
            Fraction c = a.divide(b);
            System.out.println(a + " / " + b + " = " + c);
            if (a.getNumerator() != 5 || a.getDenominator() != 3 || b.getNumerator() != 1 || b.getDenominator() != 4
                    || c.getNumerator() != 20 || c.getDenominator() != 3)
            {
                System.out.println("Error - did not complete correctly.");
                passed = false;
            }
        }

        // Tests adding fractions and reducing fractions
        {
            Fraction a = new Fraction(9, 4);
            Fraction b = new Fraction(10, 15);
            Fraction c = a.add(b);
            System.out.println(a + " + " + b + " = " + c);
            if (a.getNumerator() != 9 || a.getDenominator() != 4 || b.getNumerator() != 2 || b.getDenominator() != 3
                    || c.getNumerator() != 35 || c.getDenominator() != 12)
            {
                System.out.println("Error - did not complete correctly.");
                passed = false;
            }
        }

        // Tests subtracting fractions, converting whole numbers to fractions and negating negative denominator
        {
            Fraction a = new Fraction (2);
            Fraction b = new Fraction (9,4);
            Fraction c = a.subtract(b);
            System.out.println(a + " - " + b + " = " + c);
            if (a.getNumerator() != 2 || a.getDenominator() != 1 || b.getNumerator() != 9 || b.getDenominator() != 4
                    || c.getNumerator() != -1 || c.getDenominator() != 4)
            {
                System.out.println("Error - did not complete correctly.");
                passed = false;
            }
        }

        // Tests multiplication and converting a fraction to a double
        {
            Fraction a = new Fraction (4, 3);
            Fraction b = new Fraction (5, 6);
            Fraction c = a.multiply(b);
            System.out.println(a + " * " + b + " =  " + c);
            if (a.getNumerator() != 4 || a.getDenominator() != 3 || b.getNumerator() != 5 || b.getDenominator() != 6
                    || c.getNumerator() != 10 || c.getDenominator() != 9 || c.toDouble() != (double) 10 / 9)
            {
                System.out.println("Error - did not complete correctly.");
                passed = false;
            }
        }

        // Tests division, converting fractions to strings, and getting numerator/denominator
        {
            Fraction a = new Fraction (4, 3);
            Fraction b = new Fraction (5,6);
            Fraction c = a.divide(b);
            System.out.println(a + " / " + b + " = " + c);
            if (a.getNumerator() != 4 || a.getDenominator() != 3 || b.getNumerator() != 5 || b.getDenominator() != 6
                    || c.getNumerator() != 8 || c.getDenominator() != 5)
            {
                System.out.println("Error - did not complete correctly.");
                passed = false;
            }
        }

        // Tests adding fractions and reducing fractions
        {
            Fraction a = new Fraction(5, 6);
            Fraction b = new Fraction(4, 8);
            Fraction c = a.add(b);
            System.out.println(a + " + " + b + " = " + c);
            if (a.getNumerator() != 5 || a.getDenominator() != 6 || b.getNumerator() != 1 || b.getDenominator() != 2
                    || c.getNumerator() != 4 || c.getDenominator() != 3)
            {
                System.out.println("Error - did not complete correctly.");
                passed = false;
            }
        }

        // Tests subtracting fractions, converting whole numbers to fractions and negating negative denominator
        {
            Fraction a = new Fraction (1);
            Fraction b = new Fraction (8,3);
            Fraction c = a.subtract(b);
            System.out.println(a + " - " + b + " = " + c);
            if (a.getNumerator() != 1 || a.getDenominator() != 1 || b.getNumerator() != 8 || b.getDenominator() != 3
                    || c.getNumerator() != -5 || c.getDenominator() != 3)
            {
                System.out.println("Error - did not complete correctly.");
                passed = false;
            }
        }

        // If the initial boolean is still true, none of the tests failed. If not, at least one did.
        if (passed == true)
            System.out.println("All tests completed, no errors.");
        else
            System.out.println("All tests completed, errors found.");
        System.out.println ("Fraction tester end.");
    }
}
