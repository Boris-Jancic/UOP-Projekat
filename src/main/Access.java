package main;

import carModels.Car;
import carModels.CarBook;
import carModels.Part;
import carModels.Service;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Access {
    private ArrayList<Part> parts;
    private ArrayList<Service> services;
    private ArrayList<CarBook> carBooks;
    private ArrayList<Car> cars;
    private Set<Person> people;

    public Access() {}

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }

    public void setCarBooks(ArrayList<CarBook> carBooks) {
        this.carBooks = carBooks;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Set<Person> getPeople() {
        Set<Person> returnPeople = new HashSet<>();
        for (Person person : people) {
            if (!person.isDeleted()) {
                returnPeople.add(person);
            }
        }
        return returnPeople;
    }

    public ArrayList<Car> getCars() {
        ArrayList<Car> returnCars = new ArrayList<>();
        for (Car car : cars) {
            if (!car.isDeleted()) {
                returnCars.add(car);
            }
        }
        return returnCars;
    }

    public ArrayList<Part> getParts() {
        ArrayList<Part> returnParts = new ArrayList<>();
        for (Part part : parts) {
            if (!part.isDeleted()) {
                returnParts.add(part);
            }
        }
        return returnParts;
    }

    public ArrayList<Service> getServices() {
        ArrayList<Service> returnServices = new ArrayList<>();
        for (Service service : services) {
            if (!service.isDeleted()) {
                returnServices.add(service);
            }
        }
        return returnServices;
    }

    public ArrayList<CarBook> getCarBooks() {
        ArrayList<CarBook> returnCarBooks = new ArrayList<>();
        for (CarBook carBook : carBooks) {
            if (!carBook.isDeleted()) {
                returnCarBooks.add(carBook);
            }
        }
        return returnCarBooks;
    }

    public void addClient(Client client) { this.people.add(client); }

    public void addWorker(Worker worker) { this.people.add(worker); }

    public void addAdmin(Admin admin) { this.people.add(admin); }

    public void addCar(Car car) { this.cars.add(car); }

    public void addPart(Part part) { this.parts.add(part); }

    public void addService(Service service) { this.services.add(service); }

    public Car findCar(String carID) {
        for (Car car : cars) {
            if (carID.equals(car.getCarID()) && !car.isDeleted()) {
                return car;
            }
        }
        return null;
    }

    public ArrayList<Car> getClientCars(String id) {
        ArrayList<Car> returnCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getClient().getId().equals(id)) {
                returnCars.add(car);
            }
        }
        return returnCars;
    }

    public Client findClient(String userName) {
        for (Person person : people) {
            if (person instanceof Client && person.getUsername().equals(userName)) {
                return (Client) person;
            }
        }
        return null;
    }

    public Worker findWorker(String userName) {
        for (Person person : people) {
            if (person instanceof Worker && person.getUsername().equals(userName)) {
                return (Worker) person;
            }
        }
        return null;
    }

    public Admin findAdmin(String userName) {
        for (Person person : people) {
            if (person instanceof Admin && person.getUsername().equals(userName)) {
                return (Admin) person;
            }
        }
        return null;
    }


    public ArrayList<Client> findClients() {
        ArrayList<Client> returnClients = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Client) {
                returnClients.add((Client) person);
            }
        }
        return returnClients;
    }

    public ArrayList<Worker> findWorkers() {
        ArrayList<Worker> returnWorkers = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Worker) {
                returnWorkers.add((Worker) person);
            }
        }
        return returnWorkers;
    }

    public ArrayList<Admin> findAdmins() {
        ArrayList<Admin> returnAdmins = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof Admin) {
                returnAdmins.add((Admin) person);
            }
        }
        return returnAdmins;
    }

    public Part findPart(String partID) {
        for (Part part : parts) {
            if (part.getId().equals(partID) && !part.isDeleted()) {
                return part;
            }
        }
        return null;
    }

    public ArrayList<Part> findParts(String[] partIDs) {
        ArrayList<Part> returnParts = new ArrayList<>();
        for (Part part : parts) {
            for (String partId : partIDs) {
                if (part.getId().equals(partId)) {
                    returnParts.add(part);
                }
            }
        }
        return returnParts;
    }

    public ArrayList<Service> getClientServices(Client person) {
        ArrayList<Service> returnServices = new ArrayList<>();
        for (CarBook carBook : carBooks) {
            for (Car car : person.getCars()) {
                if (carBook.getCar().getCarID().equals(car.getCarID())) {
                    returnServices.addAll(carBook.getServices());
                }
            }
        }
        return returnServices;
    }

    public ArrayList<Service> getWorkerServices(Worker worker) {
        ArrayList<Service> returnServices = new ArrayList<>();
        for (Service service : services) {
            if (service.getWorker() != null) {
                if (service.getWorker().getId().equals(worker.getId())) {
                    returnServices.add(service);
                }
            }
        }
        return returnServices;
    }

    public Service findService(String serviceID) {
        for (Service service : services) {
            if (service.getId().equals(serviceID)) {
                return service;
            }
        }
        return null;
    }

    public void updateCarBooks() {
        ArrayList<CarBook> carBooksReturn = new ArrayList<>();
        ArrayList<String> carBookIDs = new ArrayList<>();

        for (CarBook carBook : carBooks) {  // Proverava da li postoji auto koji vec ima knjizicu i ako postoji upisuje servis u nju
            ArrayList<Service> servicesReturn = new ArrayList<>();
            CarBook carBookNew = new CarBook(false, carBook.getCar());

            for (Service service : services) {
                if (carBookNew.getCar().getCarID().equals(service.getCar().getCarID()) && !service.isDeleted()) {
                    servicesReturn.add(service);
                }
            }

            carBookNew.setServices(servicesReturn);
            carBooksReturn.add(carBookNew);
        }

        for (CarBook c : carBooks) {
            carBookIDs.add(c.getCar().getCarID());
        }

        for (Service service : services) {  // Ako postoji auto koji nema ni jedan servis napravice se nova knjizica
            if (!carBookIDs.contains(service.getCar().getCarID())) {
                CarBook carBook = new CarBook(false, service.getCar());
                carBook.addService(service);
                carBooksReturn.add(carBook);
                break;
            }
        }

        this.carBooks = carBooksReturn;
    }
}