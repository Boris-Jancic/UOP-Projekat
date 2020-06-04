package main;

import carModels.Car;
import carModels.CarBook;
import carModels.Service;
import utility.Checks;
import utility.ReadFromFile;

import java.util.ArrayList;

public class LoadCarBooks {
    public static ArrayList<CarBook> load(ArrayList<Car> cars, ArrayList<Service> services) {
        ArrayList<CarBook> returnCarBooks = new ArrayList<>();

        String[] carBooks = ReadFromFile.read("src/data/carbooks.txt").split("\n");

        for (String carBook : carBooks) {
            if (!carBook.isEmpty()) {
                ArrayList<Service> carBookServices = new ArrayList<>();

                String[] carBookSplit = carBook.split("\\|");
                Car carBookCar = Checks.findCar(carBookSplit[1], cars);
                boolean deleted = Boolean.parseBoolean(carBookSplit[0]);
                String[] serviceIDs = carBookSplit[2].split(";");

                CarBook c = new CarBook(deleted, carBookCar);

                for (String serviceID : serviceIDs) {
                    Service service = Checks.findService(serviceID, services);

                    if (service != null && service.isDeleted() == false) {
                        carBookServices.add(service);
                    }
                }

                c.setServices(carBookServices);
                returnCarBooks.add(c);
            }
        }

        return returnCarBooks;
    }
}

