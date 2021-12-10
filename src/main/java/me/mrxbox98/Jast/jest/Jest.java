package me.mrxbox98.Jast.jest;

public class Jest {

    public static void test(String description, Test test)
    {
        boolean pass = test.test();
        if(pass)
        {
            System.out.println("[PASS] " + description);
        }
        else
        {
            System.out.println("[FAIL] " + description);
        }
    }

    public static Expect expect(Class<?> expect)
    {
        return new Expect(expect);
    }

}
