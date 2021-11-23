package me.mrxbox98.Jast.annotation;

import com.google.gson.Gson;
import me.mrxbox98.Jast.core.JastTest;
import me.mrxbox98.Jast.core.MassTest;

import java.lang.reflect.Method;

public class Check {

    /**
     * Checks a class for annotations
     * @param c the class
     * @return the massTest with all of the methods tests
     */
    public static MassTest checkClass(Class c)
    {
        MassTest ret = new MassTest();

        for(Method method: c.getMethods())
        {
            if(!method.isAnnotationPresent(Expect.class))
            {
                continue;
            }
            if(method.getAnnotation(Expect.class).expect().equals(""))
            {
                JastTest jastTest = new JastTest().setMethod(method).setName(method.getName());
                ret.add(jastTest);
            }
            else
            {
                JastTest jastTest = new JastTest().setMethod(method).setName(method.getName()).setExpected(new Gson().fromJson(method.getAnnotation(Expect.class).expect(),method.getReturnType()));
                ret.add(jastTest);
            }
        }
        return ret;
    }

}
