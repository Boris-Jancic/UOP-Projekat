package register;

import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import utility.PickEnums;
import java.util.Random;
import java.util.Scanner;


public class RegisterUser {
    public static Person register() {
        Scanner scanner = new Scanner(System.in);
        String option = "";

        while (!option.matches("[1-3]")) {
            System.out.println("\nKog korisnika zelite da dodate?");
            System.out.println("1) Administrator");
            System.out.println("2) Serviser");
            System.out.println("3) Musterija");
            System.out.print("\n>>> Izaberi funkciju : ");
            option = scanner.nextLine();
        }

        System.out.print("\n>>> Ime : ");
        String name = scanner.nextLine();

        System.out.print("\n>>> Prezime : ");
        String lastName = scanner.nextLine();

        System.out.print("\n>>> JMBG : ");
        String jmbg = scanner.nextLine();

        if (jmbg.length() != 13) {
            System.out.println("!!! JMBG mora da ima 13 karaktera !!!");
            return null;
        }

        String gender = PickEnums.pickGender();

        System.out.print("\n>>> Adresa : ");
        String address = scanner.nextLine();

        System.out.print("\n>>> Telefon : ");
        String phone = scanner.nextLine();

        System.out.print("\n>>> Korisnicko ime : ");
        String userName = scanner.nextLine();

        System.out.print("\n>>> Lozinka : ");
        String password = scanner.nextLine();

        Random rand = new Random();
        int id = rand.nextInt(999999);

        if (option.equals("1")) {
            System.out.print("\n>>> Plata : ");
            double sallary = scanner.nextDouble();

            return new Admin(name,lastName,jmbg,gender,address,phone,userName,password, sallary, Integer.toString(id), false);
        }
        if (option.equals("2")) {
            System.out.print("\n>>> Plata : ");
            double salary = scanner.nextDouble();
            String specialization = PickEnums.pickSpecialization();

            return new Worker(name,lastName,jmbg,gender,address,phone,userName,password,Integer.toString(id), salary, specialization, false);
        }
        if (option.equals("3")) {
            return new Client(name, lastName, jmbg, gender, address, phone, userName, password, Integer.toString(id), 0, false);
        }
        return null;
    }
}