package main;

import userModels.*;
import utility.Checks;
import utility.ReadFromFile;

import java.io.*;

public class LoadUsers {

    public void load() throws IOException {
        ReadFromFile readFromFile = new ReadFromFile();
        Checks c = new Checks();
        String[] users = readFromFile.read("src/data/korisnici.txt").split("\n");

        for (String user : users){
            String[] userSplit = user.split("\\|");
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
                Client client = c.findClient(id);
                client.setId(id);
                System.out.println(client.toString());
            }
            if (role.equals("2")) {
                Double sallary = Double.parseDouble(userSplit[10]);
                String specialization = userSplit[11];
                Worker w = new Worker(name, lastName, jmbg, gender, address, phone, username, password, specialization, sallary);
                w.setId(id);
                System.out.println(w.toString());
            }
            if (role.equals("3")) {
                Double sallary = Double.parseDouble(userSplit[10]);
                Admin a = new Admin(name, lastName, jmbg, gender, address, phone, username, password, sallary);
                a.setId(id);
                System.out.println(a.toString());
            }
            // TODO: zastita ako nema role
        }
    }
}
