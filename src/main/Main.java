package main;
import Register.RegisterCar;
import Register.RegisterUser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        RegisterUser rU = new RegisterUser();
        LoadUsers lU = new LoadUsers();
        RegisterCar rC= new RegisterCar();
        LoadCars lC = new LoadCars();

        System.out.println("1) Registruj korisnika");
        System.out.println("2) Ucitaj korisnike");
        System.out.println("3) Registruj automobil");
        System.out.println("4) Ucitaj automobile");

        Scanner scanner = new Scanner(System.in);
        System.out.print(">>> Unesi funkciju : ");
        int option = scanner.nextInt();

        if (option == 1){
            rU.register();
        }
        if (option == 2){
            lU.load();
        }
        if (option == 3){
            rC.register();
        }
        if (option == 4){
            lC.load();
        }


    }

}
