package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void write(String user, String fileP) {
        try{
            String oldCredentials =  ReadFromFile.read(fileP);

            File file = new File(fileP);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(oldCredentials + user);
            writer.close();
        } catch (IOException e) {
            System.out.println("Nema datog fajla !");
        }
    }
}
