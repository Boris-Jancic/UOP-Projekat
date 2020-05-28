package main;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import userModels.Person;
import userModels.Worker;
import utility.Checks;
import utility.ReadFromFile;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;

public class LoadServices {
    public static ArrayList<Service> load(ArrayList<Car> cars, Set<Person> people, ArrayList<Part> parts) {
        String[] servicesString = ReadFromFile.read("src/data/services.txt").split("\n");
        ArrayList<Service> Services = new ArrayList<>();

        for (String service : servicesString) {
            if (!service.isEmpty()) {
                String[] serviceSplit = service.split("\\|");

                Car car = Checks.findCar(serviceSplit[0], cars);
                Worker worker = Checks.findWorker(serviceSplit[1], people);
                GregorianCalendar date = Checks.stringToDate(serviceSplit[2]);
                String description = serviceSplit[3];
                ArrayList<Part> usedParts = Checks.findParts(serviceSplit[4].split(";"), parts);
                String serviceID = serviceSplit[6];
                String state = serviceSplit[5];

                Service ser = new Service(car, worker, date, description, usedParts, state, serviceID);
                Services.add(ser);
            }
        }

        return Services;
    }
}
