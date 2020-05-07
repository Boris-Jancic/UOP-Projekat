package carModels;

import java.util.ArrayList;

public class CarBook {
    private Car car;
    private ArrayList<Service> services;

    public CarBook(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarBook{" +
                "car=" + car.getCarID() +
                ", services=" + printParts() +
                '}';
    }

    private String printParts(){
        String output = "";

        for (Service service : services){
            output += "|" + service.getId() + "|";

        }
        return output;
    }


    public void setServices(ArrayList<Service> services) { this.services = services; }

    public ArrayList<Service> getServices() { return services; }

    public carModels.Car getCar() { return car; }

    public void setCar(carModels.Car car) { this.car = car; }

    public void addService(Service service) { this.services.add(service); }
    public void removeServices(Service service) { this.services.remove(service); }


}
