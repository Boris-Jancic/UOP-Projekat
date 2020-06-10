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
import java.util.Set;

public class Access {
    private ArrayList<Car> cars_temp = LoadCars.load();
    private Set<Person> people_temp = LoadUsers.load(cars_temp);
    private ArrayList<Part> parts;
    private ArrayList<Service> services;
    private ArrayList<CarBook> carBooks;
    private ArrayList<Car> cars;
    private Set<Person> people;

    public Access() {
        parts = LoadParts.load();
        services = LoadServices.load(cars_temp, people_temp, parts);
        carBooks = LoadCarBooks.load(cars_temp, services);
        cars = LoadCars.setCarBooks(cars_temp, carBooks);
        people = LoadUsers.setClientCarBooks(people_temp, cars);
    }

    public ArrayList<Part> getParts() { return parts; }

    public ArrayList<Service> getServices() { return services; }

    public ArrayList<CarBook> getCarBooks() { return carBooks; }

    public ArrayList<Car> getCars() { return cars; }

    public Set<Person> getPeople() { return people; }

    public void addClient(Client client) { this.people.add(client); }

    public void addWorker(Worker worker) { this.people.add(worker); }

    public void addAdmin(Admin admin) { this.people.add(admin); }

    public void addCar(Car car) { this.cars.add(car); }

    public void addPart(Part part) { this.parts.add(part); }

    public Car findCar(String carID) {
        for (Car car : cars) {
            if (carID.equals(car.getCarID()) && !car.isDeleted()) {
                return car;
            }
        }
        return null;
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
}
