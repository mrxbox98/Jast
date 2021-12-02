package me.mrxbox98.Jast.core;

import java.lang.reflect.Method;

/**
 * @author Mrxbox98
 */
public class JastMethod {

    /**
     * The name of the class that contains the method
     */
    String className;

    /**
     * The methods name
     */
    String methodName;

    /**
     * The parameter types
     */
    String[] paramTypes;

    /**
     * The JastMethod constructor
     * @param method the method
     */
    public JastMethod(Method method)
    {
        className=method.getDeclaringClass().getName();
        methodName=method.getName();
        paramTypes= new String[method.getParameterTypes().length];
        for(int i=0;i<method.getParameterTypes().length;i++)
        {
            paramTypes[i]=method.getParameterTypes()[i].getName();
        }
    }

    /**
     * Gets the method from the data
     * @return the method
     * @throws ClassNotFoundException if the declaring class in invalid
     * @throws NoSuchMethodException if the method is not there
     */
    public Method getMethod() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName(className);
        Class<?>[] params = new Class<?>[paramTypes.length];
        for(int i=0;i<paramTypes.length;i++)
        {
            switch(paramTypes[i])
            {
                case "int": params[i]=int.class; break;
                case "boolean": params[i]=boolean.class; break;
                case "short": params[i]=short.class; break;
                case "byte": params[i]=byte.class; break;
                case "long": params[i]=long.class; break;
                case "float": params[i]=float.class; break;
                case "double": params[i]=double.class; break;
                case "char": params[i]=char.class; break;
                default: params[i]=Class.forName(paramTypes[i]);
            }
        }
        return clazz.getMethod(methodName, params);
    }

}
