package models;

public class client extends person {
    private int points;
    //private Car[] cars;

    public client(String id, String name, String lastName, String jmbg, String gender, String address, String phone, String username, String password) {
        super(id, name, lastName, jmbg, gender, address, phone, username, password);
    }
}
