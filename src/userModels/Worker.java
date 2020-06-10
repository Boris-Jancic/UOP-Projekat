package userModels;

import enums.Gender;
import enums.Specialization;

public class Worker extends Employe {
    private Specialization specialization;

    public Worker(String name, String lastName, String jmbg, Gender gender, String address, String phone,
                  String username, String password, String id, Double sallary, Specialization specialization, boolean deleted) {
        super(name, lastName, jmbg, gender, address, phone, username, password, sallary, deleted);

        this.specialization = specialization;
        this.id = id;
    }


    public Specialization getSpecialization() { return specialization; }

    public void setSpecialization(Specialization specialization) { this.specialization = specialization; }

    @Override
    public String toString() {
        return "worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                "specialization='" + specialization + '\'' +
                ", salary='" + getSalary() + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }

}
