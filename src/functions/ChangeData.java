package functions;

import carModels.Car;
import carModels.Part;
import carModels.Service;
import userModels.*;
import utility.Checks;
import utility.PickEnums;

import java.util.*;

public class ChangeData {
    static Scanner scanner = new Scanner(System.in);

    public static Set<Person> changeUser(Set<Person> people) {
        System.out.print(">>> Unesi ID korisnika : ");
        String userID = scanner.nextLine();

        for (Person person : people) {
            if (person.getId().equals(userID)) {

                if (person instanceof Client) {
                    changeClient(person);
                } else if (person instanceof Worker) {
                    changeClient(person);
                } else if (person instanceof Admin) {
                    changeClient(person);
                }
            }
        }
        return people;
    }

    private static Person changeClient(Person person) {
        while (true) {
            System.out.println("\n1) Ime");
            System.out.println("2) Prezime");
            System.out.println("3) JMBG");
            System.out.println("4) Telefon");
            System.out.println("5) Korisnicko ime");
            System.out.println("6) Sifru");

            if (person instanceof Admin) {
                System.out.println("7) Plata");
            } else if (person instanceof Worker) {
                System.out.println("7) Plata");
                System.out.println("8) Specijalizacija");
            }

            System.out.println("\n0) Nazad u glavni meni");

            System.out.print("\n>>> Unesi opciju : ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print(">>> Unesi novo ime : ");
                    String newName = scanner.nextLine();
                    person.setName(newName);
                    break;

                case "2":
                    System.out.print(">>> Unesi novo prezime : ");
                    String newLastName = scanner.nextLine();
                    person.setLastName(newLastName);
                    break;

                case "3":
                    System.out.print(">>> Unesi novi JMBG : ");
                    String jmbg = scanner.nextLine();

                    if (jmbg.matches("[0-9]+") || jmbg.length() == 13) {
                        person.setJmbg(jmbg);
                    }
                    else {
                        System.out.println("!!! JMBG mora da ima 13 karaktera !!!");
                    }

                    break;

                case "4":
                    System.out.print(">>> Unesi novi telefon : ");
                    String phone = scanner.nextLine();
                    person.setPhone(phone);
                    break;

                case "5":
                    System.out.print(">>> Unesi novo korisnicko ime : ");
                    String newUsername = scanner.nextLine();
                    person.setUsername(newUsername);
                    break;

                case "6":
                    System.out.print(">>> Unesi novu sifru : ");
                    String newPassword = scanner.nextLine();
                    person.setPassword(newPassword);
                    break;

                case "7":
                    if (person instanceof Employe) {
                        System.out.print(">>> Unesi novu platu : ");
                        String newSalary = scanner.nextLine();

                        if (newSalary.matches("[0-9]+")) {
                            ((Employe) person).setSalary(Double.parseDouble(newSalary));
                        }
                    }
                    break;

                case "8":
                    if (person instanceof Worker) {
                        String specialization = PickEnums.pickSpecialization();
                        ((Worker) person).setSpecialization(specialization);
                    }
                    break;

                case "0":
                    return person;
            }
        }
    }


    public static ArrayList<Car> changeCar(ArrayList<Car> cars) {
        System.out.print(">>> Unesi ID automobila : ");
        String carID = scanner.nextLine();

        for (Car car : cars) {
            if (car.getCarID().equals(carID)) {
                changeCar(car);
            }
        }

        return cars;
    }

