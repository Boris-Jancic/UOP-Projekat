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
                ", services=" + printServices() +
                '}';
    }


    public String carBookToString() {
        return car.getCarID() + "|" + printServices();
    }


    private String printServices() {
        String output = "";

        for (Service service : services) {
            output += service.getId() + ";";
        }

        return output;
    }


    public Car getCar() { return car; }

    public void setCar(Car car) { this.car = car; }

    public void setServices(ArrayList<Service> services) { this.services = services; }

    public ArrayList<Service> getServices() { return services; }

}