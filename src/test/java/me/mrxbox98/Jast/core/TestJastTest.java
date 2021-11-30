package me.mrxbox98.Jast.core;

public class TestJastTest {

    public static void main(String[] args) throws NoSuchMethodException {
        testReturnTrue();
    }

    public static boolean returnTrue()
    {
        return true;
    }

    public static void testReturnTrue() throws NoSuchMethodException {
        System.out.println(new JastTest().setMethod(TestJastTest.class.getMethod("returnTrue")).setExpected(true).test(true));
    }

}
