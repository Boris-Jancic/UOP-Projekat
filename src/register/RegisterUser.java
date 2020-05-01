package register;
import java.io.*;
import java.util.*;


public class RegisterUser {

    public enum gender {
        FEMALE,
        MALE
    }

    public enum specialization {
        AUTOMEHANICAR,
        AUTOELEKTRICAR,
        VULKANIZER,
        LIMAR
    }

    public void register(){
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

        System.out.print("\n>>> Adresa : ");
        String address = scanner.nextLine();

        System.out.print("\n>>> Telefon : ");
        String phone = scanner.nextLine();

        System.out.print("\n>>> Korisnicko ime : ");
        String userName = scanner.nextLine();

        System.out.print("\n>>> Lozinka : ");
        String password = scanner.nextLine();

        RegisterUser reg = new RegisterUser();


        if (option == 1) {
            System.out.print("\n>>> Plata : ");
            Double sallary = scanner.nextDouble();
            registerA("3", name, lastName, jmbg, g.toString(), phone, address, userName, password, sallary );
        }

        if (option == 2) {
            System.out.print("\n>>> Plata : ");
            Double sallary = scanner.nextDouble();

            option = 0;
            System.out.println("\n1) Automehanicar");
            System.out.println("2) Auto-elektricar");;
            System.out.println("3) Vulkanizer");;
            System.out.println("4) Limar");

            while(option != 1 && option != 2 && option != 3 && option != 4) {
                System.out.print("\n>>> Specijalizacija : ");
                option = scanner.nextInt();
                if (option != 1 && option != 2 && option != 3 && option != 4) {
                    System.out.println("! Unesite vrednost od 1 do 4 !");
                }
            }

            scanner.nextLine();
            specialization s = null;

            if (option == 1) {
                s = specialization.AUTOMEHANICAR;
            }
            if (option == 2) {
                s = specialization.AUTOELEKTRICAR;
            }
            if (option == 3) {
                s = specialization.VULKANIZER;
            }
            if (option == 4) {
                s = specialization.LIMAR;
            }

            option = 0;

            registerW("2", name, lastName, jmbg, g.toString(), address, phone, userName, password, sallary, s.toString());
        }
        if (option == 3) {
            registerC("1", name, lastName, jmbg, g.toString(), address, phone, userName, password, 0);
        }
    }

    private static void registerC( String position, String name, String lastName, String jmbg, String gender,
                                   String address, String phone, String userName, String password, int points) {
        try {
            Random rand = new Random();
            int id = rand.nextInt(999999);

            String newCredentials = position + "|" + name + "|" + lastName + "|" + jmbg + "|" + gender + "|" + address
                    + "|" + userName + "|" + password + "|" + id + "|" + Integer.parseInt(String.valueOf(points));

            File file = new File("src/data/korisnici.txt");
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

    private static void registerW( String position, String name, String lastName, String jmbg, String gender,String addres, String phone,
                                   String userName, String password, double sallary, String specialization) {


        try {
            Random rand = new Random();
            int id = rand.nextInt(999999);
            String newCredentials = position + "|" + name + "|" + lastName + "|" + jmbg + "|" + gender + "|" + addres + "|" + phone
                    + "|" + userName + "|" + password + "|" + id + "|" + Double.toString(sallary) + "|" + specialization;

            File file = new File("src/data/korisnici.txt");
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


    private static void registerA(String position, String name, String lastName, String jmbg, String gender, String addres,
                                  String phone, String userName, String password, Double sallary) {

        try {
            Random rand = new Random();
            int id = rand.nextInt(999999);

            String newCredentials = position + "|" + name + "|" + lastName + "|" + jmbg + "|" + gender + "|" + addres
                    + "|" + phone + "|" + userName + "|" + password + "|" + id + "|" + Double.toString(sallary);

            File file = new File("src/data/korisnici.txt");
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