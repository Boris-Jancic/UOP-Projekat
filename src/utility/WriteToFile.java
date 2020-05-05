package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void write(String string, String fileP) {
        try{
            String oldCredentials =  ReadFromFile.read(fileP);

            File file = new File(fileP);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(oldCredentials + string);
            writer.close();
        } catch (IOException e) {
            System.out.println("Nema datog fajla !");
        }
    }

    public void writeCarToUser(String id, String car){
        ReadFromFile readFromFile = new ReadFromFile();
        String[] korisnici = readFromFile.read("src/data/korisnici.txt").split("\n");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/korisnici.txt"));
            String output = new String();

            for(String user : korisnici) {
                String[] userSplit = user.split("\\|");
                String role = userSplit[0];
                String userId = userSplit[9];

                if (role.equals("1") && userId.equals(id)){
                    String cars = userSplit[11];
                    user = user.replace(cars, cars + "," + car);
                    System.out.println(user);
                }
                output += user + "\n";
            }
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            System.out.println("Nema datog fajla !");
        }
    }
}
