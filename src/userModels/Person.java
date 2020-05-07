package userModels;

import java.util.Random;

public abstract class Person {
    protected String id;
    protected String name;
    protected String lastName;
    protected String jmbg;
    protected String gender;
    protected String address;
    protected String phone;
    protected String username;
    protected String password;
    final Random r = new Random();
    final int rand = r.nextInt(999999);

    public Person(String name, String lastName, String jmbg, String gender, String address, String phone, String username, String password) {
        this.id = Integer.toString(rand);
        this.name = name;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }


    public String getUsername() { return username; }


}
