![image](https://user-images.githubusercontent.com/29240392/138798545-210a25cb-ad78-41be-a0a3-e3086e1390eb.png) 
# Jast
[![Release](https://jitpack.io/v/me.mrxbox98/Jast.svg)](https://jitpack.io/#me.mrxbox98/Jast)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fmrxbox98%2FJast.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fmrxbox98%2FJast?ref=badge_shield)
[![CodeFactor](https://www.codefactor.io/repository/github/mrxbox98/jast/badge/main)](https://www.codefactor.io/repository/github/mrxbox98/jast/overview/main)
***
```xml
<depedencies>
    <dependency>
        <groupId>me.mrxbox98.Jast</groupId>
        <artifactId>jast</artifactId>
        <version>2.1.1</version>
    </dependency>
</depedencies>
```
***
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
***
A fast testing utility for Java based off of Jest for Javascript

```java
import me.mrxbox98.Jast.core.JastTestTests;

public class Test {
    public static void main(String[] args) {
        //Creates a new test
        JastTest jastTest = new JastTest();
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
import me.mrxbox98.Jast.core.JastTestTests;

public class Test {
    public static void main(String[] args) {
        //Creates a new test and sets both the method and expected values in one line
        JastTest jastTest = new JastTest().jastTest.setMethod(Test.class.getMethod("getString")).setExpected("tet","test");
    }

    public static String getString() {
        return "test";
    }
}
```

## Mass Testing
You call add multiple tests to a mass test in order to tests multiple methods at a time.
```java
import me.mrxbox98.Jast.core.JastTestTests;
import me.mrxbox98.Jast.core.MassTest;

public class Test {

    public static void main(String[] args)
    {
        try {
            MassTest byteMassTest = new MassTest();

            JastTest byteTest1 = new JastTest();
            byteTest1.setMethod(Test.class.getMethod("byteTest1"));
            byteTest1.setExpected((byte) 1);
            byteMassTest.add(byteTest1);

            JastTest byteTest2 = new JastTest();
            byteTest2.setMethod(Test.class.getMethod("byteTest2"));
            byteTest2.setExpected((byte) 2);
            byteMassTest.add(byteTest2);

            JastTest byteTest3 = new JastTest();
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

## Error Testing
```java
import me.mrxbox98.Jast.core.JastTestTests;
import me.mrxbox98.Jast.core.MassTest;

public class ByteTest {
    public static void main(String[] args)
    {
        try {
            MassTest byteMassTest = new MassTest();

            JastTest byteTest1 = new JastTest();
            byteTest1.setMethod(ByteTest.class.getMethod("byteTest1"));
            byteTest1.setExpected((byte) 1);
            byteMassTest.add(byteTest1);

            JastTest byteTest2 = new JastTest();
            byteTest2.setMethod(ByteTest.class.getMethod("byteTest2"));
            byteTest2.setExpected((byte) 2);
            byteMassTest.add(byteTest2);

            JastTest byteTest3 = new JastTest();
            byteTest3.setMethod(ByteTest.class.getMethod("byteTest3"));
            byteTest3.setExpected();
            byteMassTest.add(byteTest3);

            JastTest byteTest4 = new JastTest();
            byteTest4.setMethod(ByteTest.class.getMethod("byteTest4"));
            byteTest4.setExpected(new ArrayIndexOutOfBoundsException());
            byteMassTest.add(byteTest4);

            JastTest byteTest5 = new JastTest();
            byteTest5.setMethod(ByteTest.class.getMethod("byteTest5"));
            byteTest5.setExpected(new IllegalArgumentException());
            byteMassTest.add(byteTest5);

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

    public static Byte byteTest4()
    {
        throw new ArrayIndexOutOfBoundsException();
    }

    public static Byte byteTest5()
    {
        throw new IllegalArgumentException();
    }

}
```
![image](https://user-images.githubusercontent.com/29240392/138796086-16be5c3f-bb79-4ebb-8c29-8dbbab55b27a.png)


## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fmrxbox98%2FJast.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fmrxbox98%2FJast?ref=badge_large)