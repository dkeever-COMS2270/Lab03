package lab3;

public class Basketball
{
    double diameter;
    boolean inflated;
    public Basketball(double givenDiameter)
    {
        this.diameter = givenDiameter;
    }

    public boolean isDribbleable()
    {
        return inflated;
    }

    public double getDiameter()
    {
        return 0;
    }

    public double getCircumference()
    {
        return 0;
    }

    public void inflate()
    {
        if (!inflated) {
            this.inflated = true;
        }
    }
}
