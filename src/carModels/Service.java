package carModels;

public class Service {
    private String carID;
    private String worker;
    private String reservation;
    private String description;
    private String usedParts;
    private String status;
    private String id;

    @Override
    public String toString() {
        return "service{" +
                "car=" + carID +
                ", worker=" + worker +
                ", reservation=" + reservation +
                ", description='" + description + '\'' +
                ", usedParts=" + usedParts +
                ", status=" + status +
                ", id='" + id + '\'' +
                '}';
    }

    public Service(String carID, String worker, String reservation, String description,
                   String usedParts, String status, String id) {
        this.carID = carID;
        this.worker = worker;
        this.reservation = reservation;
        this.description = description;
        this.usedParts = usedParts;
        this.status = status;
        this.id = id;
    }

    public String getCar() {
        return carID;
    }

    public void setCar(String carID) {
        this.carID = carID;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsedParts() {
        return usedParts;
    }

    public void setUsedParts(String usedParts) {
        this.usedParts = usedParts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
