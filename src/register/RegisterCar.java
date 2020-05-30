package register;

import carModels.Car;
import userModels.Client;
import utility.Checks;
import utility.PickEnums;
import utility.WriteToFile;

import java.util.Random;
import java.util.Scanner;


public class RegisterCar {

    public static Car register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n>>> ID Musterije : ");
        String clientID = scanner.nextLine();
        Client client = Checks.findClient(clientID);

        if (client != null) {
            Random r = new Random();
            int rand = r.nextInt(999999);

            String mark = PickEnums.pickMark();
            String model = PickEnums.pickModel();
            String fuel = PickEnums.pickFuel();


            System.out.print(">>> Godiste (Samo godina proizvodnje): ");
            String age = scanner.nextLine();

            System.out.print(">>> Zapremina motora : ");
            String engineVolume = scanner.nextLine();

            System.out.print(">>> Jacina motora : ");
            String enginePower = scanner.nextLine();

            Car car = new Car(client, Integer.toString(rand), mark, model, fuel, age, Float.parseFloat(engineVolume), Integer.parseInt(enginePower));
            return car;
        }
        System.out.println("\n! Korisnik sa takvim ID-om ne postoji !");
        return null;
    }
}
