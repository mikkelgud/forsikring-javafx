
package com.mikkelgud.filehandling.ReadFromFile;

import com.mikkelgud.person.InvalidPersonPropertiesException;
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

    public boolean readCSV() throws InvalidPersonPropertiesException {

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
        String[] splitted = fields.split(";");
        System.out.print(splitted.length);
        try {
           return new PersonData(splitted[1],
                    splitted[2],
                    splitted[3],
                    Boolean.parseBoolean(splitted[4]),
                    Boolean.parseBoolean(splitted[5]),
                    Boolean.parseBoolean(splitted[6]),
                    Boolean.parseBoolean(splitted[7]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
