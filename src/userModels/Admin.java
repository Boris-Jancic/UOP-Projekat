package userModels;

import enums.Gender;

public class Admin extends Employe {


    public Admin(String name, String lastName, String jmbg, Gender gender, String address, String phone,
                 String username, String password, double salary, String id, boolean deleted) {
        super(name, lastName, jmbg, gender, address, phone, username, password, salary, deleted);
        this.id = id;
    }

    @Override
    public String toString() {
        return "admin {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salary='" + getSalary() + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }

}
