package main;

import carModels.Car;
import carModels.CarBook;
import carModels.Service;
import enums.Fuel;
import enums.Mark;
import enums.Model;
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

    public static ArrayList<Car> setCarBooks(ArrayList<Car> cars, ArrayList<CarBook> carBooks) {
        for (Car car : cars) {
            for (CarBook carBook : carBooks) {
                for (Service service : carBook.getServices())
                if (car.getCarID().equals(carBook.getCar().getCarID())) {
                    car.setCarBook(carBook);
                }
            }
        }
        return cars;
    }
}