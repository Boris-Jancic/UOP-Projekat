package carModels;

public class carBook {
    private car car;
    private service[] services;

    public carBook(carModels.car car, service[] services) {
        this.car = car;
        this.services = services;
    }

    public carModels.car getCar() {
        return car;
    }

    public void setCar(carModels.car car) {
        this.car = car;
    }

    public service[] getServices() {
        return services;
    }

    public void setServices(service[] services) {
        this.services = services;
    }
}
