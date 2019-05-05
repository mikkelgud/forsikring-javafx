package com.mikkelgud.filehandling;

import javafx.collections.ObservableList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ObjectFileSaver implements FileSaver {

    @Override
    public void toFile(ObservableList<? extends FileObjectEntity> entitiesToSave, String path) throws IOException, SaveFileException {
        // Håndtere oppretting av FileObjectEntities til en .jobj fil her!
        List<String> rows = new ArrayList<>();

        createSerilaizableData(entitiesToSave, rows);

        List<String> errors = new ArrayList<>();

        try {

            writeToFile(path, rows, errors);

            if (errors.size() > 0) {
                // Dersom noen feil forekom samler vi opp feilene, og skriver de eventuelt ut med en ny linje for hver feil.
                throw new SaveFileException(String.join("\n", errors));
            }

        } catch (IOException e) {
            throw new SaveFileException(e.getMessage());
        }
    }

    public void createSerilaizableData(ObservableList<? extends FileObjectEntity> entitiesToSave, List<String> rows){

        entitiesToSave.forEach(x ->{
            rows.add(x.getFieldValues().toString());
        });


    }
    public void writeToFile(String path, List<String> rows, List<String> errors) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(rows);
        fileOutputStream.close();
        outputStream.close();
    }
}
