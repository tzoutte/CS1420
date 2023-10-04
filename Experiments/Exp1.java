package Experiments;

public class Exp1 {
    public static void main(String[] args)
    {
        feetAndInches a = new feetAndInches(5, -14);
        //a.add(5);
        System.out.println(a);

        odometer b = new odometer();
        b.addMileage(100_005);
        System.out.println(b.getMileage());
    }
}
