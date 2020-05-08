package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void write(String string, String fileP) {
        String oldCredentials = ReadFromFile.read(fileP);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileP));){
            writer.write(oldCredentials + string);

        } catch (IOException e) {
            System.out.println("Nema datog fajla !");
        }
    }
}
