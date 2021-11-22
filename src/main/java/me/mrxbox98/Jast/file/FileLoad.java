package me.mrxbox98.Jast.file;

import com.google.gson.Gson;
import me.mrxbox98.Jast.core.JastTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileLoad {

    /**
     * Reads the test from a file
     * @param c the class to like the test to
     * @param f the file the test is in
     * @return the test
     * @throws FileNotFoundException If the file does not exist
     */
    public static JastTest loadFromFile(Class c, File f) throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(f);

        return gson.fromJson(fileReader, JastTest.class);
    }

}
