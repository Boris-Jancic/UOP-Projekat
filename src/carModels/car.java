package carModels;
import userModels.client;

enum mark{
    BMW,LAMBO,YUGO,OPEL
}
enum fuel{
    DIZEL,ELECTRIC,GAS
}
enum model{
    ONE,TWO,THREE,FOUR
}

public class car {

    private client client;
    private mark mark;
    private model model;
    private fuel fuel;
    private String age;
    private float engineVolume;
    private int enginePower;
    private String id;

    public car(userModels.client client, carModels.mark mark, carModels.model model, carModels.fuel fuel,
               String age, float engineVolume, int enginePower, String id) {
        this.client = client;
        this.mark = mark;
        this.model = model;
        this.fuel = fuel;
        this.age = age;
        this.engineVolume = engineVolume;
        this.enginePower = enginePower;
        this.id = id;
    }

    @Override
    public String toString() {
        return "car{" +
                "client=" + client +
                ", mark=" + mark +
                ", model=" + model +
                ", fuel=" + fuel +
                ", age='" + age + '\'' +
                ", engineVolume=" + engineVolume +
                ", enginePower=" + enginePower +
                ", id='" + id + '\'' +
                '}';
    }

    public userModels.client getClient() {
        return client;
    }

    public void setClient(userModels.client client) {
        this.client = client;
    }

    public carModels.mark getMark() {
        return mark;
    }

    public void setMark(carModels.mark mark) {
        this.mark = mark;
    }

    public carModels.model getModel() {
        return model;
    }

    public void setModel(carModels.model model) {
        this.model = model;
    }

    public carModels.fuel getFuel() {
        return fuel;
    }

    public void setFuel(carModels.fuel fuel) {
        this.fuel = fuel;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
