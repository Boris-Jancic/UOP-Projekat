package utility;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    public static String read(String fileP) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileP))) {
            String oldCredenitals = "";

            String line;

            while ((line = reader.readLine()) != null) {
                oldCredenitals += line + "\n";
            }

            reader.close();
            return oldCredenitals;

        } catch (IOException e) {
            System.out.println("Nema datog fajla !");
        }
        return "";
    }
}
