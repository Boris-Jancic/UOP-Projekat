package main;
import Register.RegisterCar;
import Register.RegisterUser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        RegisterUser rU = new RegisterUser();
        LoadUsers lU = new LoadUsers();
        RegisterCar rC = new RegisterCar();
        LoadCars lC = new LoadCars();

        String option = "";
        while (option != "0") {
            System.out.println("\n1) Registruj korisnika");
            System.out.println("2) Ucitaj korisnike");
            System.out.println("3) Registruj automobil");
            System.out.println("4) Ucitaj automobile");
            System.out.println("0) Ugasi aplikaciju");

            Scanner scanner = new Scanner(System.in);
            System.out.print(">>> Unesi funkciju : ");
            option = scanner.nextLine();

            if (option.equals("1")) {
                rU.register();
            }
            if (option.equals("2")) {
                lU.load();
            }
            if (option.equals("3")) {
                rC.register();
            }
            if (option.equals("4")) {
                lC.load();
            }
            if (option.equals("0")) {
                break;
            }
        }
    }
}
