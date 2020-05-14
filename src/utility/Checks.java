package utility;

import carModels.Car;
import carModels.Part;
import main.LoadParts;
import userModels.Client;
import userModels.Worker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Checks {

    public ArrayList<Car> findCars(ArrayList<Car> Cars, String id) {
        ArrayList<Car> carsReturn = new ArrayList<>();

        for (Car car : Cars) {
            Client client = car.getClient();
            if (client.getId().equals(id)) {
                carsReturn.add(car);
            }
        }
        return carsReturn;
    }


    public Car findCar(ArrayList<Car> Cars, String carID) {
        for (Car car : Cars) {
            if (car.getCarID().equals(carID)) {
                return car;
            }
        }
        return null;
    }

    public Worker findWorker(String id) {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] users = readFromFile.read("src/data/korisnici.txt").split("\n");

        if (users[0] != "") {
            for (String user : users) {
                String[] userSplit = user.split("\\|");
                String role = userSplit[0];
                String userID = userSplit[9];
                String name = userSplit[1];
                String lastName = userSplit[2];
                String jmbg = userSplit[3];
                String gender = userSplit[4];
                String address = userSplit[5];
                String phone = userSplit[6];
                String username = userSplit[7];
                String password = userSplit[8];

                if (role.equals("2") && userID.equals(id)) {
                    Double sallary = Double.parseDouble(userSplit[10]);
                    String specialization = userSplit[11];
                    Worker w = new Worker(name, lastName, jmbg, gender, address, phone,
                            username, password, specialization, sallary, id);
                    w.setId(userID);
                    return w;
                }
            }
        }
        return null;
    }

    public Client findClient(String id) {
        String[] users = ReadFromFile.read("src/data/korisnici.txt").split("\n");

        if (!users[0].equals("")) {
            for (String user : users) {
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
                String userID = userSplit[9];

                if (role.equals("3") && userID.equals(id)) {
                    String points = userSplit[10];
                    Client client = new Client(name, lastName, jmbg, gender, address, phone,
                            username, password, Integer.parseInt(points), userID);

                    return client;
                }
            }
        }
        return null;
    }

    public ArrayList<Part> findParts(String[] PartIDs) {
        ArrayList<Part> returnParts = new ArrayList<>();
        LoadParts lp = new LoadParts();
        ArrayList<Part> parts = lp.load();

        for (Part part : parts) {
            for (String partID : PartIDs) {
                if (partID.equals(part.getId()))
                    returnParts.add(part);
            }
        }

        return returnParts;
    }

    public GregorianCalendar stringToDate(String dateP) {
        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            date.setTime(format.parse(dateP));
        } catch (ParseException e) {
            System.out.println("Pogresan unos datuma");
        }

        return date;
    }


    public Boolean writeCarBook(String carIDP, String newServiceID) {

        String[] carBooks = ReadFromFile.read("src/data/carbooks.txt").split("\n");
        String output = "";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/carbooks.txt"))) {
            if (!carBooks[0].equals("")) {
                for (String carBook : carBooks) {
                    String[] carBookSplit = carBook.split("\\|");
                    System.out.println(Arrays.toString(carBookSplit));
                    String carID = carBookSplit[0];
                    String serviceIDs = carBookSplit[1];

                    if (carIDP.equals(carID)) {
                        carBook = carBook.replace(serviceIDs, serviceIDs + "," + newServiceID);

                    }
                    output += carBook + "\n";
                }
                writer.write(output);
                return true;
            }

        } catch (IOException e) {
            System.out.println("Fajl ne postoji");
        }
        return false;
    }
}