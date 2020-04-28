package models;

public class worker extends employe {
    private String specialization;

    public worker(String id, String name, String lastName, String jmbg, String gender, String address, String phone, String username, String password) {
        super(id, name, lastName, jmbg, gender, address, phone, username, password);
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
