package main;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import userModels.Worker;
import utility.Checks;
import utility.ReadFromFile;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class LoadServices {
    public ArrayList<Service> load(ArrayList<Car> Cars, ArrayList<Part> Parts){
        ReadFromFile readFromFile = new ReadFromFile();
        Checks c = new Checks();
        LoadParts lp = new LoadParts();
        String[] servicesString;

        servicesString = readFromFile.read("src/data/services.txt").split("\n");
        ArrayList<Service> Services = new ArrayList<>();

        for (String service : servicesString){
            String[] serviceSplit = service.split("\\|");

            Car car = c.findCar(Cars, serviceSplit[0]);
            Worker worker = c.findWorker(serviceSplit[1]);
            GregorianCalendar date = c.stringToDate(serviceSplit[2]);
            String description = serviceSplit[3];
            ArrayList<Part> usedParts = c.findParts(serviceSplit[4].split(","));
            String serviceID = serviceSplit[6];
            String state = serviceSplit[5];

            Service ser = new Service(car, worker, date, description, usedParts, state, serviceID);
            Services.add(ser);
        }

        return Services;
    }
}
