package carModels;

import java.util.Random;

public class Car {

    private String clientID;
    private String carID;
    private String mark;
    private String  model;
    private String  fuel;
    private String age;
    private float engineVolume;
    private int enginePower;
    private String carBook;

    Random r = new Random();
    int rand = r.nextInt(999999);

    public Car(String clientID, String mark, String model, String fuel,
               String age, float engineVolume, int enginePower, String carBook) {
        this.clientID = clientID;
        this.carID = Integer.toString(rand);
        this.mark = mark;
        this.model = model;
        this.fuel = fuel;
        this.age = age;
        this.engineVolume = engineVolume;
        this.enginePower = enginePower;
        this.carBook = carBook;
    }

    @Override
    public String toString() {
        return "car{" +
                "clientID=" + clientID +
                ", carID=" + carID +
                ", mark=" + mark +
                ", model=" + model +
                ", fuel=" + fuel +
                ", age='" + age + '\'' +
                ", engineVolume=" + engineVolume +
                ", enginePower=" + enginePower +
                ", carBook='" + carBook + '\'' +
                '}';
    }

    public String getClient() { return clientID; }

    public void setClient(String client) { this.clientID = client; }


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


    public String getCarBook() { return carBook; }

    public void setCarBook(String carBook) { this.carBook = carBook; }
}
