package register;

import utility.Checks;
import utility.PickEnums;
import utility.WriteToFile;

import java.util.Random;
import java.util.Scanner;


public class RegisterCar {

    public void register() {
        Checks c = new Checks();
        PickEnums p = new PickEnums();
        Scanner scanner = new Scanner(System.in);
        WriteToFile write = new WriteToFile();

        System.out.print("\n>>> ID Musterije : ");
        String clientID = scanner.nextLine();

        if(!c.ifUsersExists(clientID)) {
            System.out.println("\n! Korisnik sa takvim ID-om ne postoji !\n");
            return;
        }

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

        String newCar = clientID + "|" + rand + "|" +  mark + "|" + model + "|"
                + fuel  + "|" + age + "|" + engineVolume + "|" + enginePower + "CARBOOK"; // TODO carbook implement

        write.write(newCar, "src/data/cars.txt");
    }
}
