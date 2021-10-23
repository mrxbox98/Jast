# Jast
***
A fast testing utility for Java based off of Jest for Javascript

```java
import me.mrxbox98.Jast.core.JastTest;

public class Test {
    public static void main(String[] args) {
        //Creates a new test
        JastTest<String> jastTest = new JastTest<>();
        //Use reflection to get the method to test
        jastTest.setMethod(Test.class.getMethod("getString"));
        //Unlimited number of expected values
        jastTest.setExpected("tet","test");
        //Name of the test
        jastTest.setName("TestName");
        //Description of the test
        jastTest.setDescription("TestDescription");
        //The time the test should take in milliseconds
        jastTest.setTime(50);
        //Tests the method. Add a boolean param to determine if the results should be printed out
        jastTest.test();
    }

    public static String getString() {
        return "test";
    }
}
```
![image](https://user-images.githubusercontent.com/29240392/138388002-dd7d2d3d-e82f-419b-a635-c235c4869f53.png)

## Chaining
Jast supports chaining so you can write an entire test in one line.
```java
import me.mrxbox98.Jast.core.JastTest;

public class Test {
    public static void main(String[] args) {
        //Creates a new test and sets both the method and expected values in one line
        JastTest<String> jastTest = new JastTest<>().jastTest.setMethod(Test.class.getMethod("getString")).setExpected("tet","test");
    }

    public static String getString() {
        return "test";
    }
}
```

## Mass Testing
You call add multiple tests to a mass test in order to tests multiple methods at a time.
```java
import me.mrxbox98.Jast.core.JastTest;
import me.mrxbox98.Jast.core.MassTest;

public class Test {

    public static void main(String[] args)
    {
        try {
            MassTest<Byte> byteMassTest = new MassTest<>();

            JastTest<Byte> byteTest1 = new JastTest<>();
            byteTest1.setMethod(Test.class.getMethod("byteTest1"));
            byteTest1.setExpected((byte) 1);
            byteMassTest.add(byteTest1);

            JastTest<Byte> byteTest2 = new JastTest<>();
            byteTest2.setMethod(Test.class.getMethod("byteTest2"));
            byteTest2.setExpected((byte) 2);
            byteMassTest.add(byteTest2);

            JastTest<Byte> byteTest3 = new JastTest<>();
            byteTest3.setMethod(Test.class.getMethod("byteTest3"));
            byteTest3.setExpected();
            byteMassTest.add(byteTest3);



            byteMassTest.test(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static Byte byteTest1()
    {
        return 1;
    }

    public static Byte byteTest2()
    {
        return 2;
    }

    public static Byte byteTest3()
    {
        return null;
    }

}
```
![image](https://user-images.githubusercontent.com/29240392/138393589-3d9f2fb6-cd46-48e9-ba6f-68f6271955f3.png)