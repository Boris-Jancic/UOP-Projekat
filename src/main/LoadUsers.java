package main;

import userModels.*;

import java.io.*;

public class LoadUsers {

    public void load() throws IOException {
        File file = new File("src/data/korisnici.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] userSplit = line.split("\\|");
            String role = userSplit[0];
            String name = userSplit[1];
            String lastName = userSplit[2];
            String jmbg = userSplit[3];
            String gender = userSplit[4];
            String address = userSplit[5];
            String phone = userSplit[6];
            String username = userSplit[7];
            String password = userSplit[8];
            String id = userSplit[9];

            if (role.equals("1")) {
                int points = Integer.parseInt(userSplit[10]);
                Client c = new Client(name, lastName, jmbg, gender, address, phone, username, password, points);
                System.out.println(c.toString());
            }
            if (role.equals("2")) {
                Double sallary = Double.parseDouble(userSplit[10]);
                String specialization = userSplit[11];
                Worker w = new Worker(name, lastName, jmbg, gender, address, phone, username, password, specialization, sallary);
                System.out.println(w.toString());
            }
            if (role.equals("3")) {
                Double sallary = Double.parseDouble(userSplit[10]);
                Admin a = new Admin(name, lastName, jmbg, gender, address, phone, username, password, sallary);
                System.out.println(a.toString());
            }
        }
    }
}
