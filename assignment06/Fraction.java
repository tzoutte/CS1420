/**
 * This class implements creating methods that display fractions as strings, get numerator and
 * denominator values from fractions, and do multiplication and division on fractions.
 *
 * @author Tyler J. Zoutte
 * @version February 13, 2023
 */
package assignment06;

/**
 * Objects built from this class represent fractions.
 */
public class Fraction
{
    private long numerator;
    private long denominator;

    /**
     * Constructs a Fraction object with specified numerator
     * and denominator.
     *
     * Returns the inputs as a reduced fraction and negates the fraction
     * if the denominator is negative.
     *
     * @param n any long
     * @param d any long
     */
    public Fraction (long n, long d)
    {
        // Compute the greatest common divisor of x and y using a
        // well known algorithm.
        long gcd = n;
        long remainder = d;
        while (remainder != 0)
        {
            long temp = remainder;
            remainder = gcd % remainder;
            gcd = temp;
        }

        // If the denominator is negative, negate the numerator and denominator.
        if (d < 0)
        {
            d = d * -1;
            n = n * -1;
        }

        // Store the reduced fraction.
        this.numerator = n / Math.abs(gcd);
        this.denominator = d / Math.abs(gcd);
    }

    /**
     * Constructs a Fraction object from one input with the specified numerator over one.
     *
     * @param n any long
     */
    public Fraction (long n)
    {
        this.numerator = n;
        this.denominator = 1;
    }

    /**
     * Returns a Fraction object as a string.
     *
     * @return fraction as a string.
     */
    public String toString ()
    {
      return this.numerator + "/" + this.denominator;
    }

    /**
     * Returns a double that approximates a Fraction object.
     *
     * @return fraction as a double approximation.
     */
    public double toDouble ()
    {
        return (double) this.numerator / this.denominator;
    }

    /**
     * Returns the object's numerator.
     *
     * @return the numerator
     */
    public long getNumerator ()
    {
        return numerator;
    }

    /**
     * Returns the object's denominator.
     *
     * @return the denominator
     */
    public long getDenominator ()
    {
        return denominator;
    }

    /**
     * Returns the result of multiplication between this fraction
     * and another fraction.
     *
     * @param rightHandSide any fraction
     * @return the product of the two fractions
     */
    public Fraction multiply (Fraction rightHandSide)
    {
        // Create a variable to hold the result.
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction (this.numerator * rightHandSide.numerator,
                                this.denominator * rightHandSide.denominator);

        // Pass the resulting fraction back to the caller.
        return result;
    }

    /**
     * Returns the result of this fraction divided by
     * another fraction.
     *
     * @param rightHandSide any fraction
     * @return the result of dividing the fractions
     */
    public Fraction divide (Fraction rightHandSide)
    {
        // Create a variable to hold the result.
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction (this.numerator * rightHandSide.denominator,
                                this.denominator * rightHandSide.numerator);

        return result;
    }

    /**
     * Returns the result of this fraction added with
     * another fraction.
     *
     * @param rightHandSide any fraction
     * @return the result of adding the fractions
     */
    public Fraction add (Fraction rightHandSide)
    {
        // Create a variable to hold the result.
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction (this.numerator * rightHandSide.denominator +
                                rightHandSide.numerator * this.denominator,
                                this.denominator * rightHandSide.denominator);

        return result;
    }

    /**
     * Returns the result of another fraction subtracted from
     * this fraction.
     *
     * @param rightHandSide any fraction
     * @return the result of subtracting the fractions
     */
    public Fraction subtract (Fraction rightHandSide)
    {
        // Create a variable to hold the result.
        Fraction result;

        // Build a new Fraction object - send the products to the constructor.
        result = new Fraction (this.numerator * rightHandSide.denominator -
                                rightHandSide.numerator * this.denominator,
                                this.denominator * rightHandSide.denominator);

        return result;
    }
}
