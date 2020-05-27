package userModels;

public abstract class Employe extends Person {
    private double sallary;

    public Employe(String name, String lastName, String jmbg, String gender,
                   String address, String phone, String username, String password, double sallary) {
        super(name, lastName, jmbg, gender, address, phone, username, password);
        this.sallary = sallary;
    }

    public double getSallary() { return sallary; }

    public void setSallary(double sallary) { this.sallary = sallary; }
}

