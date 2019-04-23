/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author alexanderbjorlo
 */
public class SaveToCSV implements SaveToFile {
    public String[] database;
    public String fileName;
    public SaveToCSV(String[] database, String fileName){
        this.database = database;
        this.fileName = fileName;
    }
    
    public String convertToCSV(){
        // Converts data to CSV type format
        return Stream.of(database)
            .map(this::escapeSpecialCharacters)
            .collect(Collectors.joining(","));
    }

public String escapeSpecialCharacters(String database) {
    // Escapes special characters
    String escapedData = database.replaceAll("\\R", " ");
    if (database.contains(",") || database.contains("\"") || database.contains("'")) {
        database = database.replace("\"", "\"\"");
        escapedData = "\"" + database + "\"";
    }
    return escapedData;
    }
public void saveFile() throws FileNotFoundException{
    File file = new File(fileName);
    
    PrintWriter pw = new PrintWriter(file);
    String csvData = convertToCSV();
    pw.write(csvData);
    
    }


    public boolean SaveToFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean SaveFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
