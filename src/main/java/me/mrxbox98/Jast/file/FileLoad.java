package me.mrxbox98.Jast.file;

import com.google.gson.Gson;
import me.mrxbox98.Jast.core.JastTest;

import java.io.*;

public class FileLoad {

    /**
     * Reads the test from a file
     * @param f the file the test is in
     * @return the test
     * @throws FileNotFoundException If the file does not exist
     */
    public static JastTest loadFromFile(File f) throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(f);

        return gson.fromJson(fileReader, JastTest.class);
    }

    /**
     * Saves a JastTest to a file
     * @param f the file to save it to
     * @param j the test to save
     * @throws IOException if the file is not found or a directory
     */
    public static void saveToFile(File f, JastTest j) throws IOException {
        FileWriter fileWriter = new FileWriter(f);

        fileWriter.write(j.toString());
    }

}
