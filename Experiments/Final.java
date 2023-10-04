package Experiments;

public class Final
{
    private static String doesSomething(String s)
{
    String result = "";
    for (int p = 0; p < s.length(); p++)
        result = s.charAt(p) + result;

    return result;
}

public static void main(String[] args)
{
    String s = "Hello";
    String t = doesSomething(s);
    System.out.println(t);
}
}
