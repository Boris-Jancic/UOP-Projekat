package functions;

import carModels.Car;
import carModels.CarBook;
import carModels.Part;
import carModels.Service;
import org.jetbrains.annotations.NotNull;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import utility.Checks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Delete {

    public static Set<Person> deletePerson(String option, String deletedPerson, Set<Person> people) {
        Boolean found = false;
        for (Person person: people) {
            if (person != null){
                if (option.equals("1") && person instanceof Admin && deletedPerson.equals(person.getId())){
                    person.setDeleted(true);
                    found = true;
                }

                if (option.equals("2") && person instanceof Worker && deletedPerson.equals(person.getId())){
                    person.setDeleted(true);
                    found = true;
                }

                if (option.equals("3") && person instanceof Client && deletedPerson.equals(person.getId())){
                    person.setDeleted(true);
                    found = true;
                }
            }
        }

        if (found == false) {
            System.out.println("\n! Takav korisnik ne postoji ! \n");
        }

        return people;
    }


    public static ArrayList<Car> deleteCar(String carID, ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getCarID().equals(carID)) {
                car.setDeleted(true);
            }
        }
        return cars;
    }

    public static ArrayList<Car> deleteCars(String clientID, ArrayList<Car> cars){
        for (Car car : cars) {
            if (car.getClient().getId().equals(clientID)) {
                car.setDeleted(true);
            }
        }
        return cars;
    }


    public static ArrayList<Part> deletePart(ArrayList<Part> parts) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n>>> Unesite ID dela koji zelite da obrisete : ");
        String partID = scanner.nextLine();

        for (Part part : parts) {
            if (part.getId().equals(partID)){
                part.setAvailable(false);
            }
        }

        return parts;
    }


     public static ArrayList<Service> deleteService(ArrayList<Service> services) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n>>> Unesite ID servisa koji zelite da obrisete : ");
        String serviceID = scanner.nextLine();

        for (Service service : services) {
            if (service.getId().equals(serviceID)) {
                service.setDeleted(true);
            }
        }

        return services;
     }

    public static ArrayList<Service> deleteServices(String workerID, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getWorker().getId().equals(workerID)) {
                service.setDeleted(true);
            }
        }
        return services;
    }


//    public static ArrayList<CarBook> deleteCarBook(String carID, ArrayList<CarBook> carBooks) {
//        for (CarBook carBook : carBooks) {
//            if (carBook.getCar().getCarID().equals(carID)){
//                carBook.setDeleted(true);
//            }
//        }
//        return carBooks;
//    }

    public static ArrayList<CarBook> deleteCarBook(ArrayList<Car> cars, ArrayList<CarBook> carBooks) {
        for (CarBook carBook : carBooks) {
            for (Car car : cars) {
                if (carBook.getCar().getCarID().equals(car.getCarID()) && car.isDeleted() == true) {
                    carBook.setDeleted(true);
                }
            }
        }
        return carBooks;
    }


    public static ArrayList<CarBook> deleteCarBookServices(ArrayList<Service> services, ArrayList<CarBook> carBooks) {
        ArrayList<Service> nonDeletedServices = new ArrayList<>();
        ArrayList<CarBook> returnCarBooks = new ArrayList<>();

        for (Service service : services) {  // Dodaju se svi servisi koji nisu obrisani
            if (service.isDeleted() == false) {
                nonDeletedServices.add(service);
            }
        }

        for (CarBook carBook : carBooks) {
            CarBook newCarBook = new CarBook(false, carBook.getCar());
            ArrayList<Service> newServices = new ArrayList<>();

            for (Service service : nonDeletedServices) {  // Lista knjizica sa azuriranim servisima
                if (carBook.getCar().getCarID().equals(service.getCar().getCarID())) {
                    newServices.add(service);
                }
            }

            newCarBook.setServices(newServices);
            returnCarBooks.add(newCarBook);
        }

        return returnCarBooks;
    }
}