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
