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
import java.util.GregorianCalendar;

public class Checks {

    public ArrayList<Car> findCars(ArrayList<Car> Cars, String id) {
        ArrayList<Car> carsReturn = new ArrayList<Car>();

        for (Car car : Cars) {
            if (car.getClient().getId().equals(id)) {
                carsReturn.add(car);
            }
        }
        return carsReturn;
    }


    public Car findCar(ArrayList<Car> Cars, String carID) {
        Car returnCar = null;
        for (Car car : Cars) {
            if (car.getCarID().equals(carID)) {
                returnCar = car;
            }
        }
        return returnCar;
    }

    public Boolean ifCarExists(String id) {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] cars = readFromFile.read("src/data/cars.txt").split("\n");

        for (String car : cars) {
            String[] userSplit = car.split("\\|");
            String carID = userSplit[1];

            if (carID.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Worker findWorker(String id) {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] users = readFromFile.read("src/data/korisnici.txt").split("\n");

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
                        username, password, specialization, sallary);
                w.setId(userID);
                return w;
            }
        }
        return null;
    }

    public Client findClient(String id) {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] users = readFromFile.read("src/data/korisnici.txt").split("\n");

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

            if (role.equals("1") && userID.equals(id)) {
                String points = userSplit[10];

                return new Client(name, lastName, jmbg, gender, address, phone,
                        username, password, Integer.parseInt(points), userID);
            }
        }
        return null;
    }

    public Boolean ifUsersExists(String id, String roleP) {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] users = readFromFile.read("src/data/korisnici.txt").split("\n");

        for (String user : users) {
            String[] userSplit = user.split("\\|");
            String role = userSplit[0];
            String userID = userSplit[9];

            if (role.equals(roleP) && userID.equals(id)) {
                return true;
            }
        }

        return false;
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

    public String dateToString(GregorianCalendar dateP) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(dateP.getTime());
    }


    public Boolean writeCarBook(String carIDP, String newServiceID) {
        ReadFromFile readFromFile = new ReadFromFile();

        String[] carBooks = readFromFile.read("src/data/carbooks.txt").split("\n");
        String output = "";
        Boolean b = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/carbooks.txt"))) {
            for (String carBook : carBooks) {
                String[] carBookSplit = carBook.split("\\|");
                System.out.println(carBookSplit);
                String carID = carBookSplit[0];
                String serviceIDs = carBookSplit[1];

                if (carIDP.equals(carID)) {
                    carBook = carBook.replace(serviceIDs, serviceIDs + "," + newServiceID);
                    b = true;
                }
                output += carBook + "\n";
            }
            writer.write(output);
            return b;
        } catch (IOException e) {
            System.out.println("Fajl ne postoji");
        }
        return false;
    }
}