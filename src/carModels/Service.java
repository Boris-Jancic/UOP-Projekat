package carModels;

import userModels.Worker;

import java.util.Arrays;
import java.util.Date;

enum status{
    DONE,FINISHED,NOTFINISHED
}

public class service {
    private car car;
    private Worker worker;
    private Date reservation;
    private String description;
    private Part[] usedParts;
    private status status;
    private String id;

    @Override
    public String toString() {
        return "service{" +
                "car=" + car +
                ", worker=" + worker +
                ", reservation=" + reservation +
                ", description='" + description + '\'' +
                ", usedParts=" + Arrays.toString(usedParts) +
                ", status=" + status +
                ", id='" + id + '\'' +
                '}';
    }

    public service(carModels.car car, Worker worker, Date reservation, String description,
                   Part[] usedParts, carModels.status status, String id) {
        this.car = car;
        this.worker = worker;
        this.reservation = reservation;
        this.description = description;
        this.usedParts = usedParts;
        this.status = status;
        this.id = id;
    }

    public carModels.car getCar() {
        return car;
    }

    public void setCar(carModels.car car) {
        this.car = car;
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

    public carModels.status getStatus() {
        return status;
    }

    public void setStatus(carModels.status status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
