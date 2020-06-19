package utility;

import carModels.Car;
import carModels.CarBook;
import carModels.Part;
import carModels.Service;
import enums.Gender;
import main.Access;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;

public class Checks {

    public static Person Login(Set<Person> people, String username, String password) {
        for (Person person : people) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password) && !person.isDeleted()) {
                return person;
            }
        }
        return null;
    }


    public static Worker findWorker(String id, Set<Person> people) {
        for (Person person : people) {
            if (person instanceof Worker && person.getId().equals(id)) {
                return (Worker) person;
            }
        }
        return null;
    }


    public static Car findCar(String carID, ArrayList<Car> cars) {
        for (Car car : cars) {
            if (carID.equals(car.getCarID()) && !car.isDeleted()) {
                return car;
            }
        }
        return null;
    }

    public static ArrayList<Car> findCars(ArrayList<Car> Cars, String id) {
        ArrayList<Car> carsReturn = new ArrayList<>();

        for (Car car : Cars) {
            Client client = car.getClient();
            if (client.getId().equals(id) && !car.isDeleted()) {
                carsReturn.add(car);
            }
        }
        return carsReturn;
    }

    public static ArrayList<Part> findParts(String[] PartIDs, ArrayList<Part> parts) {
        ArrayList<Part> returnParts = new ArrayList<>();

        for (Part part : parts) {
            for (String partID : PartIDs) {
                if (partID.equals(part.getId()) && !part.isDeleted()) {
                    returnParts.add(part);
                }
            }
        }

        return returnParts;
    }

    public static Service findService(String serviceID, ArrayList<Service> services) {

        for (Service service : services) {
            if (service != null && serviceID.equals(service.getId()))
                return service;
        }
        return null;
    }

    public static GregorianCalendar stringToDate(String dateP) {
        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            date.setTime(format.parse(dateP));
        } catch (ParseException e) {
            System.out.println("!!! Pogresan unos datuma !!!");
            return null;
        }

        return date;
    }

    public static String dateToString(GregorianCalendar dateP) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(dateP.getTime());
    }
}