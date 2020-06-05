package utility;

import carModels.Car;
import carModels.CarBook;
import carModels.Part;
import carModels.Service;
import userModels.Client;
import userModels.Person;
import userModels.Worker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;

public class Checks {

    public static Worker findWorker(String id, Set<Person> people) {
        for (Person person : people) {
            if (person instanceof Worker && person.getId().equals(id)){
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


    public static Part findPart(String partID, ArrayList<Part> parts) {

        for (Part part : parts){
            if (partID.equals(part.getId()) && !part.isDeleted()){
                return part;
            }
        }
        return null;
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


    public static CarBook findCarBook(String carID, ArrayList<CarBook> carBooks) {

        for (CarBook carBook : carBooks) {
            if (carBook != null && carID.equals(carBook.getCar().getCarID())) {
                return carBook;
            }
        }
        return null;
    }


    public static Client findClient(String id) {
        String[] users = ReadFromFile.read("src/data/korisnici.txt").split("\n");

        for (String user : users) {
            if (!users.equals("")) {
                String[] userSplit = user.split("\\|");
                String role = userSplit[0];
                String name = userSplit[1];
                String lastName = userSplit[2];
                String jmbg = userSplit[3];
                String gender = userSplit[4];
                String address = userSplit[5];
                String phone = userSplit[6];
                String username = userSplit[7];
                String password = userSplit[8];
                String userID = userSplit[9];

                if (role.equals("3") && userID.equals(id)) {
                    String points = userSplit[10];
                    boolean deleted = Boolean.parseBoolean(userSplit[11]);

                    return new Client(name, lastName, jmbg, gender, address, phone,
                            username, password, userID, Integer.parseInt(points), deleted);
                }
            }
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