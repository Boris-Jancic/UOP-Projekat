package register;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import userModels.Person;
import userModels.Worker;
import utility.Checks;
import utility.PickEnums;
import utility.WriteToFile;

import java.util.*;

public class RegisterService {

    public static Service register(ArrayList<Car> Cars, Set<Person> people) {
        PickEnums pickEnums = new PickEnums();
        WriteToFile tofile = new WriteToFile();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n>>> ID radnika :");
        String workerID = scanner.nextLine();
        Worker worker = Checks.findWorker(workerID, people);

        if (worker == null) {
            System.out.println("\n! Nema datog radnika !");
            return null;
        }

        System.out.print(">>> ID automobila za servisiranje :");
        String carID = scanner.nextLine();

        Car car = Checks.findCar(Cars, carID);
        if (car == null) {
            System.out.println("\n! Nema datog automobila !");
            return null;
        }

        System.out.print(">>> Datum servisa (dd.mm.yyyy) : ");
        String date = scanner.nextLine();
        GregorianCalendar reservation = Checks.stringToDate(date);

        System.out.print(">>> Opis :");
        String description = scanner.nextLine();


        System.out.print(">>> Iskorisceni delovi (odvojeni zarezom => ID,ID) :");
        String usedParts = scanner.nextLine();
        ArrayList<Part> parts = Checks.findParts(usedParts.split(","));

        if (parts == null) {
            System.out.println("Nema datih delova");
            return null;
        }

        String status = pickEnums.pickStatus();

        Random r = new Random();
        int rand = r.nextInt(999999);

        String carBook = carID + "|" + rand;

        if (!Checks.writeCarBook(carID, Integer.toString(rand)))
            tofile.write(carBook, "src/data/carbooks.txt");


        Service serviceReturn = new Service(car, worker, reservation, description, parts, status, Integer.toString(rand));
        return serviceReturn;
    }
}