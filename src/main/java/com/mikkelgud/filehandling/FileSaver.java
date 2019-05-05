package com.mikkelgud.filehandling;

import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileSaver {
    // Måtte legge på <? extends> for å kunne støtte implementasjonene av FileObjectEntity, og ikke den konkrete "FileObjectEntity"-klassen.
    void toFile(ObservableList<? extends FileObjectEntity> entitiesToSave, String filePath) throws SaveFileException, IOException;
}
