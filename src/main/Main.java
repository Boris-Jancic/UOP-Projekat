package main;

import carModels.Car;
import carModels.CarBook;
import carModels.Part;
import carModels.Service;
import register.RegisterCar;
import register.RegisterPart;
import register.RegisterService;
import register.RegisterUser;
import userModels.Person;

import java.io.IOException;
import java.util.ArrayList;
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
        LoadCarBooks lB = new LoadCarBooks();

        ArrayList<Car> Cars = lC.load();
        ArrayList<Person> People = lU.load(Cars);
        ArrayList<Part> Parts = lP.load();
        ArrayList<Service> Services = lS.load(Cars);
        ArrayList<CarBook> CarBooks = lB.load(Services);

        while (true) {
            String option;
            System.out.println("\n1) Registruj korisnika");
            System.out.println("2) Prikazi korisnike");
            System.out.println("3) Registruj automobil");
            System.out.println("4) Prikazi automobile");
            System.out.println("5) Registruj deo");
            System.out.println("6) Prikazi delove");
            System.out.println("7) Registruj servis");
            System.out.println("8) Prikazi servise");
            System.out.println("9) Prikazi knjizice");
            System.out.println("0) Ugasi aplikaciju");

            Scanner scanner = new Scanner(System.in);
            System.out.print("\n>>> Unesi funkciju : ");
            option = scanner.nextLine();


            switch (option) {
                case "1": rU.register();break;
                case "2": for(Person person : People) { System.out.println(person); } break;
                case "3": rC.register();break;
                case "4": for(Car car : Cars) { System.out.println(car); } break;
                case "5": rP.register();break;
                case "6": for(Part part : Parts) { System.out.println(part); } break;
                case "7": rS.register();break;
                case "8": for(Service service : Services) { System.out.println(service); }break;
                case "9": for(CarBook carBook : CarBooks) { System.out.println(carBook); }break;
                case "0": return;
            }
        }
    }
}
