package carModels;

import enums.Fuel;
import enums.Mark;
import enums.Model;
import userModels.Client;

public class Car {

    private Client client;
    private String carID;
    private Model model;
    private Mark mark;
    private Fuel fuel;
    private String age;
    private float engineVolume;
    private int enginePower;
    private CarBook carBook;
    private boolean deleted;

    public Car(Client client, String carID, Mark mark, Model model, Fuel fuel,
               String age, float engineVolume, int enginePower, boolean deleted) {
        this.client = client;
        this.carID = carID;
        this.mark = mark;
        this.model = model;
        this.fuel = fuel;
        this.age = age;
        this.engineVolume = engineVolume;
        this.enginePower = enginePower;
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "car{" +
                "clientID=" + client.getId() +
                ", carID=" + carID +
                ", mark=" + mark +
                ", model=" + model +
                ", fuel=" + fuel +
                ", age='" + age + '\'' +
                ", engineVolume=" + engineVolume +
                ", enginePower=" + enginePower +
                ", deleted=" + deleted +
                '}';
    }


    public String carToString() {
        return this.client.getId() + "|" + this.carID + "|" + this.mark + "|" + this.model + "|" +
                this.fuel + "|" + this.age + "|" + this.engineVolume + "|" + this.enginePower + "|" + this.deleted;
    }

    public Client getClient() {
        return client;
    }

    public String getCarID() {
        return carID;
    }

    public void setClient(Client client) { this.client = client; }

    public void setCarID(String carID) { this.carID = carID; }

    public Mark getMark() { return mark; }

    public void setMark(Mark mark) { this.mark = mark; }

    public Model getModel() { return model; }

    public void setModel(Model model) { this.model = model; }

    public Fuel getFuel() { return fuel; }

    public void setFuel(Fuel fuel) { this.fuel = fuel; }

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    public float getEngineVolume() { return engineVolume; }

    public void setEngineVolume(float engineVolume) { this.engineVolume = engineVolume; }

    public int getEnginePower() { return enginePower; }

    public void setEnginePower(int enginePower) { this.enginePower = enginePower; }

    public CarBook getCarBook() { return carBook; }

    public void setCarBook(CarBook carBook) {
        this.carBook = carBook;
    }

    public boolean isDeleted() { return deleted; }

    public void setDeleted(boolean deleted) { this.deleted = deleted; }

}