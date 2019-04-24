
package SaveToFile;

import com.mikkelgud.person.PersonListModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author alexanderbjorlo
 */
public class SaveToCSV implements SaveToFile {

    public String fileName;
    public String personData;

    
    public SaveToCSV(String personData, String fileName){
        this.fileName = fileName;
        this.personData = personData;
    }

    SaveToCSV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String convertToCSV(){
        // Converts data to CSV type format
        PersonListModel plm = new PersonListModel();
        personData = plm.toString();
        return Stream.of(personData)
            .map(this::escapeSpecialCharacters)
            .collect(Collectors.joining(","));
    }

public String escapeSpecialCharacters() {
    // Escapes special characters
    String escapedData = personData.replaceAll("\\R", " ");
    if (personData.contains(",") || personData.contains("\"") || personData.contains("'")) {
        personData = personData.replace("\"", "\"\"");
        escapedData = "\"" + personData + "\"";
    }
    return escapedData;
    }

public void saveFile() throws FileNotFoundException{
    File file = new File(fileName);
    
    PrintWriter pw = new PrintWriter(file);
    String csvData = convertToCSV();
    pw.write(csvData);
    
    }

    @Override
    public boolean SaveFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
