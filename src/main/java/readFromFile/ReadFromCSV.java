/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readFromFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author alexanderbjorlo
 */
public class ReadFromCSV implements ReadFromFile{
    public String fileName;
    public ReadFromCSV(String fileName){
        this.fileName = fileName;
    }
    
    public boolean readCSV(){
        Path path = Paths.get(fileName.concat(".csv"));
        String line;
        try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8))
            {
            while((line = reader.readLine()) != null){
            System.out.println(line);
    
            }
            } catch(IOException e){
                e.printStackTrace();
            }
        return false;
    
        }    

    public boolean ReadFromFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void writeToFile(File file) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ReadFromFile(File file) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
