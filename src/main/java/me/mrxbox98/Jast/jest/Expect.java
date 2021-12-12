package me.mrxbox98.Jast.jest;

public class Expect {

    /**
     * The actual value.
     */
    Object actual;

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
    public Expect(Object actual) {
        this.actual = actual;
    }

    /**
     * Flips the expect instance.
     * @return The opposite of the expect instance.
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
    public boolean toBe(Object expected)
    {
        return notCheck != (actual == expected);
    }

    /**
     * Checks if the actual value is equal to the expected value.
     * @param expected The expected value.
     * @return true if the actual value is equal to the expected value. Otherwise, false.
     */
    public boolean toEqual(Object expected)
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

    /**
     * Checks if the value is truthy.
     * @return true if so. Otherwise, false.
     */
    public boolean toBeTruthy()
    {
        return notCheck == (actual == null);
    }

    /**
     * Checks if the value is falsy.
     * @return true if so. Otherwise, false.
     */
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

    /**
     * Checks if the actual value is greater than to the supplied value.
     * @param value The value to compare to.
     * @return true if the actual value is greater than to the supplied value. Otherwise, false.
     */
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

    public boolean toBeGreaterThan(float value)
    {
        try
        {
            return notCheck != (Float.parseFloat(String.valueOf(actual))>value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThan(long value)
    {
        try
        {
            return notCheck != (Long.parseLong(String.valueOf(actual))>value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThan(short value)
    {
        try
        {
            return notCheck != (Short.parseShort(String.valueOf(actual))>value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThan(byte value)
    {
        try
        {
            return notCheck != (Byte.parseByte(String.valueOf(actual))>value);
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

    public boolean toBeGreaterThanOrEqual(float value)
    {
        try
        {
            return notCheck != (Float.parseFloat(String.valueOf(actual))>=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThanOrEqual(long value)
    {
        try
        {
            return notCheck != (Long.parseLong(String.valueOf(actual))>=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThanOrEqual(short value)
    {
        try
        {
            return notCheck != (Short.parseShort(String.valueOf(actual))>=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeGreaterThanOrEqual(byte value)
    {
        try
        {
            return notCheck != (Byte.parseByte(String.valueOf(actual))>=value);
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

    public boolean toBeLessThan(float value)
    {
        try
        {
            return notCheck != (Float.parseFloat(String.valueOf(actual))<value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThan(long value)
    {
        try
        {
            return notCheck != (Long.parseLong(String.valueOf(actual))<value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThan(short value)
    {
        try
        {
            return notCheck != (Short.parseShort(String.valueOf(actual))<value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThan(byte value)
    {
        try
        {
            return notCheck != (Byte.parseByte(String.valueOf(actual))<value);
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

    public boolean toBeLessThanOrEqual(float value)
    {
        try
        {
            return notCheck != (Float.parseFloat(String.valueOf(actual))<=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThanOrEqual(long value)
    {
        try
        {
            return notCheck != (Long.parseLong(String.valueOf(actual))<=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThanOrEqual(short value)
    {
        try
        {
            return notCheck != (Short.parseShort(String.valueOf(actual))<=value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeLessThanOrEqual(byte value)
    {
        try
        {
            return notCheck != (Byte.parseByte(String.valueOf(actual))<=value);
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

    public boolean toBeCloseTo(float value)
    {
        try
        {
            return notCheck != (Math.abs(Float.parseFloat(String.valueOf(actual))-value)<Float.MIN_NORMAL);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeCloseTo(long value)
    {
        try
        {
            return notCheck != (Long.parseLong(String.valueOf(actual))==value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeCloseTo(short value)
    {
        try
        {
            return notCheck != (Short.parseShort(String.valueOf(actual))==value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toBeCloseTo(byte value)
    {
        try
        {
            return notCheck != (Byte.parseByte(String.valueOf(actual))==value);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public boolean toMatch(String regex)
    {
        return notCheck != ((String)actual).matches(regex);
    }

}
