package assignment07;

import java.awt.*;

public class test
{
    public static void main(String[] args)
    {
       int[] a = new int[]{0, 0, 1, 4, 2, 2, 2, 3};
       int [] b = ArrayExercises.histogram(a);
       for (int i = 0; i < b.length; i++)
           System.out.println(b[i]);
    }
}
