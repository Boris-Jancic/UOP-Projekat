package main;

import models.*;

import java.io.*;
import java.util.ArrayList;

public class loadUsers {

    public static void main(String[] args) throws IOException {
        load();
    }

    public static void load() throws IOException {
        File file = new File("src/login/korisnici.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] userSplit = line.split("\\|");
            String name = userSplit[0];
            String lastName = userSplit[1];
            String jmbg = userSplit[2];
            String gender = userSplit[3];
            String addres = userSplit[4];
            String phone = userSplit[5];
            String username = userSplit[6];
            String password = userSplit[7];
            String id = userSplit[8];
            String role = userSplit[9];

            if (role.equals("1")) {
                client c = new client(id, name, lastName, jmbg, gender, phone, username, password, id);
                System.out.println(c.toString());
            }
            if (role.equals("2")) {
                worker w = new worker(id, name, lastName, jmbg, gender, phone, username, password, id);
                System.out.println(w.toString());
            }
            if (role.equals("3")) {
                admin a = new admin(id, name, lastName, jmbg, gender, phone, username, password, id);
                System.out.println(a.toString());
            }
        }
    }
}
