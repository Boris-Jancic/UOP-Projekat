package register;

import utility.Checks;
import utility.PickEnums;
import utility.WriteToFile;

import java.util.Random;
import java.util.Scanner;

public class RegisterService {

    public void register(){
        PickEnums pickEnums = new PickEnums();
        Scanner scanner = new Scanner(System.in);
        Checks check = new Checks();
        WriteToFile tofile = new WriteToFile();

        System.out.print(">>> ID automobila za servisiranje :");
        String carID = scanner.nextLine();

        if (!check.ifCarExists(carID)) {
            return;
        }

        System.out.print(">>> Datum servisa (dd.mm.yyyy) : ");
        String date = scanner.nextLine();

        System.out.print(">>> Opis :");
        String description = scanner.nextLine();

        System.out.print(">>> Iskorisceni delovi :");
        String usedParts = scanner.nextLine();

        String status = pickEnums.pickStatus();

        Random r = new Random();
        int rand = r.nextInt(999999);

        String service = carID + "|" + date + "|" + description  + "|" + usedParts
                + "|" + status  + "|" + rand;
        System.out.println(service);

        tofile.write(service,"src/data/services.txt");
    }
}
