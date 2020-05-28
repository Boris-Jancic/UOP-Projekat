package carModels;

import userModels.Client;

public class Car {

    private Client client;
    private String carID;
    private String mark;
    private String model;
    private String fuel;
    private String age;
    private float engineVolume;
    private int enginePower;
    private CarBook carBook;

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

    public String carToString() {
        String carString = this.client.getId() + "|" + this.carID + "|" + this.model + "|" + this.mark + "|" +
                this.fuel + "|" + this.age + "|" + this.engineVolume + "|" + this.enginePower;

        return carString;
    }

    public Client getClient() {
        return client;
    }


    public String getCarID() {
        return carID;
    }


    public void setCarBook(CarBook carBook) {
        this.carBook = carBook;
    }
}
