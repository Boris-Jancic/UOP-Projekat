package register;

import utility.PickEnums;
import utility.WriteToFile;

import java.util.Random;
import java.util.Scanner;

public class RegisterPart {

    public void register(){
        Scanner scanner = new Scanner(System.in);
        PickEnums p = new PickEnums();
        WriteToFile writeToFile = new WriteToFile();

        String mark = p.pickMark();
        String model = p.pickModel();
        System.out.print(">>> Unesite ime dela : ");
        String name = scanner.nextLine();

        System.out.print(">>> Cena : ");
        Double price = scanner.nextDouble();


        Random rand = new Random();
        int id = rand.nextInt(999999);
        String newPart = mark + "|" + model + "|" + name + "|" + price + id;
        writeToFile.write(newPart, "src/data/parts.txt");
    }
}
