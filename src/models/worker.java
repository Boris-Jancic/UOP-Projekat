package models;

public class worker extends employe {
    private String specialization;


    public worker(String id, String name, String lastName, String jmbg,
                  String gender, String address, String phone, String username,
                  String password, String specialization, Double sallary) {
        super(id, name, lastName, jmbg, gender, address, phone, username, password, sallary);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "worker{" +
                "specialization='" + specialization + '\'' +
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
