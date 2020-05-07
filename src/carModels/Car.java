package carModels;

import userModels.Client;

import java.util.Random;

public class Car {

    private Client client;
    private String carID;
    private String mark;
    private String  model;
    private String  fuel;
    private String age;
    private float engineVolume;
    private int enginePower;
    private CarBook carBook;

    Random r = new Random();
    int rand = r.nextInt(999999);

    public Car(Client client, String carID, String mark, String model, String fuel,
               String age, float engineVolume, int enginePower) {
        this.client = client;
        this.carID = carID;
        this.mark = mark;
        this.model = model;
        this.fuel = fuel;
        this.age = age;
        this.engineVolume = engineVolume;
        this.enginePower = enginePower;
    }

    public Car(Client client, String mark, String model, String fuel,
                    String age, float engineVolume, int enginePower) {
        this.client = client;
        this.carID = Integer.toString(rand);
        this.mark = mark;
        this.model = model;
        this.fuel = fuel;
        this.age = age;
        this.engineVolume = engineVolume;
        this.enginePower = enginePower;
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
                '}';
    }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }


    public String getCarID() { return carID; }

    public void setCarID(String carID) { this.carID = carID; }


    public String  getMark() { return mark; }

    public void setMark(String mark) { this.mark = mark; }


    public String  getModel() { return model; }

    public void setModel(String  model) { this.model = model; }


    public String  getFuel() { return fuel; }

    public void setFuel(String  fuel) { this.fuel = fuel; }


    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }


    public float getEngineVolume() { return engineVolume; }

    public void setEngineVolume(float engineVolume) { this.engineVolume = engineVolume; }


    public int getEnginePower() { return enginePower; }

    public void setEnginePower(int enginePower) { this.enginePower = enginePower;}


    public CarBook getCarBook() { return carBook; }

    public void setCarBook(CarBook carBook) { this.carBook = carBook; }
}
