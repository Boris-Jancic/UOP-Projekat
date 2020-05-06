package utility;

import carModels.Car;
import userModels.Client;
import userModels.Worker;

import java.util.ArrayList;

public class Checks {

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


    public Boolean ifCarExists(String id) {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] cars = readFromFile.read("src/data/cars.txt").split("\n");

        for (String car : cars){
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

        for (String user : users){
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
                return w;
            }
        }
        return null;
    }

    public Client findClient(String id) {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] users = readFromFile.read("src/data/korisnici.txt").split("\n");

        for (String user : users){
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
                Client c = new Client(name, lastName, jmbg, gender, address, phone,
                        username, password, Integer.parseInt(points), userID);
                return c;
            }
        }
        return null;
    }

    public ArrayList<Car> findCars(ArrayList<Car> Cars, String id){
        ArrayList<Car> carsReturn = new ArrayList<Car>();

        for (Car car : Cars){
            if (car.getClient().getId().equals(id)){
                carsReturn.add(car);
            }
        }

        return carsReturn;
    }
}