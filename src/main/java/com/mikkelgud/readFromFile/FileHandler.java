
package com.mikkelgud.readFromFile;

import javafx.stage.FileChooser;

import java.io.File;

public class FileHandler implements Runnable{
    //Threading
    
    public String getFileExtension(){
        File selectedFile = openReadFile();
        return getFileName(selectedFile).substring(getFileName(selectedFile).lastIndexOf(".") 
                + 1, selectedFile.getName().length());
    }
    public File openReadFile(){
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);
        if(file != null){
            return file;
        } else{
            return null;
        }
        
    }
    
    public String getFileName(File file){
        return file.getName(); 
    }



    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
