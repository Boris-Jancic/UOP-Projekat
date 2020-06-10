package userModels;

import enums.Gender;

public abstract class Employe extends Person {
    private double salary;

    public Employe(String name, String lastName, String jmbg, Gender gender, String address, String phone,
                   String username, String password, double salary, boolean deleted) {
        super(name, lastName, jmbg, gender, address, phone, username, password, deleted);
        this.salary = salary;
    }

    public double getSalary() { return salary; }

    public void setSalary(double salary) { this.salary = salary; }
}

