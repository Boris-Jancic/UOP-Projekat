package userModels;

import carModels.Car;
import carModels.CarBook;
import carModels.Service;
import enums.Gender;

import java.util.ArrayList;

public class Client extends Person {
    private int points;
    private ArrayList<Car> cars;

    public Client(String name, String lastName, String jmbg, Gender gender, String address, String phone,
                  String username, String password, String id, int points, boolean deleted) {

        super(name, lastName, jmbg, gender, address, phone, username, password, deleted);
        this.points = points;
        this.id = id;
    }

    @Override
    public String toString() {
        return "client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cars='" + printCars() +
                ", points=" + points +
                ", deleted='" + deleted + '\'' +
                '}';
    }



    private String printCars() {
        String output = "";
        for (Car car : cars) {
            output += "|" + car.getCarID() + "|";
        }
        return output;
    }

    public int getPoints() { return points; }

    public void setPoints(int points) { this.points = points; }

    public ArrayList<Car> getCars() { return cars; }

    public void setCars(ArrayList<Car> cars) { this.cars = cars; }

    public ArrayList<Car> allNonDeletedCars() {
        ArrayList<Car> returnCars = new ArrayList<>();
        for (Car car : getCars()) {
            if (!car.isDeleted()) {
                returnCars.add(car);
            }
        }
        return returnCars;
    }

    public ArrayList<Service> allServices() {
        ArrayList<Service> services = new ArrayList<>();
        for (Car car : getCars()) {
            if (car.getCarBook() != null) {
                for (Service service : car.getCarBook().getServices()) {
                    services.add(service);
                }
            }
        }
        return services;
    }
}
