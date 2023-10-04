/*
 * A collection of unit tests for Assignment #7.  To make this work, you'll need to 
 * follow a few steps to get JUnit tests set up in your project.
 * 
 *     Find an @Test annotation above one of the functions below.
 *     It should be in red indicating that JUnit5 is not installed.
 *     Hover over it, and it will suggest JUnit4 along with more options.
 *     Do not install JUnit4.  Instead, look at the additional suggested
 *     options and select to install JUnit5.  Follow the prompts and
 *     JUnit5 will be installed for you.
 *
 *     That's it!  You should not need to adjust dependencies or
 *     install additional tools.  (Installing JUnit5 can be complex,
 *     but the above strategy is simple.)
 *
 *     I've already imported the needed classes (and functions) for
 *     JUnit5 assertions.  See below.
 *
 *  Peter Jensen
 *  
 * Modified by:
 * @author Tyler J. Zoutte
 * @version 02/28/2023
 */
package assignment07;

import java.awt.*;
import java.math.BigInteger;
import java.util.Arrays;  // OK in tests, not allowed in ArrayExercises

// Imports for JUnit 5

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/* I generated unit tests for all the functions in ArrayExercises.
 * To run the tests, just run this code.
 */
public class ArrayExercisesTest
{
	/* This is my first example unit test.  A unit test is just a piece of
	 * code that calls some method or builds some object, and tests 
	 * for errors.  The code/test design is up to the programmer.  
	 * 
	 * The unit test library provides functions for 'asserting' correctness.
	 * I use assertEquals below.  If the two values are not equal, the
	 * unit test library throws an exception and records a failure.
	 * 
	 * There are other assert functions in the unit test library that are
	 * useful for noting errors.  If the function below completes without
	 * recording a failure, then the test is marked as a success.
	 */
	@Test
	public void testRandomArray01()
	{
		// Call the function, ask for an array of thirty elements.
		
		int[] result;
		int size = 30;
		
		result = ArrayExercises.randomArray(size);  // This calls the function I'm testing.
		
		// The function has a specific contract that guarantees things
		//  about it's return value.  Check to make sure the method
		//  call did what it was supposed to.
		
		// Make sure the size of the result array is correct.
		
		assertEquals(size, result.length);  // If unequal, an error is recorded.
		
		// Make sure the required numbers [0..n-1] are in the array.
		
		numberLoop:  for (int n = 0; n < size; n++)  // Notice that I labeled this loop
		{
			// Search for n in the array.  When found, move on to the next n.
			
			for (int pos = 0; pos < size; pos++)
				if (result[pos] == n)
					continue numberLoop;  // Found it, continue the outer loop.
			
			// If we get this far, the number n was not found.  This is an error.
			
			fail("Number missing from random array: " + n + " in " + Arrays.toString(result));  // Record an error 	
		}		
		
		// If the number loop completes without failing, all tests pass!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	/* I wanted two unit tests for my function.  The first one, above,
	 *   just makes sure the basic operation of 'randomArray' is 
	 *   correct.  This second unit test makes sure the 'randomness'
	 *   is correct.  A truly random shuffle has equal likelihood
	 *   of any outcome.  I repeatedly generate random arrays,
	 *   then I count up results, and then check to make
	 *   sure that each outcome occurred with similar probability.
	 *   
	 * Because random numbers may produce results
	 *   that look uneven, I loop many times to reduce the likelihood
	 *   of random results looking like an error. 
	 *   
	 * I do not expect students to study this code - it is poor code.
	 *   (I don't like the way I'm counting permutations.)  There
	 *   are better ways, but you haven't seen the required lectures
	 *   yet, so I'm using a more primitive solution.  I expect your
	 *   unit tests to be much less complex.
	 */ 
	@Test
	public void testRandomArray02()
	{
		// An array of three has six permutations.
		
		// Counts of how many times each permutation appears.
		
		int count012 = 0;
		int count021 = 0;
		int count102 = 0;
		int count120 = 0;
		int count201 = 0;
		int count210 = 0;
		
		// Repeatedly generate arrays (1,000,000 times).
		
		for (int count = 0; count < 1_000_000; count++)
		{
			// Generate an array of 3 elements.
			
			int[] result = ArrayExercises.randomArray(3);  // This calls the function I'm testing.
			
			// Keep counts of each permutation in the array.
			
			if (result[0] == 0 && result[1] == 1)       // [0, 1, 2]
				count012++;
			else if (result[0] == 0 && result[1] == 2)  // [0, 2, 1]
				count021++;
			else if (result[0] == 1 && result[1] == 0)  // [1, 0, 2]
				count102++;
			else if (result[0] == 1 && result[1] == 2)  // [1, 2, 0]
				count120++;
			else if (result[0] == 2 && result[1] == 0)  // [2, 0, 1]
				count201++;
			else // only other possibility is [2, 1, 0]
				count210++;
		}
		
		// Check each permutation.  It should occur 166,666 times on average.  Accept
		//   anything within +/- 3,000.
		
		if (Math.abs(166_666 - count012) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012); 	
		
		if (Math.abs(166_666 - count021) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021); 	
		
		if (Math.abs(166_666 - count102) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102); 	
		
		if (Math.abs(166_666 - count120) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120); 	
		
		if (Math.abs(166_666 - count201) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201); 	
		
		if (Math.abs(166_666 - count210) > 3_000)
		    fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210); 	
		
		// If execution completes without failing, the test passes!  
		//   (When this method ends normally, the test is marked as passing.)
	}

	
	@Test
	public void testReverseOrder01()
	{
		// Test with an even number of chars in the array.
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] fourLetters = new char[]{'a', 'b', 'c', 'd'};
		char[] reversedLetters = new char[]{'d', 'c', 'b', 'a'};
		ArrayExercises.reverseOrder(fourLetters);
		assertArrayEquals(reversedLetters, fourLetters, "Incorrect reverse order.");
	}

	@Test
	public void testReverseOrder02()
	{
		// Test with an odd number of chars in the array.
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] fiveLetters = new char[]{'a', 'b', 'c', 'd', 'e'};
		char[] reversedLetters = new char[]{'e', 'd', 'c', 'b', 'a'};
		ArrayExercises.reverseOrder(fiveLetters);
		assertArrayEquals(reversedLetters, fiveLetters, "Incorrect reverse order.");
	}

	@Test
	public void testReverseOrder03()
	{
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] oneLetter = new char[]{'a'};
		char[] reversedLetters = new char[]{'a'};
		ArrayExercises.reverseOrder(oneLetter);
		assertArrayEquals(reversedLetters, oneLetter, "Incorrect reverse order.");
	}

	@Test
	public void testReverseOrder04()
	{
		// Test with a large array.
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] tenLetters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		char[] reversedLetters = new char[]{'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
		ArrayExercises.reverseOrder(tenLetters);
		assertArrayEquals(reversedLetters, tenLetters, "Incorrect reverse order.");
	}

	@Test
	public void testReverseOrder05()
	{
		// Test with a zero sized array
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] noLetters = new char[]{};
		char[] reversedLetters = new char[]{};
		ArrayExercises.reverseOrder(noLetters);
		assertArrayEquals(reversedLetters, noLetters, "Incorrect reverse order.");
	}

	@Test
	public void testCount01()
	{
		// Test with just strings.
		String[] strings = new String[]{"red", "green", "blue", "red"};
		assertTrue(ArrayExercises.count(strings, "red") == 2, "Incorrect count.");
	}

	@Test
	public void testCount02()
	{
		// Test with null included in the string array.
		String[] strings = new String[]{null , "green", "blue", "red"};
		assertTrue(ArrayExercises.count(strings, null) == 1, "Incorrect count.");
	}

	@Test
	public void testCount03()
	{
		// Test with null as the target parameter.
		String[] strings = new String[]{"red" , "green", "blue", "red"};
		assertTrue(ArrayExercises.count(strings, null) == 0, "Incorrect count.");
	}

	@Test
	public void testCount04()
	{
		// Test with a zero sized array.
		String[] strings = new String[]{};
		assertTrue(ArrayExercises.count(strings, "red") == 0, "Incorrect count.");
	}

	@Test
	public void testReplace01()
	{
		// Test with null as the original parameter.
		String[] strings = new String[]{"red", null, "blue", "red"};
		String[] replacedStrings = new String[]{"red", "yellow", "blue", "red"};
		ArrayExercises.replace(strings, null, "yellow");
		assertArrayEquals(strings, replacedStrings, "Incorrect replacement.");
	}

	@Test
	public void testReplace02()
	{
		// Test with just strings.
		String[] strings = new String[]{"red", "green", "blue", "red"};
		String[] replacedStrings = new String[]{"yellow", "green", "blue", "yellow"};
		ArrayExercises.replace(strings, "red", "yellow");
		assertArrayEquals(strings, replacedStrings, "Incorrect replacement.");
	}

	@Test
	public void testReplace03()
	{
		// Test with null as the replacement parameter.
		String[] strings = new String[]{"red", "green", "blue", "red"};
		String[] replacedStrings = new String[]{null, "green", "blue", null};
		ArrayExercises.replace(strings, "red", null);
		assertArrayEquals(strings, replacedStrings, "Incorrect replacement.");
	}

	@Test
	public void testReplace04()
	{
		// Test with a zero sized array.
		String[] strings = new String[]{};
		String[] replacedStrings = new String[]{};
		ArrayExercises.replace(strings, "red", null);
		assertArrayEquals(strings, replacedStrings, "Incorrect replacement.");
	}

	@Test
	public void testComputeAreas01()
	{
		// Test with whole numbers.
		double[] a = new double[]{5, 7, 3, 1 ,4};
		double[] b = new double[]{1, 3, 9, 5 ,2};
		double[] areas = new double[]{5, 21, 27, 5, 8};
		assertArrayEquals(areas, ArrayExercises.computeAreas(a, b), "Incorrect areas.");
	}

	@Test
	public void testComputeAreas02()
	{
		// Test with decimals.
		double[] a = new double[]{0.1, 0.3, 0.7, 0.5};
		double[] b = new double[]{0.4, 0.8, 0.2, 0.1};
		double[] areas = new double[]{0.1*0.4, 0.3*0.8, 0.7*0.2, 0.5*0.1};
		assertArrayEquals(areas, ArrayExercises.computeAreas(a, b), "Incorrect areas.");
	}

	@Test
	public void testComputeAreas03()
	{
		// Test with zeros.
		double[] a = new double[]{0, 0, 0, 0 ,0};
		double[] b = new double[]{1, 3, 9, 5 ,2};
		double[] areas = new double[]{0, 0, 0, 0, 0};
		assertArrayEquals(areas, ArrayExercises.computeAreas(a, b), "Incorrect areas.");
	}

	@Test
	public void testRemove01()
	{
		// Test with no nulls.
		Color[] a = new Color[]{Color.RED, Color.BLUE, Color.GREEN};
		Color[] b = new Color[]{Color.RED, Color.BLUE};
		assertArrayEquals(b, ArrayExercises.remove(b, Color.GREEN), "Incorrectly removed target.");
	}

	@Test
	public void testRemove02()
	{
		// Test with null in the array, not the target.
		Color[] a = new Color[]{Color.RED, Color.BLUE, Color.GREEN, null};
		Color[] b = new Color[]{Color.RED, Color.BLUE, null};
		assertArrayEquals(b, ArrayExercises.remove(b, Color.GREEN), "Incorrectly removed target.");
	}

	@Test
	public void testRemove03()
	{
		// Test with null target, not in the array.
		Color[] a = new Color[]{Color.RED, Color.BLUE, Color.GREEN};
		Color[] b = new Color[]{Color.RED, Color.BLUE, Color.GREEN};
		assertArrayEquals(b, ArrayExercises.remove(b, null), "Incorrectly removed target.");
	}

	@Test
	public void testRemove04()
	{
		// Test with null target, and in the array.
		Color[] a = new Color[]{Color.RED, Color.BLUE, Color.GREEN, null};
		Color[] b = new Color[]{Color.RED, Color.BLUE, Color.GREEN};
		assertArrayEquals(b, ArrayExercises.remove(b, null), "Incorrectly removed target.");
	}

	@Test
	public void testSort01()
	{
		// Test with all positive numbers.
		int[] a = new int[]{1,5,6,3,2, 1};
		int[] b = new int[]{6, 5, 3, 2, 1, 1};
		ArrayExercises.sort(a);
		assertArrayEquals(a, b, "Incorrectly sorted.");
	}

	@Test
	public void testSort02()
	{
		// Test with all positive numbers.
		int[] a = new int[]{1,-5,6,-3,2, -1};
		int[] b = new int[]{6, 2, 1, -1, -3, -5};
		ArrayExercises.sort(a);
		assertArrayEquals(a, b, "Incorrectly sorted.");
	}

	@Test
	public void testSort03()
	{
		// Test with an odd amount of numbers.
		int[] a = new int[]{1,-5,6,-3,2};
		int[] b = new int[]{6, 2, 1, -3, -5};
		ArrayExercises.sort(a);
		assertArrayEquals(a, b, "Incorrectly sorted.");
	}

	@Test
	public void testFindSmallest01()
	{
		// Test with all positive values.
		Rectangle a = new Rectangle(1, 1, 2, 2);
		Rectangle b = new Rectangle(1, 1, 2, 1);
		Rectangle c = new Rectangle(1, 1, 3, 2);
		Rectangle f = new Rectangle(1, 1, 5, 2);
		Rectangle[] g = new Rectangle[]{a, b, c, f};
		assertEquals(ArrayExercises.findSmallest(g), b, "Incorrect smallest area.");
	}

	@Test
	public void testFindSmallest02()
	{
		// Test with positive and negative values.
		Rectangle a = new Rectangle(1, 1, -2, 2);
		Rectangle b = new Rectangle(1, 1, 2, 1);
		Rectangle c = new Rectangle(1, 1, 3, -2);
		Rectangle f = new Rectangle(1, 1, 5, 2);
		Rectangle[] g = new Rectangle[]{a, b, c, f};
		assertEquals(ArrayExercises.findSmallest(g), c, "Incorrect smallest area.");
	}

	@Test
	public void testFindSmallest03()
	{
		// Test with duplicate rectangle.
		Rectangle a = new Rectangle(1, 1, -2, 2);
		Rectangle b = new Rectangle(1, 1, 2, 1);
		Rectangle c = new Rectangle(1, 1, 3, -2);
		Rectangle f = new Rectangle(1, 1, 3, -2);
		Rectangle[] g = new Rectangle[]{a, b, c, f};
		assertEquals(ArrayExercises.findSmallest(g), f, "Incorrect smallest area.");
	}

	@Test
	public void testHistogram01()
	{
		// Test with random numbers and no zeros
		int[] a = new int[]{1, 4, 2, 2, 2, 3, 4};
		int[] b = new int[]{0, 1, 3, 1, 2};
		assertArrayEquals(ArrayExercises.histogram(a), b, "Incorrect histogram.");
	}

	@Test
	public void testHistogram02()
	{
		// Test with max not at the end and with zeros.
		int[] a = new int[]{0, 0, 1, 4, 2, 2, 2, 3};
		int[] b = new int[]{2, 1, 3, 1, 1};
		assertArrayEquals(ArrayExercises.histogram(a), b, "Incorrect histogram.");
	}
}
