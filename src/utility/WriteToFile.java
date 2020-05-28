package utility;

import carModels.Car;
import carModels.CarBook;
import carModels.Part;
import carModels.Service;
import userModels.Admin;
import userModels.Client;
import userModels.Person;
import userModels.Worker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class WriteToFile {

    public static void write(String string, String fileP) {
        String oldCredentials = ReadFromFile.read(fileP);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileP));){
            writer.write(oldCredentials + string);

        } catch (IOException e) {
            System.out.println("Nema datog fajla !");
        }
    }


    public static void writeCars(ArrayList<Car> cars){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/cars.txt"))){

            for (Car car : cars) {
                if (car != null) {
                    writer.write(car.carToString() + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("! Dati fajl ne postoji !");
        }
    }


    public static void writeUsers(Set<Person> people){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/korisnici.txt"))){

            for (Person person : people) {
                if (person != null) {
                    if (person instanceof Client) {
                        writer.write("3" + "|" + person.personToString() + "|" + ((Client) person).getPoints() + "\n");
                    }

                    if (person instanceof Worker) {
                        writer.write("2" + "|" + person.personToString() + "|" + ((Worker) person).getSallary() + "|" + ((Worker) person).getSpecialization() + "\n");
                    }

                    if (person instanceof Admin) {
                        writer.write("1" + "|" + person.personToString() + "|" + ((Admin) person).getSallary() + "\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("! Dati fajl ne postoji !");
        }
    }


    public static void writeParts(ArrayList<Part> parts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/parts.txt"))) {

            for (Part part : parts) {
                if (part != null) {
                    writer.write(part.partToString() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("! Dati fajl ne postoji !");
        }
    }


    public static void writeService(ArrayList<Service> services) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/services.txt"))) {

            for (Service service : services) {
                if (service != null) {
                    writer.write(service.serviceToString() + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("! Dati fajl ne postoji !");
        }
    }

    public static void writeCarBook(ArrayList<CarBook> carBooks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/data/carbooks.txt"))) {

            for (CarBook carBook : carBooks) {
                if (carBook != null) {
                    writer.write(carBook.carBookToString() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("! Dati fajl ne postoji !");
        }
    }
}
