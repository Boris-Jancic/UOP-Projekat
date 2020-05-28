package main;

import carModels.Part;
import utility.ReadFromFile;

import java.util.ArrayList;

public class LoadParts {
    public static ArrayList<Part> load() {
        String[] parts = ReadFromFile.read("src/data/parts.txt").split("\n");
        ArrayList<Part> partsReturn = new ArrayList<>();

        for (String part : parts) {
            if(!part.isEmpty()) {
                String[] partSplit = part.split("\\|");
                String mark = partSplit[0];
                String model = partSplit[1];
                String name = partSplit[2];
                double price = Double.parseDouble(partSplit[3]);
                String id = partSplit[4];

                Part p = new Part(mark, model, name, price, id);
                partsReturn.add(p);
            }
        }

        return partsReturn;
    }
}
