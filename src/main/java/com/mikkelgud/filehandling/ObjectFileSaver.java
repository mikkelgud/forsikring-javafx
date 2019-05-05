package com.mikkelgud.filehandling;

import javafx.collections.ObservableList;


public class ObjectFileSaver implements FileSaver {

    @Override
    public void toFile(ObservableList<? extends FileObjectEntity> entitiesToSave, String path) {
        // Håndtere oppretting av FileObjectEntities til en .jobj fil her!
    }
}
