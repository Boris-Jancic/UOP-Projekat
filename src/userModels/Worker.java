package userModels;

public class Worker extends Employe {
    private String specialization;

    public Worker(String name, String lastName, String jmbg, String gender, String address, String phone,
                  String username, String password, String id, Double sallary, String specialization, boolean deleted) {
        super(name, lastName, jmbg, gender, address, phone, username, password, sallary, deleted);

        this.specialization = specialization;
        this.id = id;
    }


    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

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
