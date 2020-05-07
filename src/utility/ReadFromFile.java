package utility;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    public static String read(String fileP){
        File file = new File(fileP);
        try(BufferedReader reader = new BufferedReader(new FileReader(file)) ){
            StringBuilder oldCredenitals = new StringBuilder();

            String line;

            while((line = reader.readLine()) != null){
                oldCredenitals.append(line).append("\n");
            }

            reader.close();
            return oldCredenitals.toString();
        } catch (IOException e) {
            System.out.println("Nema datog fajla !");
        }
        return "";
    }
}
