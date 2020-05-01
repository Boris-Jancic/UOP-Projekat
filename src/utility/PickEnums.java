package utility;

import java.util.Scanner;

public class PickEnums {
    Scanner scanner = new Scanner(System.in);

    public String pickMark(){
        int option2 = 0;
        System.out.println("\n1) Bmw");
        System.out.println("2) Lambo");
        System.out.println("3) Yugo");
        System.out.println("4) Opel");
        System.out.print(">>> Marka : ");
        option2 = scanner.nextInt();
        scanner.nextLine();

        mark m = null;

        if (option2 == 1)
            m = mark.BMW;
        if (option2 == 2)
            m = mark.LAMBO;
        if (option2 == 3)
            m = mark.YUGO;
        if (option2 == 4)
            m = mark.OPEL;

        return m.toString();
    }

    public String pickModel(){
        int option2 = 0;
        System.out.println("\n1) Model 1");
        System.out.println("2) Model 2");
        System.out.println("3) Model 3");
        System.out.println("4) Model 4");
        System.out.print(">>> Model : ");
        option2 = scanner.nextInt();
        scanner.nextLine();
        model m = null;

        if (option2 == 1)
            m = model.ONE;
        if (option2 == 2)
            m = model.TWO;
        if (option2 == 3)
            m = model.THREE;
        if (option2 == 4)
            m = model.FOUR;

        return m.toString();
    }

    public String pickFuel(){
        int option2 = 0;
        System.out.println("\n1) Dizel");
        System.out.println("2) Elektricni pogon");
        System.out.println("3) Gas");
        System.out.print(">>> Gorivo : ");
        option2 = scanner.nextInt();
        scanner.nextLine();
        fuel f = null;

        if (option2 == 1)
            f = fuel.DIZEL;
        if (option2 == 2)
            f = fuel.ELECTRIC;
        if (option2 == 3)
            f = fuel.GAS;

        return f.toString();
    }
}
