package me.mrxbox98.Jast.core;

import com.google.gson.annotations.Expose;
import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import me.mrxbox98.Jast.Static;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Mrxbox98
 */
public class JastTest {



    /**
     * Method to call
     */
    private JastMethod method;

    /**
     * Expected values
     */
    @Expose
    private Optional<Object[]> expected = Optional.empty();

    /**
     * Description of the test
     */
    @Expose
    private Optional<String> description = Optional.empty();

    /**
     * Parameters to call the method with
     */
    @Expose
    private Optional<Object[]> parameters = Optional.empty();

    /**
     * The caller of the method - Not required for static methods
     */
    @Expose
    private Optional<Object> caller = Optional.empty();

    /**
     * How long the method should take
     */
    @Expose
    private Optional<Long> time = Optional.empty();

    /**
     * Check for strictly equals instead of Object#equals(Object obj)
     */
    @Expose
    boolean strictEquals;

    /**
     * Sets the expected values
     * @param expected The expected values
     * @return the current object for chaining
     */
    public JastTest setExpected(Object... expected)
    {
        this.expected=Optional.of(expected);
        return this;
    }

    /**
     * Sets the description of the object
     * @param description the description
     * @return the current object for chaining
     */
    public JastTest setDescription(String description)
    {
        this.description=Optional.of(description);
        return this;
    }

    /**
     * Sets the parameters of the call
     * @param params the parameters of the object call
     * @return the current object for chaining
     */
    public JastTest setParameters(Object... params)
    {
        this.parameters=Optional.of(params);
        return this;
    }

    /**
     * Sets the calling object of the
     * @param caller of the method
     * @return the current object for chaining
     */
    public JastTest setCaller(Object caller)
    {
        this.caller=Optional.of(caller);
        return this;
    }

    /**
     * Sets the method to call
     * @param method the method to call
     * @return the current object for chaining
     */
    public JastTest setMethod(Method method)
    {
        this.method=new JastMethod(method);
        return this;
    }

    /**
     * Sets the time the method should take to complete
     * @param time the time it should take
     * @return the current object for chaining
     */
    public JastTest setTime(long time)
    {
        this.time=Optional.of(time);
        return this;
    }

    /**
     * Sets whether the test should use == or .equals
     * @param strictEquals whether the test should use == or .equals
     * @return the current object for chaining
     */
    public JastTest setStrictEquals(boolean strictEquals)
    {
        this.strictEquals=strictEquals;
        return this;
    }

    /**
     * Tests the method
     * @return true if the method works and false otherwise
     */
    public boolean test()
    {
        return test(true);
    }

    /**
     * Tests the method
     * @param print Whether to print out or not
     * @return The test result
     */
    public boolean test(boolean print)
    {
        return testError(print);
    }

    /**
     * Wrapper for the method test that checks for errors
     * @param print whether the test should print
     * @return true if the test passes; false otherwise
     */
    public boolean testError(boolean print)
    {
        try {
            return testMethod(print);
        }
        catch (IllegalAccessException e)
        {
            if(print)
            {
                printFail();
                fail("NOT ABLE TO ACCESS METHOD");
                printMethod();
                return false;
            }
        }
        catch (InvocationTargetException e)
        {
            for(Object exception: expected.get())
            {
                if(exception.getClass().equals(e.getCause().getClass()))
                {
                    if(print)
                    {
                        printPass();
                        printMethod();
                    }
                    return true;
                }
            }
            if(print)
            {
                printFail();
                fail("UNEXPECTED ERROR");
                for(int i=0;i<e.getCause().getStackTrace().length;i++)
                {
                    fail(e.getCause().getStackTrace()[i].toString());
                }
                printMethod();
            }
            return false;
        }
        catch (WrongNumberArgsException e)
        {
            if(print)
            {
                printFail();
                fail("WRONG NUMBER OF PARAMETERS");
                for(int i=0;i<e.getStackTrace().length;i++)
                {
                    fail(e.getStackTrace()[i].toString());
                }
                printMethod();
            }
        }
        catch (Exception ignored)
        {

        }
        return false;
    }

    /**
     * Tests the Method
     * @param print whether the method should print
     * @return true if the test passes; false otherwise
     * @throws Exception any exception that might be thrown
     */
    public boolean testMethod(boolean print) throws Exception
    {
        long currentTime = System.currentTimeMillis();

        Object ret = method.getMethod().invoke(caller.orElse(null), parameters.orElseGet(() -> new Object[]{}));

        long diff = System.currentTimeMillis()-currentTime;

        if(ret==null && !expected.isPresent())
        {
            if(print)
            {

                printPass();
                pass("Expected no return and got nothing ("+diff+"ms)");
                printMethod();
            }
            return true;
        }
        if(!expected.isPresent())
        {
            if(print)
            {
                printFail();
                fail("No expected values, but returned value was not null");
                printMethod();
            }
            return false;
        }
        for(Object e: expected.get())
        {
            if((strictEquals && e==ret) || (!strictEquals && e.equals(ret)))
            {
                if(time.isPresent() && diff>time.get())
                {
                    if(print)
                    {
                        printFail();
                        fail("Took too long ("+diff+"ms)");
                        printMethod();
                    }
                    return false;
                }

                if(print)
                {

                    printPass();
                    pass("Expected "+ Arrays.toString(expected.get()) + " and got "+ ret + " ("+diff+"ms)");
                    printMethod();
                }
                return true;
            }
        }
        if(print)
        {
            printFail();
            fail("Got "+ret+" but expected "+ Arrays.toString(expected.get()));
            printMethod();
        }
        return false;
    }

    /**
     * Prints fail
     * BOLD
     * BLACK
     * BRIGHT RED BG
     */
    public static void printFail()
    {
        System.out.println("\u001b[1m\u001b[30m\u001b[41;1m FAIL \u001b[0m");
    }

    /**
     * Prints pass
     * BOLD
     * BLACK
     * BRIGHT GREEN BG
     */
    public static void printPass()
    {
        System.out.println("\u001b[1m\u001b[30m\u001b[42;1m PASS \u001b[0m");
    }

    public void printMethod()
    {
        try {
            System.out.println(method.getMethod().getName());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(description.orElse(null));
    }

    /**
     * Prints a fail message with color coding
     * @param message message to print
     */
    public static void fail(String message)
    {
        System.out.println("\u001b[1m \u001b[31mX \u001b[37;1m " + message);
    }

    /**
     * Prints a pass message
     * @param message message to print
     */
    public static void pass(String message)
    {
        System.out.println("\u001b[1m \u001b[32;1m√ \u001b[37;1m " + message);
    }

    /**
     * Converts this test into a string that can be read by FileLoad
     * @see me.mrxbox98.Jast.file.FileLoad
     * @return the JSON version of this test
     */
    @Override
    public String toString()
    {
        return Static.GSON.toJson(this);
    }

}
