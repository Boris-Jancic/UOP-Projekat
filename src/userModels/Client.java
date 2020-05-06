package userModels;

import carModels.Car;

import java.util.ArrayList;

public class Client extends Person {
    private int points;
    private ArrayList<Car> cars;

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

    private String printCars(){
        String carId = "";
        for (Car car : this.cars){
            carId += "|" + car.getCarID() + "|";
        }
        return carId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Car linkCars(String username){
        for (Car car : cars){
            if(this.username.equals(car.getClient().getUsername()));
                return car;
        }
        return null;
    }

    public void addCar(Car car) { this.cars.add(car); }

    public void removeCar(Car car) {this.cars.remove(car); }


    public ArrayList<Car> getCars() { return cars; }

    public void setCars(ArrayList<Car> cars) { this.cars = cars; }

}
