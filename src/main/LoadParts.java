package main;

import carModels.Part;

import java.io.*;

public class LoadParts {
    public void load(){
        try {
            File file = new File("src/data/parts.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while((line = reader.readLine()) != null){
                String [] partSplit = line.split("\\|");
                String mark = partSplit[0];
                String model = partSplit[1];
                String name = partSplit[2];
                Double price = Double.parseDouble(partSplit[3]);
                String id = partSplit[4];

                Part p = new Part(mark, model, name, price);
                p.setId(id);
                System.out.println(p.toString());
            }

        } catch (IOException e){
            System.out.println("Nema datog fajla !");
        }
    }
}
