package main;

import carModels.CarBook;
import carModels.Service;
import utility.ReadFromFile;

import java.util.ArrayList;

public class LoadCarBooks {
    public ArrayList<CarBook> load(ArrayList<Service> services) {
        ReadFromFile readFromFile = new ReadFromFile();
        ArrayList<CarBook> returnCarBooks = new ArrayList<>();

        String[] carBooks = ReadFromFile.read("src/data/carbooks.txt").split("\n");

        for (String carBook : carBooks){
            ArrayList<Service> carBookServices = new ArrayList<>();

            String[] carBookSplit = carBook.split("\\|");
            String carBookCar = carBookSplit[0];

            CarBook c = null;

            for (Service service : services){
                if (service.getCar().getCarID().equals(carBookCar)){
                    c = new CarBook(service.getCar());
                    carBookServices.add(service);
                }
            }
            assert c != null;
            c.setServices(carBookServices);

            returnCarBooks.add(c);
        }

        return returnCarBooks;
    }
}
