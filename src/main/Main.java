package main;

import carModels.Car;
import carModels.CarBook;
import carModels.Part;
import carModels.Service;
import functions.Delete;
import register.RegisterCar;
import register.RegisterPart;
import register.RegisterService;
import register.RegisterUser;
import userModels.Client;
import userModels.Person;
import utility.WriteToFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import static utility.WriteToFile.writeUsers;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> cars = LoadCars.load();
        Set<Person> people = LoadUsers.load(cars);
        ArrayList<Part> parts = LoadParts.load();
        ArrayList<Service> services = LoadServices.load(cars, people, parts);
        ArrayList<CarBook> carBooks = LoadCarBooks.load(cars, services);

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
            System.out.println("9) Prikazi servisne knjizice");
            System.out.println("10) Brisanje podataka");
            System.out.println("\n0) Ugasi aplikaciju");

            Scanner scanner = new Scanner(System.in);
            System.out.print("\n>>> Unesi funkciju : ");
            option = scanner.nextLine();


            switch (option) {
                case "1":
                    Person registeredPerson = RegisterUser.register();
                    people.add(registeredPerson);
                    break;

                case "2": for(Person person : people) { System.out.println(person); } break;


                case "3":
                    Car registeredCar = RegisterCar.register();

                    if (registeredCar == null)
                        break;

                    cars.add(registeredCar);
                    for (Person person : people) {

                        if (person instanceof Client){

                            if (registeredCar.getClient().getId().equals(person.getId())) {
                                System.out.println(registeredCar);
                                ArrayList<Car> clientCars = ((Client) person).getCars();
                                clientCars.add(registeredCar);
                                ((Client) person).setCars(clientCars);
                            }
                        }
                    }
                    break;


                case "4": for(Car car : cars) { System.out.println(car); } break;


                case "5":
                    Part registeredPart = RegisterPart.register();
                    parts.add(registeredPart);
                    break;


                case "6": for(Part part : parts) { System.out.println(part); } break;


                case "7":
                    Service registerService = RegisterService.register(cars, people, parts);
                    services.add(registerService);
                    break;


                case "8": for(Service service : services) { System.out.println(service); } break;


                case "9": for(CarBook carBook : carBooks) { System.out.println(carBook); } break;


                case "10":
                    System.out.println("\n1) Brisanje korisnika");
                    System.out.println("2) Brisanje automobila (brise njegovu servisnu knjizicu)");
                    System.out.println("3) Brisanje delova");
                    System.out.println("4) Brisanje servisa");

                    System.out.print("\n>>> Unesi funkciju : ");
                    option = scanner.nextLine();

                    if (option.equals("1")) {
                        people = Delete.deletePerson(people);
                    }

                    if (option.equals("2")) {
                        System.out.print("\n>>> Unesite ID automobila koji zelite da obrisete : ");
                        option = scanner.nextLine();

                        cars = Delete.deleteCar(option, cars);
                        carBooks = Delete.deleteCarBook(option, carBooks);
                    }

                    if (option.equals("3")) {
                        parts = Delete.deletePart(parts);
                    }

                    if (option.equals("4")) {
                        services = Delete.deleteService(services);
                    }

                    break;


                case "0":
                    WriteToFile.writeCars(cars);
                    WriteToFile.writeUsers(people);
                    WriteToFile.writeParts(parts);
                    WriteToFile.writeService(services);
                    WriteToFile.writeCarBook(carBooks);
                    return;
            }
        }
    }
}