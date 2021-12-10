package me.mrxbox98.Jast.jest;

public class Expect {

    /**
     * The actual value.
     */
    Class<?> actual;

    /**
     * The opposite of the actual value.
     */
    Expect not = not();

    /**
     * Whether to flip.
     */
    boolean notCheck = false;

    /**
     * Creates a new Expect instance.
     * @param actual The actual value.
     */
    public Expect(Class<?> actual) {
        this.actual = actual;
    }

    /**
     * Flips the expect instance.
     */
    public Expect not()
    {
        notCheck = true;
        return this;
    }

    /**
     * Checks if the actual value is equal to the expected value.
     * @param expected The expected value.
     * @return true if the actual value is equal to the expected value. Otherwise, false.
     */
    public boolean toBe(Class<?> expected)
    {
        return notCheck != (actual == expected);
    }

    /**
     * Checks if the actual value is equal to the expected value.
     * @param expected The expected value.
     * @return true if the actual value is equal to the expected value. Otherwise, false.
     */
    public boolean toEqual(Class<?> expected)
    {
        return notCheck != (actual.equals(expected));
    }

    /**
     * Checks if the actual value is null.
     * @return true if the actual value is null. Otherwise, false.
     */
    public boolean toBeNull()
    {
        return notCheck != (actual == null);
    }

    /**
     * Checks if the actual value is not null.
     * @return true if the actual value is not null. Otherwise, false.
     */
    public boolean toBeDefined()
    {
        return notCheck == (actual == null);
    }

    /**
     * Checks if the actual value is null.
     * @return true if the actual value is null. Otherwise, false.
     */
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

    /**
     * Checks if the actual value is greater than the supplied value.
     * @param value The value to compare to.
     * @return true if the actual value is greater than the supplied value. Otherwise, false.
     */
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

    public boolean toBeLessThanOrEqual(int value)
    {
        try
        {
            return notCheck != (Integer.parseInt(String.valueOf(actual))<=value);
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


            return notCheck != (Math.abs(Double.parseDouble(String.valueOf(actual))-value)<Double.MIN_NORMAL);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeCloseTo(int value)
    {
        try
        {
            return notCheck != (Integer.parseInt(String.valueOf(actual))==value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
