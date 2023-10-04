/**
 * This class implements this cool idea: assigning variables, doing calculations with them, then printing the results
 * in sentences.
 *
 * @author Tyler J. Zoutte
 * @version January 12, 2023
 */
package assignment01;
public class TimeCalculation {
    public static void main(String[] args) {
        int uID = 1349266; // Input uID without the u.
        System.out.print("My uID number is u");
        System.out.print(uID);
        System.out.println(".");
        System.out.print(uID);
        System.out.print(" seconds is ");
        System.out.print(uID / 3600); // Calculate # of hours and print.
        System.out.print(" hour(s), ");
        System.out.print((uID / 60) % 60); // Calculate # of minutes and print.
        System.out.print(" minute(s), and ");
        System.out.print(uID % 60); // Calculate # of seconds and print.
        System.out.print(" second(s).");
    }
}
