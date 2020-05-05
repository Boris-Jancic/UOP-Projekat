package main;

import carModels.Car;
import carModels.CarBook;
import userModels.Client;
import utility.Checks;
import utility.ReadFromFile;

public class LoadCars {

    public void load(){
        Checks c = new Checks();
        ReadFromFile readFromFile = new ReadFromFile();
        String[] cars = readFromFile.read("src/data/cars.txt").split("\n");

        for(String car : cars){
            String[] carSplit = car.split("\\|");
            String clientId = carSplit[0];
            Client client = c.findClient(clientId);

            String carId = carSplit[1];
            String mark = carSplit[2];
            String model = carSplit[3];
            String fuel = carSplit[4];
            String age = carSplit[5];
            String engineVolume = carSplit[6];
            String enginePower = carSplit[7];

            Car Car = new Car(client, carId, mark, model, fuel, age,
                    Float.parseFloat(engineVolume),Integer.parseInt(enginePower));

            CarBook carBook = new CarBook(Car);

            Car.setCarBook(carBook);

            System.out.println(Car.toString());
        }
    }
}