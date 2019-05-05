package com.mikkelgud.filehandling;

import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvFileSaver implements FileSaver {

    @Override
    public void toFile(ObservableList<? extends FileObjectEntity> entitiesToSave, String path) throws SaveFileException {
        List<String> rows = new ArrayList<>();

        createCsvRows(entitiesToSave, rows);

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

    private void createCsvRows(ObservableList<? extends FileObjectEntity> entitiesToSave, List<String> rows) {
        // Siden alle elementene i programmet har definert feltene sine via metodene i FileObjectEntity,
        // kan vi enkelt kalle på de implementerte metodene for å skrive ut feltverdier / feltnavn.
        entitiesToSave.forEach(x -> {
            if (rows.isEmpty()) {
                // Vi ønsker å skrive ut "headeren" øverst i CSV-filen.
                rows.add(String.join(";", x.getDeclaredFields()));
            }
            String row = String.join(";", x.getFieldValues());
            rows.add(row);
        });
    }

    private void writeToFile(String path, List<String> rows, List<String> errors) throws IOException {
        FileWriter file = new FileWriter(path);

        // Vi legger til et \n for å indikere en ny linje i filen.
        rows.stream().map(row -> row + "\n").forEach(line -> {
            try {
                file.write(line);
            } catch (IOException e) {
                errors.add(e.getMessage());
            }
        });
        file.flush();
        file.close();
    }
}
