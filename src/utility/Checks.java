package utility;

import carModels.Car;
import userModels.Client;

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

    public Client findClient(String id) {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] users = readFromFile.read("src/data/korisnici.txt").split("\n");

        for (String user : users){
            String[] userSplit = user.split("\\|");
            String role = userSplit[0];
            String userID = userSplit[9];

            if (role.equals("1") && userID.equals(id)) {
                String name = userSplit[1];
                String lastName = userSplit[2];
                String jmbg = userSplit[3];
                String gender = userSplit[4];
                String address = userSplit[5];
                String phone = userSplit[6];
                String username = userSplit[7];
                String password = userSplit[8];
                String points = userSplit[10];

                Client c = new Client(name, lastName, jmbg, gender, address, phone,
                        username, password, Integer.parseInt(points), userID);

                String[] cars = userSplit[11].split(",");

                for(String carId : cars){
                    c.addCar(findCar(carId));
                }

                return c;
            }
        }
        return null;
    }

    public Car findCar(String id) throws StackOverflowError {
        ReadFromFile readFromFile = new ReadFromFile();
        String[] cars = readFromFile.read("src/data/cars.txt").split("\n");

        for (String car : cars){
            String[] carSplit = car.split("\\|");
            String carId = carSplit[1];

            if(carId.equals(id)){
                String clientId = carSplit[0];
                Client c = findClient(clientId);

                String mark = carSplit[2];
                String model = carSplit[3];
                String fuel = carSplit[4];
                String age = carSplit[5];
                String engineVolume = carSplit[6];
                String enginePower = carSplit[7];

                Car Car = new Car(c, mark, model, fuel, age,
                        Float.parseFloat(engineVolume), Integer.parseInt(enginePower));

                return Car;
            }
        }
        return null;
    }
}
