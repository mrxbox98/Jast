package me.mrxbox98.Jast.test;

import me.mrxbox98.Jast.core.JastTest;
import me.mrxbox98.Jast.core.MassTest;

public class ByteTest {

    public static void main(String[] args)
    {
        try {
            MassTest<Byte> byteMassTest = new MassTest<>();

            JastTest<Byte> byteTest1 = new JastTest<>();
            byteTest1.setMethod(ByteTest.class.getMethod("byteTest1"));
            byteTest1.setExpected((byte) 1);
            byteMassTest.add(byteTest1);

            JastTest<Byte> byteTest2 = new JastTest<>();
            byteTest2.setMethod(ByteTest.class.getMethod("byteTest2"));
            byteTest2.setExpected((byte) 2);
            byteMassTest.add(byteTest2);

            JastTest<Byte> byteTest3 = new JastTest<>();
            byteTest3.setMethod(ByteTest.class.getMethod("byteTest3"));
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
