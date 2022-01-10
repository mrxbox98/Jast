package me.mrxbox98.Jast.jest;

import java.util.function.Consumer;

public class Jest {

    public static Data test(String description, Consumer test)
    {
        boolean pass = false;
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

    public static void describe(String description, Consumer test)
    {
        Data[] passes = null;

        for(Data pass: passes)
        {
            if(pass.isSuccess())
            {
                System.out.println("\u001b[32;1m[PASS]\u001b[0m " + description);
            }
            else
            {
                System.out.println("\u001b[31;1m[FAIL]\u001b[0m " + description);
            }
        }
    }

    public static Expect expect(Object expect)
    {
        return new Expect(expect);
    }
}
