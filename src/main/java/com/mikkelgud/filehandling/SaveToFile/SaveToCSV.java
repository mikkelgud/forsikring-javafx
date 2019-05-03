
package com.mikkelgud.filehandling.SaveToFile;

import com.mikkelgud.person.Person;
import com.mikkelgud.person.PersonListModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SaveToCSV implements SaveToFile {
    private PrintWriter pw;


    public void write(File file) throws FileNotFoundException {
        this.pw = new PrintWriter(file);
        PersonListModel plm = new PersonListModel();
        plm.getPersonList().forEach(this::writePerson);
    }

    public void writePerson(Person person) {
        this.pw.println(toCSV(new String[]{"personData",
                person.firstNameProperty().getValue(),
                person.lastNameProperty().getValue(),
                person.billingAddressProperty().getValue(),
        }));
    }

    private String toCSV(String[] data) {
        return Arrays.stream(data).reduce("", (acc, curr) -> acc + curr + ";");
    }


    @Override
    public boolean SaveFile(String fileName) {
        return false;
    }
}