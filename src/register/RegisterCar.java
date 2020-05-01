package register;

import utility.Checks;
import utility.PickEnums;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class RegisterCar {

    public void register() {
        try {
            Checks c = new Checks();
            PickEnums p = new PickEnums();
            Scanner scanner = new Scanner(System.in);
            File file = new File("src/data/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String mark = p.pickMark();
            String model = p.pickModel();
            String fuel = p.pickFuel();

            System.out.println(">>> ID Musterije : ");
            String clientID = scanner.nextLine();

            if(!c.ifUsersExists(clientID)) {
                System.out.println("\n! Korisnik sa takvim ID-om ne postoji !\n");
                return;
            }

            System.out.print(">>> Godiste (Samo godina proizvodnje): ");
            String age = scanner.nextLine();

            System.out.print(">>> Zapremina motora : ");
            String engineVolume = scanner.nextLine();

            System.out.print(">>> Jacina motora : ");
            String enginePower = scanner.nextLine();

            register(clientID, mark, model, fuel, age, Double.parseDouble(engineVolume),
                    Integer.parseInt(enginePower), "333333");


        } catch (IOException e) {
            System.out.println("Nema datog fajla !");
        }
    }

    private void register(String clientID, String mark, String model, String fuel, String age, double engineVolume,
                                int enginePower, String carBook){
        try {

            Random r = new Random();
            int rand = r.nextInt(999999);
            String output = clientID + "|" + Integer.toString(rand) + "|" + mark + "|" + model + "|" + fuel + "|" + age + "|" + engineVolume
                    + "|" + enginePower  + "|" + carBook;

            File file = new File("src/data/cars.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String oldcredentials = new String();
            while((line = reader.readLine()) != null){
                oldcredentials += line + "\n";
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(oldcredentials + output);
            writer.close();


        } catch (IOException e) {
            System.out.println("Nema datog fajla");
        }
    }

}
