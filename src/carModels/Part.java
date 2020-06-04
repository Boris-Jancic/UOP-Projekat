package carModels;

public class Part {
    private String mark;
    private String model;
    private String name;
    private double price;
    private String id;
    private boolean deleted;

    public Part(String mark, String model, String name,
                double price, String id, boolean deleted) {
        this.mark = mark;
        this.model = model;
        this.name = name;
        this.price = price;
        this.id = id;
        this.deleted = deleted;
    }

    public String partToString() {
        return this.mark + "|" + this.model + "|" + this.name + "|" +
                this.price + "|" + this.id + "|" + this.deleted;
    }

    @Override
    public String toString() {
        return "part{" +
                "mark=" + mark +
                ", model=" + model +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", id='" + id + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }

    public String getMark() { return mark; }

    public void setMark(String mark) { this.mark = mark; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDeleted() { return deleted; }

    public void setAvailable(boolean deleted) { this.deleted = deleted; }

}
