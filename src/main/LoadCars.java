package main;

import carModels.Car;
import carModels.CarBook;
import enums.Fuel;
import enums.Gender;
import enums.Mark;
import enums.Model;
import userModels.Client;
import utility.ReadFromFile;
import java.util.ArrayList;

public class LoadCars {

    public static ArrayList<Car> load() {
        String[] carsStr = ReadFromFile.read("src/data/cars.txt").split("\n");
        ArrayList<Car> cars = new ArrayList<>();

        for (String carStr : carsStr) {
            if (!carStr.isEmpty()) {
                String[] carSplit = carStr.split("\\|");
                String clientId = carSplit[0];

                Client client = findClient(clientId);

                String carId = carSplit[1];
                Mark markCar = Mark.valueOf(carSplit[2]);
                Model modelCar = Model.valueOf(carSplit[3]);
                Fuel fuelCar = Fuel.valueOf(carSplit[4]);
                String age = carSplit[5];
                String engineVolume = carSplit[6];
                String enginePower = carSplit[7];
                boolean deleted = Boolean.parseBoolean(carSplit[8]);

                Car car = new Car(client, carId, markCar, modelCar, fuelCar, age,
                        Float.parseFloat(engineVolume), Integer.parseInt(enginePower), deleted);

                cars.add(car);
            }
        }

        return cars;
    }
    private static Client findClient(String id) {
        String[] users = ReadFromFile.read("src/data/korisnici.txt").split("\n");

        for (String user : users) {
            if (!users.equals("")) {
                String[] userSplit = user.split("\\|");
                String role = userSplit[0];
                String name = userSplit[1];
                String lastName = userSplit[2];
                String jmbg = userSplit[3];
                Gender gender = Gender.valueOf(userSplit[4]);
                String address = userSplit[5];
                String phone = userSplit[6];
                String username = userSplit[7];
                String password = userSplit[8];
                String userID = userSplit[9];

                if (role.equals("3") && userID.equals(id)) {
                    String points = userSplit[10];
                    boolean deleted = Boolean.parseBoolean(userSplit[11]);

                    return new Client(name, lastName, jmbg, gender, address, phone,
                            username, password, userID, Integer.parseInt(points), deleted);
                }
            }
        }
        return null;
    }

    public static ArrayList<Car> setCarBooks(ArrayList<Car> cars, ArrayList<CarBook> carBooks) {
        for (Car car : cars) {
            for (CarBook carBook : carBooks) {
                if (car.getCarID().equals(carBook.getCar().getCarID())) {
                    car.setCarBook(carBook);
                }
            }
        }
        return cars;
    }
}
