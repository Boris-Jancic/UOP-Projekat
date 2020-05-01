package register;

import utility.PickEnums;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class RegisterPart {

    public void register(){
        Scanner scanner = new Scanner(System.in);
        PickEnums p = new PickEnums();

        String mark = p.pickMark();
        String model = p.pickModel();
        System.out.print(">>> Unesite ime dela : ");
        String name = scanner.nextLine();

        System.out.print(">>> Cena : ");
        Double price = scanner.nextDouble();

        register(mark,model,name,price);
    }

    private void register(String mark, String model, String name, Double price){
        try {
            Random rand = new Random();
            int id = rand.nextInt(999999);

            String output = mark + "|" + model + "|" + name + "|" + price + "|" + id;

            File file = new File("src/data/parts.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String oldlines = new String();
            while((line = reader.readLine()) != null ){
                oldlines += line + "\n";
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(oldlines + output);
            writer.close();
        } catch (IOException e) {
            System.out.println("Dati fajl ne postoji !");
        }
    }
}
