
package com.mikkelgud.readFromFile;

import com.mikkelgud.person.InvalidPersonPropertiesException;
import com.mikkelgud.person.PersonData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private final String[] tokens = {
        "FirstName", "LastName", "BillingAddress"
    };
    public boolean readCSV() throws InvalidPersonPropertiesException{
        String line;
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
    public PersonData parseData(String line) throws InvalidPersonPropertiesException{
        String[] splitted = line.split(";");
        System.out.print(Arrays.toString(splitted));
        System.out.print("\n");
        String patternString = "\b(" + Arrays.toString(tokens) + ")\b";
        System.out.print(patternString);
        System.out.print("\n");
        System.out.print(Arrays.toString(splitted));
        System.out.print("\n");
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(Arrays.toString(splitted));
        System.out.print(matcher);
        System.out.print("\n");
        try{ 
            return new PersonData(
            matcher.group("firstName"),
            matcher.group("lastName"),
            matcher.group("billingAddress")
            );
        } catch(Exception e){
            e.printStackTrace();
            throw new InvalidPersonPropertiesException("Error");
        }
        
    }

    public boolean ReadFromFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
