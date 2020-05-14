package userModels;

import carModels.Car;

import java.util.ArrayList;

public class Client extends Person {
    private int points;
    private ArrayList<Car> cars;

    public Client(String name, String lastName, String jmbg, String gender, String address,
                  String phone, String username, String password, int points, String id) {

        super(name, lastName, jmbg, gender, address, phone, username, password);
        this.points = points;
        this.id = id;
        this.cars = new ArrayList<Car>();

    }

    @Override
    public String toString() {
        return "client{" +
                "points=" + points +
                ", cars='" + printCars() +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private String printCars() {
        String output = "";
        for (Car car : cars) {
            output += "|" + car.getCarID() + "|";
        }
        return output;
    }

    public ArrayList<Car> getCars() { return cars; }

    public void setCars(ArrayList<Car> cars) { this.cars = cars; }
}
