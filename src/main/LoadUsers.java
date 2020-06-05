package main;

import carModels.Car;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import utility.Checks;
import utility.ReadFromFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LoadUsers {

    public static Set<Person> load(ArrayList<Car> Cars) {
        String[] users = ReadFromFile.read("src/data/korisnici.txt").split("\n");
        Set<Person> people = new HashSet<>();

        for (String user : users) {
            if (!user.isEmpty()) {
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

                if (role.equals("3")) {
                    int points = Integer.parseInt(userSplit[10]);
                    boolean deleted = Boolean.parseBoolean(userSplit[11]);
                    Client client = new Client(name, lastName, jmbg, gender, address, phone, username, password, id, points, deleted);
                    client.setCars(Checks.findCars(Cars, id));
                    people.add(client);
                }
                if (role.equals("2")) {
                    Double salary = Double.parseDouble(userSplit[10]);
                    String specialization = userSplit[11];
                    boolean deleted = Boolean.parseBoolean(userSplit[12]);
                    Worker w = new Worker(name, lastName, jmbg, gender, address, phone, username, password, id, salary, specialization, deleted);
                    w.setId(id);
                    people.add(w);
                }
                if (role.equals("1")) {
                    double salary = Double.parseDouble(userSplit[10]);
                    boolean deleted = Boolean.parseBoolean(userSplit[11]);
                    Admin a = new Admin(name, lastName, jmbg, gender, address, phone, username, password, salary, id, deleted);
                    a.setId(id);
                    people.add(a);
                }
            }
        }
        return people;
    }
}
