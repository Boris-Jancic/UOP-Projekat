package userModels;

import carModels.Car;

public class Client extends Person {
    private int points;
    private Car[] cars;

    public Client(String name, String lastName, String jmbg, String gender,
                  String address, String phone, String username, String password, int points) {
        super(name, lastName, jmbg, gender, address, phone, username, password);
        this.points = points;
    }

    public Client(String name, String lastName, String jmbg, String gender,
                  String address, String phone, String username, String password,
                  int points, String id) {
        super(name, lastName, jmbg, gender, address, phone, username, password);
        this.points = points;
        this.id = id;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "client{" +
                "points=" + points +
                ", cars='" + this.cars + '\'' +
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
