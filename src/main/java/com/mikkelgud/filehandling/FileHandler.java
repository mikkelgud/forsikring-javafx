
package com.mikkelgud.filehandling;

import javafx.stage.FileChooser;

import java.io.File;

public class FileHandler {

    FileChooser fileChooser = new FileChooser();

    public File getReadFile(){
        return fileChooser.showOpenDialog(null);

    }

    private String getSavePath(){
        File file =fileChooser.showSaveDialog(null);
        return file.getAbsolutePath();
    }

    public String getFileName(File file) {
        return file.getName();
    }

    public String getFileExtension() {
        File selectedFile = getReadFile();
        return getFileName(selectedFile).substring(getFileName(selectedFile).lastIndexOf(".")
                + 1, selectedFile.getName().length());
    }
}
