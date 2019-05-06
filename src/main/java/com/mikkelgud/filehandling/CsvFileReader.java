package com.mikkelgud.filehandling;

import com.mikkelgud.claim.ClaimInsurance;
import com.mikkelgud.insurance.BoatInsurance;
import com.mikkelgud.insurance.CabinInsurance;
import com.mikkelgud.insurance.HouseInsurance;
import com.mikkelgud.insurance.TravelInsurance;
import com.mikkelgud.person.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFileReader implements FileReader {
     public List<Object> fromFile(File file) { {
        List<String> csvLines = readLines(file);

        if (!csvLines.isEmpty()) {
            String firstLineOfCsvFile = csvLines.get(0);

            // Vi ønsker ikke lage et objekt av CSV-headeren!
            csvLines.remove(0);


            List<String> declaredCsvFields = Arrays.asList(firstLineOfCsvFile.split(";"));

            // Legg til en tom konstruktør i Person, General Insurance osv...
            // Sjekk om declared fields i CSV-filen matcher en Person-objekt sine declared fields.
            if (declaredCsvFields.containsAll(new Person().getDeclaredFields())) {
                return csvLines.stream().map(line -> new Person().getObjectForString(line)).collect(Collectors.toList());

            } else if (declaredCsvFields.containsAll(new BoatInsurance().getDeclaredFields())) {
                return csvLines.stream().map(line -> new BoatInsurance().getObjectForString(line)).collect(Collectors.toList());

            } else if (declaredCsvFields.containsAll(new TravelInsurance().getDeclaredFields())) {
                return csvLines.stream().map(line -> new TravelInsurance().getObjectForString(line)).collect(Collectors.toList());

            } else if (declaredCsvFields.containsAll(new CabinInsurance().getDeclaredFields())) {
                return csvLines.stream().map(line -> new CabinInsurance().getObjectForString(line)).collect(Collectors.toList());

            } else if (declaredCsvFields.containsAll(new ClaimInsurance().getDeclaredFields())) {
                return csvLines.stream().map(line -> new ClaimInsurance().getObjectForString(line)).collect(Collectors.toList());

            } else if (declaredCsvFields.containsAll(new HouseInsurance().getDeclaredFields())) {
                return csvLines.stream().map(line -> new HouseInsurance().getObjectForString(line)).collect(Collectors.toList());
            } else {
                throw new IllegalArgumentException("Wops! Vi vet ikke hvilke objekter denne filen passer med.");
            }
        }
        return new ArrayList<>();
    }


}
    public List<String> readLines(File file){
         List<String> lineValues = new ArrayList<>();
         try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(file)))){
               stream.forEach(line -> {
                lineValues.add(String.format("%s",line));
             });

         } catch (IOException e) {
             e.printStackTrace();
         }
        return lineValues;

    }
    @Override
    public List<? extends FileObjectEntity> getObjectForString(List<String> values) {
        return null;
    }
}

