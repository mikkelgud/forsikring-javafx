
package com.mikkelgud.filehandling;

import com.mikkelgud.person.PersonData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromCSV {
    public String fileName;
    public File file;

    public ReadFromCSV(String fileName, File file) {
        this.fileName = fileName;
        this.file = file;
    }

    public boolean readCSV() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String lines = null;
            while ((lines = reader.readLine()) != null) {
                parseData(lines);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public PersonData parseData(String fields) {


        return null;
    }
}
