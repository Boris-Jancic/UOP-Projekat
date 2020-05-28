package functions;

import carModels.Car;
import carModels.CarBook;
import carModels.Part;
import carModels.Service;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import utility.Checks;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

 public class Delete {

    public static Set<Person> deletePerson(Set<Person> people) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1) Izbrisi admina");
        System.out.println("2) Izbrisi radnika");
        System.out.println("3) Izbrisi musteriju");

        System.out.print("\n>>> Unesi funkciju : ");
        String option = scanner.nextLine();
        System.out.print("\n>>> Unesite ID korisnika kojeg zelite da obrisete : ");
        String deletedPerson = scanner.nextLine();

        for (Person person: people) {
            if (person != null){
                if (option.equals("1") && person instanceof Admin && deletedPerson.equals(person.getId())){
                    people.remove(person);
                    return people;
                }

                if (option.equals("2") && person instanceof Worker && deletedPerson.equals(person.getId())){
                    people.remove(person);
                    return people;
                }

                if (option.equals("3") && person instanceof Client && deletedPerson.equals(person.getId())){
                    people.remove(person);
                    return people;
                }
            }
        }

        System.out.println("\n! Takav korisnik ne postoji ! \n");
        return people;
    }


    public static ArrayList<Car> deleteCar(String carID, ArrayList<Car> cars) {
        Car deletedCar = Checks.findCar(carID, cars);
        cars.remove(deletedCar);
        return cars;
    }

    public static ArrayList<Part> deletePart(ArrayList<Part> parts) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n>>> Unesite ID dela koji zelite da obrisete : ");
        String partID = scanner.nextLine();

        Part deletedPart = Checks.findPart(partID, parts);
        parts.remove(deletedPart);
        return parts;
    }


    public static ArrayList<CarBook> deleteCarBook(String carID, ArrayList<CarBook> carBooks) {
        CarBook deletedCarBook = Checks.findCarBook(carID, carBooks);
        carBooks.remove(deletedCarBook);
        return carBooks;
    }

     public static ArrayList<Service> deleteService(ArrayList<Service> services) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n>>> Unesite ID dela koji zelite da obrisete : ");
        String serviceID = scanner.nextLine();

        Service deletedService = Checks.findService(serviceID, services);
        services.remove(deletedService);
        return services;
     }
}