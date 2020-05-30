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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

 public class Delete {

    public static Person deletePerson(String option, String deletedPerson, Set<Person> people) {
        for (Person person: people) {
            if (person != null){
                if (option.equals("1") && person instanceof Admin && deletedPerson.equals(person.getId())){
                    return person;
                }

                if (option.equals("2") && person instanceof Worker && deletedPerson.equals(person.getId())){
                    return person;
                }

                if (option.equals("3") && person instanceof Client && deletedPerson.equals(person.getId())){
                    return person;
                }
            }
        }

        System.out.println("\n! Takav korisnik ne postoji ! \n");
        return null;
    }


    public static Car deleteCar(String carID, ArrayList<Car> cars) {
        return Checks.findCar(carID, cars);
    }

    public static ArrayList<Car> deleteCars(ArrayList<Car> clientCars, ArrayList<Car> cars){
        Iterator carsIterator = cars.iterator();

        while (carsIterator.hasNext()) {
            Car iteratorCar = (Car) carsIterator.next();

            for (Car clientCar : clientCars) {
                if (iteratorCar.getCarID().equals(clientCar.getCarID())) {
                    carsIterator.remove();
                }
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


     public static Service deleteService(ArrayList<Service> services) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n>>> Unesite ID dela koji zelite da obrisete : ");
        String serviceID = scanner.nextLine();

        Service deletedService = Checks.findService(serviceID, services);
        return deletedService;
     }

     public static ArrayList<Service> deleteServices(String workerID, ArrayList<Service> services) {
        Iterator serviceIterator = services.iterator();

        while (serviceIterator.hasNext()) {
            Service service = (Service) serviceIterator.next();
            if (workerID.equals(service.getWorker().getId())) {
                serviceIterator.remove();
            }
        }

        return services;
     }


     public static ArrayList<CarBook> deleteCarBook(String carID, ArrayList<CarBook> carBooks) {
         CarBook deletedCarBook = Checks.findCarBook(carID, carBooks);
         carBooks.remove(deletedCarBook);
         return carBooks;
     }


     public static ArrayList<CarBook> deleteCarBookServices(Service service, ArrayList<CarBook> carBooks) {
        for (CarBook carBook : carBooks) {
            if (carBook.getServices().contains(service)){
                carBook.removeService(service);
            }
        }

        return carBooks;
     }
 }