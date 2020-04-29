package carModels;

public class Part {
    private mark mark;
    private model model;
    private String name;
    private double price;
    private String id;

    public Part(carModels.mark mark, carModels.model model, String name,
                double price, String id) {
        this.mark = mark;
        this.model = model;
        this.name = name;
        this.price = price;
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
