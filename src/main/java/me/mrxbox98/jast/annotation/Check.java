package me.mrxbox98.Jast.annotation;

import me.mrxbox98.Jast.Static;
import me.mrxbox98.Jast.core.JastTest;
import me.mrxbox98.Jast.core.MassTest;

import java.lang.reflect.Method;

public class Check {

    /**
     * Checks a class for annotations
     * @param c the class
     * @return the massTest with all of the methods tests
     */
    public static MassTest checkClass(Class<?> c)
    {
        MassTest ret = new MassTest();

        for(Method method: c.getMethods())
        {
            if(!method.isAnnotationPresent(Expect.class))
            {
                continue;
            }
            if(method.getReturnType().equals(Void.TYPE))
            {
                JastTest jastTest = new JastTest().setMethod(method);
                ret.add(jastTest);
            }
            else
            {
                JastTest jastTest = new JastTest().setMethod(method).setExpected(Static.GSON.fromJson(method.getAnnotation(Expect.class).expect(),method.getReturnType()));
                ret.add(jastTest);
            }
        }
        return ret.tests.size()==0 ? null : ret;
    }

}
