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
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static Byte byteTest1()
    {
        return 1;
    }

}
