package com.mikkelgud.filehandling;


import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class SaveStrategy extends ReadFromFile {



    public static void save(Stage stage) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showSaveDialog(stage);
        String fileName = selectedFile.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, selectedFile.getName().length());
        System.out.println(">> fileExtension" + fileExtension);
        switch (fileExtension) {
            case ".csv":
                String[] database = {"", ""};
                SaveToCSV csv = new SaveToCSV();
                csv.write(selectedFile);
                break;
            case ".jobj":
                break;
        }

    }


    @Override
    public void readFile() {

    }
}
