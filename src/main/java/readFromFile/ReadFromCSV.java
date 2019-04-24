
package readFromFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alexanderbjorlo
 */
public class ReadFromCSV implements ReadFromFile{
    public String fileName;
    public File file;
    public ReadFromCSV(String fileName, File file){
        this.fileName = fileName;
        this.file = file;
    }
    
    public boolean readCSV(){
        String line;
        BufferedReader reader = null;
        try 
            {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                parseData(line);
            }
            } catch(IOException e){
                e.printStackTrace();
            }
        
        return false;
    
        }    
    public void parseData(String line){
        
    }
    public boolean ReadFromFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void writeToFile(File file) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
