package main;

import carModels.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadCars {

    public void load(){
        try {
            File carFile = new File("src/data/cars.txt");
            BufferedReader carReader = new BufferedReader(new FileReader(carFile));

            String carLine;
            while((carLine = carReader.readLine()) != null){
                String[] carSplit = carLine.split("\\|");
                String clientId = carSplit[0];
                String carId = carSplit[1];
                String mark = carSplit[2];
                String model = carSplit[3];
                String fuel = carSplit[4];
                String age = carSplit[5];
                String engineVolume = carSplit[6];
                String enginePower = carSplit[7];
                String carBookId = carSplit[8];

                Car car = new Car(clientId, mark, model, fuel, age,
                        Float.parseFloat(engineVolume),Integer.parseInt(enginePower),carBookId);
                car.setCarID(carId);

                System.out.println(car.toString());
            }
        } catch (IOException e) {
            System.out.println("Dati fajl nije pronadjen");
        }
    }
}