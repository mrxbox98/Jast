package me.mrxbox98.Jast.core;

import java.util.ArrayList;
import java.util.Collections;

public class MassTest {

    public ArrayList<JastTest> tests = new ArrayList<>();

    public void add(JastTest... test)
    {
        Collections.addAll(tests, test);
    }

    /**
     * Prints the data
     * @param print the data
     * @return true if all the tests pass and false otherwise
     */
    public boolean test(boolean print)
    {
        boolean res=true;
        for(int i=0;i<tests.size();i++)
        {
            if(tests.get(i).test(false))
            {
                if(print)
                {
                    printPass(" ("+(i+1)+"/"+tests.size()+")");
                }
            }
            else
            {
                if(print)
                {
                    printFail(" ("+(i+1)+"/"+tests.size()+")");
                }
                res=false;
            }
        }
        return res;
    }

    /**
     * Prints fail
     * BOLD
     * BLACK
     * BRIGHT RED BG
     * @param message the message to print
     */
    public void printFail(String message)
    {
        System.out.println("\u001b[1m\u001b[30m\u001b[41;1m FAIL \u001b[0m"+message);
    }

    /**
     * Prints fail
     * BOLD
     * BLACK
     * BRIGHT GREEN BG
     * @param message the message to print
     */
    public void printPass(String message)
    {
        System.out.println("\u001b[1m\u001b[30m\u001b[42;1m PASS \u001b[0m"+message);
    }

}