    private static Car changeCar(Car car) {
        while (true) {
            System.out.println("\n1) Model");
            System.out.println("2) Marka");
            System.out.println("3) Gorivo");
            System.out.println("4) Godiste");
            System.out.println("5) Zapremina Motora");
            System.out.println("6) Jacina Motora");

            System.out.println("\n0) Nazad u glavni meni");

            System.out.print("\n>>> Unesi opciju : ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    String mark = PickEnums.pickMark();
                    car.setMark(mark);
                    break;

                case "2":
                    String model = PickEnums.pickModel();
                    car.setModel(model);
                    break;

                case "3":
                    String fuel = PickEnums.pickFuel();
                    car.setMark(fuel);
                    break;

                case "4":
                    System.out.print("\n>>> Unesi godiste : ");

                    String date = scanner.nextLine();
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    if (!date.matches("[0-9]+") || date.length() != 4 || Integer.parseInt(date) > year) {  // Proverava da li je
                        System.out.println("!!! Pogresno uneseno godiste !!!");                               // godina validna
                        break;
                    }

                    car.setAge(date);
                    break;

                case "5":
                    System.out.print("\n>>> Unesi novu zapreminu motora : ");

                    if (scanner.hasNextFloat()) {
                        String engineVolume = scanner.nextLine();
                        car.setEngineVolume(Float.parseFloat(engineVolume));
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("!!! Unesite broj !!!");

                    break;

                case "6":
                    System.out.print("\n>>> Unesi novu jacinu motora : ");

                    if (scanner.hasNextInt()) {
                        String enginePower = scanner.nextLine();
                        car.setEnginePower(Integer.parseInt(enginePower));
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("!!! Unesite broj !!!");
                   break;

                case "0":
                    return car;
            }
        }
    }


    public static ArrayList<Part> changePart(ArrayList<Part> parts) {
        System.out.print(">>> Unesi ID dela : ");
        String partID = scanner.nextLine();

        for (Part part : parts) {
            if (part.getId().equals(partID)) {
                changePart(part);
            }
        }

        return parts;
    }

    private static Part changePart(Part part) {
        while (true) {
            System.out.println("\n1) Marka");
            System.out.println("2) Model");
            System.out.println("3) Ime");
            System.out.println("4) Cena");
            System.out.println("\n0) Nazad u glavni meni");

            System.out.print("\n>>> Unesi opciju : ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    String mark = PickEnums.pickMark();
                    part.setMark(mark);
                    break;

                case "2":
                    String model = PickEnums.pickModel();
                    part.setModel(model);
                    break;

                case "3":
                    System.out.print("\n>>> Unesi novo ime : ");
                    String name = scanner.nextLine();

                    if (!name.isEmpty()) {
                        part.setName(name);
                    }

                    break;

                case "4":
                    System.out.print("\n>>> Unesi novu cenu : ");
                    String price = scanner.nextLine();
                    part.setPrice(Double.parseDouble(price));
                    break;

                case "0":
                    return part;
            }
        }
    }


    public static ArrayList<Service> changeService(Set<Person> people, ArrayList<Service> services, ArrayList<Part> parts) {
        System.out.print(">>> Unesi ID servisa : ");
        String serviceID = scanner.nextLine();

        for (Service service : services) {
            if (service.getId().equals(serviceID)) {
                changeService(people, parts, service);
            }
        }

        return services;
    }

    private static Service changeService(Set<Person> people, ArrayList<Part> parts, Service service) {
        while (true) {
            System.out.println("\n1) Radnika");
            System.out.println("2) Datum");
            System.out.println("3) Opis");
            System.out.println("4) Delove");
            System.out.println("5) Status");
            System.out.println("\n0) Nazad u glavni meni");

            System.out.print("\n>>> Unesi opciju : ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("\n>>> Unesi ID radnika : ");
                    String workerID = scanner.nextLine();

                    Worker worker = Checks.findWorker(workerID, people);


                    if (worker != null) {
                        service.setWorker(worker);
                    }

                    break;

                case "2":
                    System.out.print("\n>>> Unesi nov datum servisa : ");
                    String dateStr = scanner.nextLine();
                    GregorianCalendar date = Checks.stringToDate(dateStr);

                    if (date != null) {
                        service.setReservation(date);
                    }
                    break;

                case "3":
                    System.out.print("\n>>> Unesi nov opis : ");
                    String description = scanner.nextLine();

                    if (!description.isEmpty()) {
                        service.setDescription(description);
                    }

                    break;

                case "4":
                    System.out.print("\n>>> Unesi novu delove(odvojeni zarezom => ID,ID) : ");
                    String usedParts = scanner.nextLine();

                    if (usedParts != null) {
                        service.setUsedParts(Checks.findParts(usedParts.split(","), parts));
                    }

                    break;

                case "5":
                    String status = PickEnums.pickStatus();
                    service.setStatus(status);
                    break;

                case "0":
                    return service;
            }
        }
    }
}