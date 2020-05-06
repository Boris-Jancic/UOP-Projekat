package main;

import carModels.Part;
import utility.ReadFromFile;

import java.util.ArrayList;

public class LoadParts {
    public ArrayList<Part> load(){
        ReadFromFile readFromFile = new ReadFromFile();
        String[] parts = readFromFile.read("src/data/parts.txt").split("\n");
        ArrayList<Part> partsReturn = new ArrayList<>();

        for (String part : parts){
            String[] partSplit = part.split("\\|");
            String mark = partSplit[0];
            String model = partSplit[1];
            String name = partSplit[2];
            Double price = Double.parseDouble(partSplit[3]);
            String id = partSplit[4];

            Part p = new Part(mark, model, name, price);
            p.setId(id);
            partsReturn.add(p);
        }

        return partsReturn;
    }
}
