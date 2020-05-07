package register;

import utility.Checks;
import utility.PickEnums;
import utility.WriteToFile;

import java.util.Random;
import java.util.Scanner;

public class RegisterService {

    public void register() {
        PickEnums pickEnums = new PickEnums();
        Scanner scanner = new Scanner(System.in);
        Checks check = new Checks();
        WriteToFile tofile = new WriteToFile();

        System.out.print("\n>>> ID radnika :");
        String workerID = scanner.nextLine();

        if (check.findWorker(workerID) == null) {
            System.out.println("\n! Nema datog radnika !");
            return;
        }

        System.out.print(">>> ID automobila za servisiranje :");
        String carID = scanner.nextLine();

        if (!check.ifCarExists(carID)) {
            System.out.println("\n! Nema datog automobila !");
            return;
        }

        System.out.print(">>> Datum servisa (dd.mm.yyyy) : ");
        String date = scanner.nextLine();

        System.out.print(">>> Opis :");
        String description = scanner.nextLine();


        System.out.print(">>> Iskorisceni delovi (odvojeni zarezom => ID,ID) :");
        String usedParts = scanner.nextLine();

        if (check.findParts(usedParts.split(",")) == null) {
            System.out.println("Nema datih delova");
            return;
        }

        String status = pickEnums.pickStatus();

        Random r = new Random();
        int rand = r.nextInt(999999);

        String service = carID + "|" + workerID + "|" + date + "|" + description
                + "|" + usedParts + "|" + status  + "|" + rand;

        String carBook = carID + "|" + rand;

        if(!check.writeCarBook(carID, Integer.toString(rand)))
            tofile.write(carBook, "src/data/carbooks.txt");

        tofile.write(service,"src/data/services.txt");
    }
}
