/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaveToFile;

import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author alexanderbjorlo
 */
public class SaveStrategy implements SaveToFile {
    public static void save(Stage stage, String fileType, String fileName) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(stage);
        switch(fileType){
            case ".csv":
                String[] database = {"",""};
                SaveToCSV csv = new SaveToCSV(database, fileName);
                csv.saveFile();
                break;
            case ".jobj":
                    break;
        }
            
        
        
    }

    public boolean SaveToFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean SaveFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
