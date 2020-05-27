package functions;

import carModels.Part;
import utility.Checks;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete {

    public static ArrayList<Part> deletePart(ArrayList<Part> parts) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n>>> Unesite ID dela koji zelite da obrisete : ");
        String partID = scanner.nextLine();

        Part deletedPart = Checks.findPart(partID, parts);
        parts.remove(deletedPart);
        return parts;
    }
}
