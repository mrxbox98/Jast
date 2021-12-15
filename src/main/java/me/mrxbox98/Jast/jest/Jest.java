package me.mrxbox98.Jast.jest;

public class Jest {

    public static Data test(String description, Test test)
    {
        boolean pass = test.test();
        if(pass)
        {
            System.out.println("\u001b[32;1m✓\u001b[0m " + description);
        }
        else
        {
            System.out.println("\u001b[31;1m[FAIL]\u001b[0m " + description);
        }
        return new Data(description, pass);
    }

    public static void describe(String description, Describe test)
    {
        Data pass = test.describe();

        if(pass.isSuccess())
        {
            System.out.println("\u001b[32;1m[PASS]\u001b[0m " + description);
        }
        else
        {
            System.out.println("\u001b[31;1m[FAIL]\u001b[0m " + description);
        }
    }

    public static Expect expect(Object expect)
    {
        return new Expect(expect);
    }
}
