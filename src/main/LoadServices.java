package main;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import enums.Status;
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
                Status state = Status.valueOf(serviceSplit[5]);
                String serviceID = serviceSplit[6];
                boolean deleted = Boolean.parseBoolean(serviceSplit[7]);

                Service ser = new Service(car, worker, date, description, usedParts, state, serviceID, deleted);
                Services.add(ser);
            }
        }

        return Services;
    }
}
