package carModels;

import userModels.Worker;

import java.util.Arrays;
import java.util.Date;

class service {
    private String carID;
    private Worker worker;
    private Date reservation;
    private String description;
    private Part[] usedParts;
    private String status;
    private String id;

    @Override
    public String toString() {
        return "service{" +
                "car=" + carID +
                ", worker=" + worker +
                ", reservation=" + reservation +
                ", description='" + description + '\'' +
                ", usedParts=" + Arrays.toString(usedParts) +
                ", status=" + status +
                ", id='" + id + '\'' +
                '}';
    }

    public service(String carID, Worker worker, Date reservation, String description,
                   Part[] usedParts, String status, String id) {
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

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Date getReservation() {
        return reservation;
    }

    public void setReservation(Date reservation) {
        this.reservation = reservation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Part[] getUsedParts() {
        return usedParts;
    }

    public void setUsedParts(Part[] usedParts) {
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
