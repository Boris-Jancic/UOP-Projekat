package userModels;

public abstract class employe extends person {
    private double sallary;

    public employe(String id, String name, String lastName, String jmbg, String gender,
                   String address, String phone, String username, String password, double sallary) {
        super(id, name, lastName, jmbg, gender, address, phone, username, password);
        this.sallary = sallary;
    }

    @Override
    public String toString() {
        return "employe{" +
                "sallary=" + sallary +
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

    public double getSallary() { return sallary; }
    public void setSallary(double sallary) { this.sallary = sallary; }

    private void makeReservation(){

    }
}

