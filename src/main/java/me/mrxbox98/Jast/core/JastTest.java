package me.mrxbox98.Jast.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class JastTest<E> {

    public static void main(String[] args)
    {
        JastTest<String> jastTest = new JastTest<>();
        try {
            jastTest.setMethod(JastTest.class.getMethod("testString"));
            jastTest.setExpected("test");
            jastTest.setName("TestName");
            jastTest.setDescription("TestDescription");
            jastTest.test();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static String testString()
    {
        return "test";
    }

    Method method;

    E[] expected;

    String description;

    Object[] parameters;

    Object caller;

    String name;

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
            Object ret = method.invoke(caller, parameters);

            for(E e: expected)
            {
                if(e.equals(ret))
                {
                    if(print)
                    {
                        System.out.println("\u001b[30m\u001b[42;1m PASS");
                        printMethod();
                    }
                    return true;
                }
            }
            if(print)
            {
                System.out.println("\u001b[30m\u001b[41;1m FAIL");
                System.out.println("Got "+ret+" but expected "+ Arrays.toString(expected));
                printMethod();
            }
            return false;
        } catch (IllegalAccessException e) {
            if(print)
            {
                System.out.println("\u001b[41;1m FAIL");
                System.out.println("\u001b[41;1m NOT ABLE TO ACCESS METHOD");
                printMethod();
                return false;
            }
        } catch (InvocationTargetException e) {
            if(print)
            {
                System.out.println("\u001b[41;1m FAIL");
                System.out.println("\u001b[41;1m NOT ABLE TO ACCESS METHOD");
                printMethod();
                return false;
            }
        }
        return false;
    }

    public void printMethod()
    {
        System.out.println(method.getName());
        System.out.println(name);
        System.out.println(description);
    }

}
