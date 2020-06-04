package main;

import carModels.Car;
import carModels.CarBook;
import userModels.Client;
import utility.Checks;
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

                Client client = Checks.findClient(clientId);

                String carId = carSplit[1];
                String mark = carSplit[2];
                String model = carSplit[3];
                String fuel = carSplit[4];
                String age = carSplit[5];
                String engineVolume = carSplit[6];
                String enginePower = carSplit[7];
                boolean deleted = Boolean.parseBoolean(carSplit[8]);

                Car car = new Car(client, carId, mark, model, fuel, age,
                        Float.parseFloat(engineVolume), Integer.parseInt(enginePower), deleted);

                CarBook carBook = new CarBook(deleted, car);

                car.setCarBook(carBook);
                cars.add(car);
            }
        }

        return cars;
    }
}