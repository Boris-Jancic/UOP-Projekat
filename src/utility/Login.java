package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        login();
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n>>> Korisnicko ime : ");
        String username = scanner.nextLine();

        System.out.println("\n>>> Lozinka : ");
        String password = scanner.nextLine();

        if (login(username, password)) {
            System.out.println("Ulogovani");
            return;
        }

        System.out.println("Pogresno korisnicko ime ili sifra");
    }

    public static boolean login(String username, String password) {

        try {
            File file = new File("src/login/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String user;
            String pass;

            do {
                String line;
                if ((line = reader.readLine()) == null) {
                    reader.close();
                    return false;
                }

                String[] lineSplit = line.split("\\|");
                user = lineSplit[7];
                pass = lineSplit[8];
            } while (!user.equals(username) || !pass.equals(password));

            return true;
        } catch (IOException e) {
            System.out.println("Nema datog fajla");
            return false;
        }
    }
}