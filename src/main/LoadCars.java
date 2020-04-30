package main;

import carModels.Car;
import userModels.Client;

import java.io.*;

public class LoadCars {

    public void load(){
        try {
            File carFile = new File("src/data/cars.txt");
            File userFile = new File("src/data/korisnici.txt");
            BufferedReader carReader = new BufferedReader(new FileReader(carFile));
            BufferedReader userReader = new BufferedReader(new FileReader(userFile));
            String userLine;

            while((userLine = userReader.readLine()) != null) {
                String[] userSplit = userLine.split("\\|");
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

                if (role.equals("1")){
                    int points = Integer.parseInt(userSplit[10]);
                    Client c = new Client(name, lastName, jmbg, gender, address, phone, username, password, points);

                    String carLine;
                    while((carLine = carReader.readLine()) != null){
                        String[] carSplit = carLine.split("\\|");
                        String carId = carSplit[0];
                        String mark = carSplit[1];
                        String model = carSplit[2];
                        String fuel = carSplit[3];
                        String age = carSplit[4];
                        String engineVolume = carSplit[5];
                        String enginePower = carSplit[6];
                        String carBookId = carSplit[7];

                        Car car = new Car(c,mark,model,fuel,age,Float.parseFloat(engineVolume)
                                ,Integer.parseInt(enginePower),carBookId);

                        if (id.equals(carId))
                            System.out.println(car.toString());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Dati fajl nije pronadjen");
        }
    }
}