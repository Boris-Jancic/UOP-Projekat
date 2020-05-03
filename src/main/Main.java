package main;
import register.RegisterCar;
import register.RegisterPart;
import register.RegisterService;
import register.RegisterUser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        RegisterUser rU = new RegisterUser();
        LoadUsers lU = new LoadUsers();
        RegisterCar rC = new RegisterCar();
        LoadCars lC = new LoadCars();
        RegisterPart rP = new RegisterPart();
        LoadParts lP = new LoadParts();
        RegisterService rS = new RegisterService();
        LoadServices lS = new LoadServices();

        while (true) {
            String option = "";
            System.out.println("\n1) Registruj korisnika");
            System.out.println("2) Ucitaj korisnike");
            System.out.println("3) Registruj automobil");
            System.out.println("4) Ucitaj automobile");
            System.out.println("5) Registruj deo");
            System.out.println("6) Ucitaj delove");
            System.out.println("7) Registruj servis");
            System.out.println("8) Ucitaj servise");
            System.out.println("0) Ugasi aplikaciju");

            Scanner scanner = new Scanner(System.in);
            System.out.print("\n>>> Unesi funkciju : ");
            option = scanner.nextLine();
            // TODO: switch

            switch (option) {
                case "1": rU.register();break;
                case "2": lU.load();break;
                case "3": rC.register();break;
                case "4": lC.load();break;
                case "5": rP.register();break;
                case "6": lP.load();break;
                case "7": rS.register();break;
                case "8": lS.load();break;
                case "0": break;
            }
        }
    }
}
