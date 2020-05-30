package register;

import carModels.Part;
import utility.PickEnums;
import java.util.Random;
import java.util.Scanner;

public class RegisterPart {

    public static Part register() {
        Scanner scanner = new Scanner(System.in);

        String mark = PickEnums.pickMark();
        String model = PickEnums.pickModel();

        System.out.print(">>> Unesite ime dela : ");
        String name = scanner.nextLine();

        System.out.print(">>> Cena : ");
        double price = scanner.nextDouble();

        Random rand = new Random();
        int id = rand.nextInt(999999);

        Part part = new Part(mark,model,name,price,Integer.toString(id));
        part.setAvailable(true);
        return part;
    }
}
