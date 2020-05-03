package main;

import utility.ReadFromFile;
import carModels.Service;

public class LoadServices {
    public void load(){
        ReadFromFile readFromFile = new ReadFromFile();
        String[] services;

        services = readFromFile.read("src/data/services.txt").split("\n");

        for (String service : services){
            System.out.println(service);
            String[] serviceSplit = service.split("\\|");
            String carID = serviceSplit[0];
            String date = serviceSplit[1];
            String description = serviceSplit[2];
            String usedParts = serviceSplit[3];
            String state = serviceSplit[4];
            String serviceID = serviceSplit[5];

            Service ser = new Service(carID, "123123",date, description, usedParts, state, serviceID);
            System.out.print(ser.toString());
        }
    }
}
