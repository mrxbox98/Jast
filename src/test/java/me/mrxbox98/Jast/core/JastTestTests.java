package me.mrxbox98.Jast.core;

public class JastTestTests {

    public static boolean test(boolean a, boolean b, boolean c)
    {
        return a && b && c;
    }

    public static boolean test()
    {
        return true;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        JastTest jastTest = new JastTest();
        jastTest.setMethod(JastTestTests.class.getMethod("test",boolean.class, boolean.class, boolean.class)).setParameters(true,true,true).setExpected(true);
        System.out.println(jastTest.test());
        System.out.println(jastTest.toString());
    }

}
