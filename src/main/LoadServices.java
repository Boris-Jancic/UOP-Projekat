package main;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import userModels.Person;
import userModels.Worker;
import utility.Checks;
import utility.ReadFromFile;
import enums.Status;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;

public class LoadServices {
    public static ArrayList<Service> load(ArrayList<Car> cars, Set<Person> people, ArrayList<Part> parts) {
        String[] servicesString = ReadFromFile.read("src/data/services.txt").split("\n");
        ArrayList<Service> Services = new ArrayList<>();

        for (String serviceStr : servicesString) {
            if (!serviceStr.isEmpty()) {
                String[] serviceSplit = serviceStr.split("\\|");
                Car car = Checks.findCar(serviceSplit[0], cars);

                String description;
                String serviceID;
                boolean deleted;

                if (serviceSplit.length == 4) {
                    description = serviceSplit[1];
                    serviceID = serviceSplit[2];
                    deleted = Boolean.parseBoolean(serviceSplit[3]);
                    Service service = new Service(car, description, serviceID, deleted);
                    Services.add(service);

                } else {
                    Worker worker = Checks.findWorker(serviceSplit[1], people);
                    GregorianCalendar date = Checks.stringToDate(serviceSplit[2]);
                    description = serviceSplit[3];
                    ArrayList<Part> usedParts = Checks.findParts(serviceSplit[4].split(";"), parts);
                    Status status = Status.valueOf(serviceSplit[5]);
                    serviceID = serviceSplit[6];
                    deleted = Boolean.parseBoolean(serviceSplit[7]);
                    Service service = new Service(car, worker, date, description, usedParts, status, serviceID, deleted);
                    Services.add(service);
                }
            }
        }

        return Services;
    }
}
