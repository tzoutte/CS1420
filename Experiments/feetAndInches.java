package Experiments;

public class feetAndInches
{
    private int feet;
    private int inches;

    public feetAndInches(int f, int i)
    {
        if (i > 12)
        {
            this.feet = f + i / 12;
            this.inches = i % 12;
        }
        else
        {
            this.feet = f;
            this.inches = i;
        }

        if (this.inches < 0)
        {
            this.feet--;
            this.inches = 12 + i;
        }
    }

    public int getInches()
    {
        return this.inches;
    }

    public int getFeet()
    {
        return this.feet;
    }

    public void add(int i)
    {
        this.feet = this.feet + i / 12;
        this.inches = this.inches + i % 12;
    }

    @Override
    public String toString()
    {
        return this.feet + " feet " + this.inches + " inches";
    }
}
