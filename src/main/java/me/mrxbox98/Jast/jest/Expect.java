package me.mrxbox98.Jast.jest;

public class Expect {

    Class<?> actual;

    Expect not = not();

    boolean notCheck = false;

    public Expect(Class<?> actual) {
        this.actual = actual;
    }

    public Expect not()
    {
        notCheck = true;
        return this;
    }

    public boolean toBe(Class<?> expected)
    {
        return notCheck != (actual == expected);
    }

    public boolean toEqual(Class<?> expected)
    {
        return notCheck != (actual.equals(expected));
    }

    public boolean toBeNull()
    {
        return notCheck != (actual == null);
    }

    public boolean toBeDefined()
    {
        return notCheck == (actual == null);
    }

    public boolean toBeUndefined()
    {
        return notCheck != (actual == null);
    }

    public boolean toBeTruthy()
    {
        return notCheck == (actual == null);
    }

    public boolean toBeFalsy()
    {
        return notCheck != (actual == null);
    }

    public boolean toBeGreaterThan(double value)
    {
        try
        {
            return notCheck != (Double.parseDouble(String.valueOf(actual))>value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThan(int value)
    {
        try
        {
            return notCheck != (Integer.parseInt(String.valueOf(actual))>value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThanOrEqual(double value)
    {
        try
        {
            return notCheck != (Double.parseDouble(String.valueOf(actual))>=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThanOrEqual(int value)
    {
        try
        {
            return notCheck != (Integer.parseInt(String.valueOf(actual))>=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThan(double value)
    {
        try
        {
            return notCheck != (Double.parseDouble(String.valueOf(actual))<value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThan(int value)
    {
        try
        {
            return notCheck != (Integer.parseInt(String.valueOf(actual))<value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThanOrEqual(double value)
    {
        try
        {
            return notCheck != (Double.parseDouble(String.valueOf(actual))<=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeCloseTo(double value)
    {
        try
        {
            return notCheck != (Double.parseDouble(String.valueOf(actual))<=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
