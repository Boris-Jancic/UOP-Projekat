package userModels;

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
    protected boolean deleted;


    public Person(String name, String lastName, String jmbg, String gender, String address,
                  String phone, String username, String password, boolean deleted) {
        this.name = name;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.deleted = deleted;
    }

    public String personToString(){
        return this.name + "|" + this.lastName + "|" + this.jmbg + "|" + this.gender + "|" +
                this.address + "|" + this.phone + "|" + this.username + "|" + this.password + "|" + this.id;
    }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getJmbg() { return jmbg; }

    public void setJmbg(String jmbg) { this.jmbg = jmbg; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }

    public boolean isDeleted() { return deleted; }

    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}