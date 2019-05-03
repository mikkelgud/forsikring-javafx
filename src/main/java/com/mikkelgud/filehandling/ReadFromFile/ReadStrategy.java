/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikkelgud.filehandling.ReadFromFile;

import com.mikkelgud.filehandling.FileHandler;
import com.mikkelgud.person.InvalidPersonPropertiesException;

import java.io.File;

public class ReadStrategy extends ReadFromFile {
    FileHandler fileHandler = new FileHandler();


    public void readFile() throws InvalidPersonPropertiesException {
        File file = fileHandler.getReadFile();
        switch (fileHandler.getFileExtension()) {
            case "csv":
                var csv = new ReadFromCSV(fileHandler.getFileName(file), file).readCSV();
                break;
            case "jobj":
                break;
        }


    }

}