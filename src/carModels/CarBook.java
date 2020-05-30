package carModels;

import java.util.ArrayList;

public class CarBook {
    private Car car;
    private ArrayList<Service> services = new ArrayList<>();

    public CarBook() {}
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
        if (this.services.size() != 0)
            return car.getCarID() + "|" + printServices();
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


    public Car getCar() { return car; }

    public void setCar(Car car) { this.car = car; }

    public void setServices(ArrayList<Service> services) { this.services = services; }

    public void addService(Service service) { this.services.add(service) ;}
    public void removeService(Service service) { this.services.remove(service) ;}

    public ArrayList<Service> getServices() { return services; }

}