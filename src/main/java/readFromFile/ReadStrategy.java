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
    
    public Stage getStage(Stage stage){
        return this.stage = stage;
    }
    public void read() throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(stage);
        String fileName = selectedFile.getName();  
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, selectedFile.getName().length());
        System.out.print(fileExtension);
        switch(fileExtension){
            case "csv":
                System.out.println("heyhey");
                ReadFromCSV csv = new ReadFromCSV(fileName, selectedFile);
                csv.readCSV();
                break;
            case "jobj":
                    break;
        }
            
        
        
    }

}
