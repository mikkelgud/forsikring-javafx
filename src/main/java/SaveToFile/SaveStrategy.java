
package SaveToFile;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class SaveStrategy implements SaveToFile {
    public static void save(Stage stage) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(stage);
        String fileName = selectedFile.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, selectedFile.getName().length());
        System.out.println(">> fileExtension" + fileExtension);
        switch(fileExtension){
            case ".csv":
                String[] database = {"",""};
                SaveToCSV csv = new SaveToCSV();
                csv.saveFile();
                break;
            case ".jobj":
                    break;
        }

    }

    @Override
    public boolean SaveFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}