package userModels;

import carModels.Car;

import java.util.ArrayList;

public class Client extends Person {
    private int points;
    private ArrayList<Car> cars;

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
        StringBuilder carId = new StringBuilder();
        for (Car car : this.cars){
            carId.append("|").append(car.getCarID()).append("|");
        }
        return carId.toString();
    }


    public void setCars(ArrayList<Car> cars) { this.cars = cars; }

}
