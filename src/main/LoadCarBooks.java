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
                Car carBookCar = Checks.findCar(carBookSplit[0], cars);
                String[] serviceIDs = carBookSplit[1].split(";");

                CarBook c = new CarBook(carBookCar);

                for (String serviceID : serviceIDs) {
                    Service service = Checks.findService(serviceID, services);

                    if (service != null) {
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

