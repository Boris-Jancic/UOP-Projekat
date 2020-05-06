package main;

import carModels.Car;
import userModels.*;
import utility.Checks;
import utility.ReadFromFile;

import java.io.*;
import java.util.ArrayList;

public class LoadUsers {

    public ArrayList<Person> load(ArrayList<Car> Cars) throws IOException {
        ReadFromFile readFromFile = new ReadFromFile();
        Checks c = new Checks();
        String[] users = readFromFile.read("src/data/korisnici.txt").split("\n");
        ArrayList<Person> people = new ArrayList<Person>();

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
                Client client = c.findClient(id);
                client.setId(id);
                client.setCars(c.findCars(Cars, id));
                people.add(client);
            }
            if (role.equals("2")) {
                Double sallary = Double.parseDouble(userSplit[10]);
                String specialization = userSplit[11];
                Worker w = new Worker(name, lastName, jmbg, gender, address, phone, username, password, specialization, sallary);
                w.setId(id);
                people.add(w);
            }
            if (role.equals("3")) {
                Double sallary = Double.parseDouble(userSplit[10]);
                Admin a = new Admin(name, lastName, jmbg, gender, address, phone, username, password, sallary);
                a.setId(id);
                people.add(a);
            }
        }
        return people;
    }
}
