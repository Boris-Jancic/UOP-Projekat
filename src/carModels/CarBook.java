package carModels;

import java.util.ArrayList;

public class CarBook {
    private Car car;
    private ArrayList<Service> services;

    public CarBook(carModels.Car car) {
        this.car = car;
    }

    public carModels.Car getCar() { return car; }

    public void setCar(carModels.Car car) { this.car = car; }

    public void addService(Service service) { this.services.add(service); }
    public void removeServices(Service service) { this.services.remove(service); }


}
