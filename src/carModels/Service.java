package carModels;

import userModels.Worker;
import utility.Checks;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Service {
    private Car car;
    private Worker worker;
    private GregorianCalendar reservation;
    private String description;
    private ArrayList<Part> usedParts;
    private String status;
    private String id;

    public Service(Car car, Worker worker, GregorianCalendar reservation, String description,
                   ArrayList<Part> usedParts, String status, String id) {
        this.car = car;
        this.worker = worker;
        this.reservation = reservation;
        this.description = description;
        this.usedParts = usedParts;
        this.status = status;
        this.id = id;
    }

    public String serviceToString() {
        return  this.car.getCarID() + "|" + this.worker.getId() + "|" + Checks.dateToString(this.reservation) + "|" +
                this.description + "|" + printParts() + "|" + this.status + "|" + this.id;

    }

    @Override
    public String toString() {
        return "service{" +
                "car=" + car.getCarID() +
                ", worker=" + worker.getId() +
                ", reservation=" + reservation.getTime() +
                ", description='" + description + '\'' +
                ", usedParts=" + printParts() +
                ", status=" + status +
                ", id='" + id + '\'' +
                '}';
    }

    private String printParts() {
        String output = "";

        for (Part part : usedParts) {
            output += part.getId() + ",";
        }

        return output;
    }

    public void setCar(Car car) { this.car = car; }

    public Worker getWorker() { return worker; }

    public void setWorker(Worker worker) { this.worker = worker; }

    public GregorianCalendar getReservation() { return reservation; }

    public void setReservation(GregorianCalendar reservation) { this.reservation = reservation; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public ArrayList<Part> getUsedParts() { return usedParts; }

    public void setUsedParts(ArrayList<Part> usedParts) { this.usedParts = usedParts; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public void setId(String id) { this.id = id; }

    public Car getCar() {
        return car;
    }

    public String getId() { return id; }

}