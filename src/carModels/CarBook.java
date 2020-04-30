package carModels;

public class CarBook {
    private Car car;
    private service[] services;

    public CarBook(carModels.Car car, service[] services) {
        this.car = car;
        this.services = services;
    }

    public carModels.Car getCar() {
        return car;
    }

    public void setCar(carModels.Car car) {
        this.car = car;
    }

    public service[] getServices() {
        return services;
    }

    public void setServices(service[] services) {
        this.services = services;
    }
}
