/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikkelgud.filehandling;

import com.mikkelgud.person.InvalidPersonPropertiesException;

import java.io.File;
import java.io.IOException;

public class ReadStrategy extends ReadFromFile {

    public void read() throws IOException, InvalidPersonPropertiesException {
        FileHandler filehandler = new FileHandler();
        File file = filehandler.openReadFile();
        switch (filehandler.getFileExtension()) {
            case "csv":
                var csv = new ReadFromCSV(filehandler.getFileName(file), file).readCSV();
                break;
            case "jobj":
                break;
        }


    }

}