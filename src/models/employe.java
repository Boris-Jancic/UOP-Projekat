package models;

public abstract class employe extends person {
    private int sallary;

    public employe(String id, String name, String lastName, String jmbg, String gender, String address, String phone, String username, String password) {
        super(id, name, lastName, jmbg, gender, address, phone, username, password);
        this.sallary = sallary;
    }

    public int getSallary() { return sallary; }
    public void setSallary(int sallary) { this.sallary = sallary; }

    private void makeReservation(){

    }
}

