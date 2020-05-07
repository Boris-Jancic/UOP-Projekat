package carModels;

import java.util.Random;

public class Part {
    private String mark;
    private String model;
    private String name;
    private double price;
    private String id;

    final Random r = new Random();
    final int rand = r.nextInt(999999);

    public Part(String mark, String model, String name,
                double price) {
        this.mark = mark;
        this.model = model;
        this.name = name;
        this.price = price;
        this.id = Integer.toString(rand);
    }

    @Override
    public String toString() {
        return "part{" +
                "mark=" + mark +
                ", model=" + model +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
