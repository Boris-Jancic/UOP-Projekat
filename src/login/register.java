package login;

import java.io.*;
import java.util.*;


class Register {

    public enum gender {
        FEMALE,
        MALE
    }

    public static void main(String[] args) {
        register();
    }

    private static void register(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        System.out.println("Kog korisnika zelite da dodate?");
        System.out.println("1) Administrator");
        System.out.println("2) Serviser");
        System.out.println("3) Musterija");


        while(option != 1 && option != 2 && option != 3) {
            System.out.print("\n>>> Izaberi funkciju : ");
            option = scanner.nextInt();
            if (option != 1 && option != 2 && option != 3)
                System.out.println("! Unesite vrednost od 1 do 3 !");
        }
        scanner.nextLine();


        System.out.print("\n>>> Ime : ");
        String name = scanner.nextLine();

        System.out.print("\n>>> Prezime : ");
        String lastName = scanner.nextLine();

        System.out.print("\n>>> JMBG : ");
        String jmbg = scanner.nextLine();

        int option2 = 0;
        System.out.println("\n1) Muski");
        System.out.println("2) Zenski");
        System.out.print(">>> Pol : ");
        option2 = scanner.nextInt();
        scanner.nextLine();
        gender g = null;
        if (option2 == 1)
            g = gender.MALE;
        if (option2 == 2)
            g = gender.FEMALE;


        System.out.print("\n>>> Telefon : ");
        String phone = scanner.nextLine();

        System.out.print("\n>>> Korisnicko ime : ");
        String userName = scanner.nextLine();

        System.out.print("\n>>> Lozinka : ");
        String password = scanner.nextLine();

        Register reg = new Register();

        if (option == 1)
            registerCustomer(name, lastName, jmbg, g.toString(), phone,userName, password, "1");
        if (option == 2)
            registerCustomer(name, lastName, jmbg, g.toString(),phone,userName, password, "2");
        if (option == 3)
            registerCustomer(name, lastName, jmbg, g.toString(),phone,userName, password, "3");

    }

    private static void registerCustomer(String name, String lastName, String jmbg, String gender,String addres,
                                 String userName, String password, String position) {

        Random rand = new Random();
        int id = rand.nextInt(999999);

        String newCredentials;
        try {
            newCredentials = name + "|" + lastName + "|" + jmbg + "|" + gender + "|" + addres
                    + "|" + userName + "|" + password + "|" + id + "|" + position;

            File file = new File("src/login/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String oldCredenitals =  new String();


            while((line = reader.readLine()) != null){
                oldCredenitals += line + "\n";
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(oldCredenitals + newCredentials);
            writer.close();

        } catch (IOException e) {
            System.out.println("Nema datog fajla");
        }
    }
}