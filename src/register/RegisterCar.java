package register;

import carModels.Car;
import userModels.Client;
import utility.Checks;
import utility.PickEnums;
import utility.WriteToFile;

import java.util.Random;
import java.util.Scanner;


public class RegisterCar {

    public Car register() {
        Checks c = new Checks();
        PickEnums p = new PickEnums();
        Scanner scanner = new Scanner(System.in);
        WriteToFile write = new WriteToFile();

        System.out.print("\n>>> ID Musterije : ");
        String clientID = scanner.nextLine();
        Client client = c.findClient(clientID);

        if (client != null) {
            Random r = new Random();
            int rand = r.nextInt(999999);

            String mark = p.pickMark();
            String model = p.pickModel();
            String fuel = p.pickFuel();


            System.out.print(">>> Godiste (Samo godina proizvodnje): ");
            String age = scanner.nextLine();

            System.out.print(">>> Zapremina motora : ");
            String engineVolume = scanner.nextLine();

            System.out.print(">>> Jacina motora : ");
            String enginePower = scanner.nextLine();

            String newCar = clientID + "|" + rand + "|" + mark + "|" + model + "|"
                    + fuel + "|" + age + "|" + engineVolume + "|" + enginePower;

            write.write(newCar, "src/data/cars.txt");
            Car car = new Car(client, Integer.toString(rand), mark, model, fuel, age, Float.parseFloat(engineVolume), Integer.parseInt(enginePower));
            return car;
        }
        System.out.println("\n! Korisnik sa takvim ID-om ne postoji !");
        return null;
    }
}
