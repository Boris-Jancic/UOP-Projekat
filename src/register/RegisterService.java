package register;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import userModels.Worker;
import utility.Checks;
import utility.PickEnums;
import utility.WriteToFile;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class RegisterService {

    public Service register(ArrayList<Car> Cars) {
        PickEnums pickEnums = new PickEnums();
        Scanner scanner = new Scanner(System.in);
        Checks check = new Checks();
        WriteToFile tofile = new WriteToFile();

        System.out.print("\n>>> ID radnika :");
        String workerID = scanner.nextLine();
        Worker worker = check.findWorker(workerID);

        if (worker == null) {
            System.out.println("\n! Nema datog radnika !");
            return null;
        }

        System.out.print(">>> ID automobila za servisiranje :");
        String carID = scanner.nextLine();

        Car car = check.findCar(Cars, carID);
        if (car == null) {
            System.out.println("\n! Nema datog automobila !");
            return null;
        }

        System.out.print(">>> Datum servisa (dd.mm.yyyy) : ");
        String date = scanner.nextLine();
        GregorianCalendar reservation = check.stringToDate(date);

        System.out.print(">>> Opis :");
        String description = scanner.nextLine();


        System.out.print(">>> Iskorisceni delovi (odvojeni zarezom => ID,ID) :");
        String usedParts = scanner.nextLine();
        ArrayList<Part> parts = check.findParts(usedParts.split(","));
        if (parts == null) {
            System.out.println("Nema datih delova");
            return null;
        }

        String status = pickEnums.pickStatus();

        Random r = new Random();
        int rand = r.nextInt(999999);

        String service = carID + "|" + workerID + "|" + date + "|" + description
                + "|" + usedParts + "|" + status + "|" + rand;

        String carBook = carID + "|" + rand;

        if (!check.writeCarBook(carID, Integer.toString(rand)))
            tofile.write(carBook, "src/data/carbooks.txt");

        tofile.write(service, "src/data/services.txt");

        Service serviceReturn = new Service(car, worker, reservation, description, parts, status, Integer.toString(rand));
        return serviceReturn;
    }
}