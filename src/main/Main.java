package main;
import carModels.Car;
import gui.LoginWindow;
import userModels.Person;

import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Access access = new Access();

        ArrayList<Car> cars_temp = LoadCars.load();
        Set<Person> people_temp = LoadUsers.load(cars_temp);

        access.setParts(LoadParts.load());
        access.setServices(LoadServices.load(cars_temp, people_temp, access.getParts()));
        access.setCarBooks(LoadCarBooks.load(cars_temp, access.getServices()));
        access.setCars(LoadCars.setCarBooks(cars_temp, access.getCarBooks()));
        access.setPeople(LoadUsers.load(access.getCars()));

        LoginWindow loginWindow = new LoginWindow(access);
        loginWindow.setVisible(true);
    }
}