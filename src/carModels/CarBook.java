package carModels;

import java.util.ArrayList;

public class CarBook {
    private Car car;
    private ArrayList<Service> services = new ArrayList<>();
    private boolean deleted;


    public CarBook(boolean deleted, Car car) {
        this.deleted = deleted;
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarBook{" +
                "deleted=" + this.deleted +
                ", car=" + car.getCarID() +
                ", services=" + printServices() +
                '}';
    }


    public String carBookToString() {
        if (this.services.size() != 0)
            return deleted + "|" + car.getCarID() + "|" + printServices();
        return "";
    }


    private String printServices() {
        String output = "";

        if (services.size() != 0){
            for (Service service : services) {
                output += service.getId() + ";";
            }
        }

        return output;
    }


    public boolean isDeleted() { return deleted; }

    public void setDeleted(boolean deleted) { this.deleted = deleted; }

    public Car getCar() { return car; }

    public void setCar(Car car) { this.car = car; }

    public void setServices(ArrayList<Service> services) { this.services = services; }

    public void addService(Service service) { this.services.add(service) ;}

    public ArrayList<Service> getServices() { return services; }

}