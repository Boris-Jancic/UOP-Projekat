package Register;

import carModels.Car;
import userModels.Client;

import java.io.*;

public class RegisterCar {

    public void register() {
        Client c = new Client("Boris", "Jancic", "2508000750014",
                "MALE", "Smederevo", "123 123 1234", "brs", "1234", 0);

        Car a = new Car(c, "BMW", "ONE", "DIZEL", "2000", 2, 30, "keda");


        System.out.println(a.toString());
        register(c, "BMW", "ONE", "DIZEL", "2000", 2, 30, "knjizica");
    }

    private void register(Client client, String mark, String model, String fuel, String age, double engineVolume,
                                int enginePower, String carBook){
        try {
            String output = client.getId() + "|" + mark + "|" + model + "|" + fuel + "|" + age + "|" + engineVolume
                    + "|" + enginePower  + "|" + carBook;

            File file = new File("src/data/cars.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String oldcredentials = new String();
            while((line = reader.readLine()) != null){
                oldcredentials += line + "\n";
            }
            reader.close();
            System.out.println(oldcredentials);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(oldcredentials + output);
            writer.close();


        } catch (IOException e) {
            System.out.println("Nema datog fajla");
        }
    }

}
