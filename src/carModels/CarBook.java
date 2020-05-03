package carModels;

public class CarBook {
    private Car car;
    private Service[] services;

    public CarBook(carModels.Car car, Service[] services) {
        this.car = car;
        this.services = services;
    }

    public carModels.Car getCar() {
        return car;
    }

    public void setCar(carModels.Car car) {
        this.car = car;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }
}
