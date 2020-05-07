package carModels;

import userModels.Worker;

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

    private String printParts(){
        StringBuilder output = new StringBuilder();

        for (Part part : usedParts){
            output.append("|").append(part.getId()).append("|");

        }
        return output.toString();
    }


    public Car getCar() { return car; }


    public String getId() { return id; }

}
