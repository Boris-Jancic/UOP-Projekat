package userModels;

public class Admin extends Employe {


    public Admin(String name, String lastName, String jmbg, String gender
            , String address, String phone, String username, String password, double sallary) {
        super(name, lastName, jmbg, gender, address, phone, username, password, sallary);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
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

    private void addMembers(){

    }
}
