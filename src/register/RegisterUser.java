package register;

import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import utility.PickEnums;
import utility.WriteToFile;

import java.util.Random;
import java.util.Scanner;


public class RegisterUser {
    public static Person register() {
        Scanner scanner = new Scanner(System.in);
        PickEnums pickEnums = new PickEnums();
        WriteToFile writeToFile = new WriteToFile();
        String option = "";

        while (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
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

        String gender = pickEnums.pickGender();

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
            Double sallary = scanner.nextDouble();

            Admin admin = new Admin(name,lastName,jmbg,gender,address,phone,userName,password, sallary, Integer.toString(id));
            return admin;
        }
        if (option.equals("2")) {
            System.out.print("\n>>> Plata : ");
            double salary = scanner.nextDouble();
            String specialization = pickEnums.pickSpecialization();

            Worker worker = new Worker(name,lastName,jmbg,gender,address,phone,userName,password,Integer.toString(id), salary, specialization);
            return  worker;
        }
        if (option.equals("3")) {
            Client client = new Client(name, lastName, jmbg, gender, address, phone, userName, password, 0, Integer.toString(id));
            return client;
        }
        return null;
    }
}