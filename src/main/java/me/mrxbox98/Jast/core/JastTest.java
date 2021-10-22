package me.mrxbox98.Jast.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * JastTest
 * @param <E> Return type
 */
public class JastTest<E> {

    public static void main(String[] args)
    {
        JastTest<String> jastTest = new JastTest<>();
        try {
            jastTest.setMethod(JastTest.class.getMethod("testString"));
            jastTest.setExpected("tet","test");
            jastTest.setName("TestName");
            jastTest.setDescription("TestDescription");
            jastTest.setTime(50);
            jastTest.test();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static String testString()
    {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test";
    }

    Method method;

    E[] expected;

    String description;

    Object[] parameters;

    Object caller;

    String name;

    long time;

    public JastTest()
    {

    }

    public JastTest<E> setExpected(E... expected)
    {
        this.expected=expected;
        return this;
    }

    public JastTest<E> setDescription(String description)
    {
        this.description=description;
        return this;
    }

    public JastTest<E> setName(String name)
    {
        this.name=name;
        return this;
    }

    public JastTest<E> setParameters(Object... params)
    {
        this.parameters=params;
        return this;
    }

    public JastTest<E> setCaller(Object caller)
    {
        this.caller=caller;
        return this;
    }

    public JastTest<E> setMethod(Method method)
    {
        this.method=method;
        return this;
    }

    public JastTest<E> setTime(long time)
    {
        this.time=time;
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
        try {
            long currentTIme = System.currentTimeMillis();

            Object ret = method.invoke(caller, parameters);

            long afterTime = System.currentTimeMillis();

            long diff = afterTime-currentTIme;

            for(E e: expected)
            {
                if(e.equals(ret))
                {
                    if(diff>time)
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
                        pass("Expected "+ Arrays.toString(expected) + " and got "+ ret + " ("+diff+"ms)");
                        printMethod();
                    }
                    return true;
                }
            }
            if(print)
            {
                printFail();
                fail("Got "+ret+" but expected "+ Arrays.toString(expected));
                printMethod();
            }
            return false;
        } catch (IllegalAccessException e) {
            if(print)
            {
                printFail();
                fail("NOT ABLE TO ACCESS METHOD");
                printMethod();
                return false;
            }
        } catch (InvocationTargetException e) {
            if(print)
            {
                printFail();
                fail("INCORRECT METHOD");
                printMethod();
                return false;
            }
        }
        return false;
    }

    /**
     * Prints fail
     * BOLD
     * BLACK
     * BRIGHT RED BG
     */
    public void printFail()
    {
        System.out.println("\u001b[1m\u001b[30m\u001b[41;1m FAIL \u001b[0m");
    }

    /**
     * Prints fail
     * BOLD
     * BLACK
     * BRIGHT GREEN BG
     */
    public void printPass()
    {
        System.out.println("\u001b[1m\u001b[30m\u001b[42;1m PASS \u001b[0m");
    }

    public void printMethod()
    {
        System.out.println(method.getName());
        System.out.println(name);
        System.out.println(description);
    }

    /**
     * Prints a fail message with color coding
     * @param message message to print
     */
    public void fail(String message)
    {
        System.out.println("\u001b[1m \u001b[31m❌ \u001b[37;1m " + message);
    }

    /**
     * Prints a pass message
     * @param message message to print
     */
    public void pass(String message)
    {
        System.out.println("\u001b[1m \u001b[32;1m✓ \u001b[37;1m " + message);
    }

}
