package Experiments;

public class odometer
{
    private int mileage;

    public odometer()
    {
        this.mileage = 0;
    }

    public int getMileage()
    {
        return this.mileage;
    }

    public void addMileage(int i)
    {
        this.mileage = this.mileage + i;
        if (this.mileage >= 100_000)
        {
            this.mileage = this.mileage % 100_000;
        }
    }
}
