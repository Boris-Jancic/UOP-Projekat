package register;

import carModels.CarBook;
import carModels.Service;
import java.util.ArrayList;

public class UpdateCarBooks {
    public static ArrayList<CarBook> update(ArrayList<Service> services, ArrayList<CarBook> carBooks) {
        ArrayList<CarBook> carBooksReturn = new ArrayList<>();
        ArrayList<String> carBookIDs = new ArrayList<>();

        for (CarBook carBook : carBooks) {  // Proverava da li postoji auto koji vec ima knjizicu i ako postoji upisuje servis u nju
            ArrayList<Service> servicesReturn = new ArrayList<>();
            CarBook carBookNew = new CarBook(false, carBook.getCar());

            for (Service service : services) {
                if (carBookNew.getCar().getCarID().equals(service.getCar().getCarID())) {
                    servicesReturn.add(service);
                }
            }

            carBookNew.setServices(servicesReturn);
            carBooksReturn.add(carBookNew);
        }

        for (CarBook c : carBooks) {
            carBookIDs.add(c.getCar().getCarID());
        }

        for (Service service : services) {  // Ako postoji auto koji nema ni jedan servis napravice se nova knjizica
            if (!carBookIDs.contains(service.getCar().getCarID())) {
                CarBook carBook = new CarBook(false, service.getCar());
                carBook.addService(service);
                carBooksReturn.add(carBook);
                break;
            }
        }


        return carBooksReturn;
    }
}