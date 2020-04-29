package userModels;

public class Admin extends Employe {


    public Admin(String id, String name, String lastName, String jmbg, String gender
            , String address, String phone, String username, String password, double sallary) {
        super(id, name, lastName, jmbg, gender, address, phone, username, password, sallary);
    }

    private void addMembers(){

    }
}
