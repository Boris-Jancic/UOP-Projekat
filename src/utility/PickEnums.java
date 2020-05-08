package utility;

import java.util.Scanner;

public class PickEnums {
    final Scanner scanner = new Scanner(System.in);

    public String pickMark() {
        System.out.println("\n1) Bmw");
        System.out.println("2) Lambo");
        System.out.println("3) Yugo");
        System.out.println("4) Opel");
        System.out.print(">>> Marka : ");
        String option = scanner.nextLine();

        String m = "";

        if (option.equals("1")) {
            m = mark.BMW.toString();
        }
        if (option.equals("2")) {
            m = mark.LAMBO.toString();
        }
        if (option.equals("3")) {
            m = mark.YUGO.toString();
        }
        if (option.equals("4")) {
            m = mark.OPEL.toString();
        }

        return m;
    }

    public String pickModel() {
        System.out.println("\n1) Model 1");
        System.out.println("2) Model 2");
        System.out.println("3) Model 3");
        System.out.println("4) Model 4");
        System.out.print(">>> Model : ");
        String option = scanner.nextLine();

        String m = "";

        if (option.equals("1")) {
            m = model.ONE.toString();
        }
        if (option.equals("2")) {
            m = model.TWO.toString();
        }
        if (option.equals("3")) {
            m = model.THREE.toString();
        }
        if (option.equals("4")) {
            m = model.FOUR.toString();
        }

        return m;
    }

    public String pickFuel() {
        System.out.println("\n1) Dizel");
        System.out.println("2) Elektricni pogon");
        System.out.println("3) Gas");
        System.out.print(">>> Gorivo : ");
        String option = scanner.nextLine();

        String f = "";

        if (option.equals("1")) {
            f = fuel.DIZEL.toString();
        }
        if (option.equals("2")) {
            f = fuel.ELECTRIC.toString();
        }
        if (option.equals("3")) {
            f = fuel.GAS.toString();
        }

        return f;
    }

    public String pickSpecialization() {
        System.out.println("\n1) Auto-mehanicar");
        System.out.println("2) Auto-elektricar");
        System.out.println("3) Vulkanizer");
        System.out.println("4) Limar");
        System.out.print(">>> Specijalizacija : ");
        String option = scanner.nextLine();

        String s = "";

        if (option.equals("1")) {
            s = specialization.AUTOMEHANICAR.toString();
        }
        if (option.equals("2")) {
            s = specialization.AUTOELEKTRICAR.toString();
        }
        if (option.equals("3")) {
            s = specialization.VULKANIZER.toString();
        }
        if (option.equals("4")) {
            s = specialization.LIMAR.toString();
        }

        return s;
    }

    public String pickGender() {
        System.out.println("\n1) Muski");
        System.out.println("2) Zenski");
        System.out.print(">>> Pol : ");
        String option = scanner.nextLine();

        String g = "";

        if (option.equals("1")) {
            g = gender.MALE.toString();
        }
        if (option.equals("2")) {
            g = gender.FEMALE.toString();
        }

        return g;
    }

    public String pickStatus() {
        System.out.println("\n1) Gotov");
        System.out.println("2) U toku");
        System.out.println("3) Nije poceo");
        System.out.print(">>> Status : ");
        String option = scanner.nextLine();

        String s = "";

        if (option.equals("1")) {
            s = status.FINISHED.toString();
        }
        if (option.equals("2")) {
            s = status.NOTFINISHED.toString();
        }
        if (option.equals("3")) {
            s = status.NOTSTARTED.toString();
        }

        return s;
    }
}