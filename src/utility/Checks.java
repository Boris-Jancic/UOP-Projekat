package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Checks {

    public Boolean ifUsersExists(String id) {
        try {
            File file = new File("src/data/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] userSplit = line.split("\\|");
                String role = userSplit[0];
                String userID = userSplit[9];
                if (role.equals("1") && userID.equals(id)) {
                        return true;
                }
            }
            reader.close();
            return false;
        } catch (IOException e) {
            System.out.println("Nema datog fajla");
        }
        return false;
    }

    public Boolean ifCarExists(String id) {
        try{
            File file = new File("src/data/cars.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] userSplit = line.split("\\|");
                String role = userSplit[0];
                if (role.equals("1")) {
                    String userID = userSplit[8];
                    if (id.equals(userID))
                        return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Nema datog fajla");
        }
        return false;
    }
}


