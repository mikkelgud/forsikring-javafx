
package com.mikkelgud.readFromFile;

import com.mikkelgud.person.InvalidPersonPropertiesException;
import com.mikkelgud.person.PersonData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 *
 * @author alexanderbjorlo
 */
public class ReadFromCSV extends ReadFromFile{
    public String fileName;
    public File file;
    public ReadFromCSV(String fileName, File file){
        this.fileName = fileName;
        this.file = file;
    }

    public boolean readCSV() throws InvalidPersonPropertiesException{

        try
            {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String lines = null;
            while((lines = reader.readLine()) != null) {
                parseData(lines);
            }


            } catch(IOException e){
                e.printStackTrace();
            }
        
        return false;
            
        }    
    public PersonData parseData(String fields) {

        PersonData personData = new PersonData();
        String[] splitted = fields.split(";");



        if (splitted[0].equals("personData")){

            personData.setFirstName(splitted[1]);
            personData.setLastName(splitted[2]);
            personData.setBillingAddress(splitted[3]);
            personData.toString();
            return personData;
        }
        personData.attatchToGUI();
        return personData;
    }


    
}
