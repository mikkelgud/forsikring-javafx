/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readFromFile;

import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author alexanderbjorlo
 */
public class ReadStrategy implements ReadFromFile {
    public Stage stage;
    FileChooser fc = new FileChooser();
    String fileName = fc.getInitialFileName();
    File selectedFile = fc.showOpenDialog(stage);
    public void read(String fileType) throws IOException {
        switch(fileType){
            case ".csv":
                System.out.println("heyhey");
                ReadFromCSV csv = new ReadFromCSV(fileName);
                csv.readCSV();
                break;
            case ".jobj":
                    break;
        }
            
        
        
    }
    @Override
    public void ReadFromFile(File file) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
