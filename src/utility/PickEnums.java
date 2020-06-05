package utility;

import java.util.Scanner;


public class PickEnums {
    private static final Scanner scanner = new Scanner(System.in);

    public static String pickMark() {
        String option = "";
        String m = "";

        while (!option.matches("[1-4]")) {
            System.out.println("\n1) Bmw");
            System.out.println("2) Lambo");
            System.out.println("3) Yugo");
            System.out.println("4) Opel");
            System.out.print(">>> Marka : ");
            option = scanner.nextLine();

            if (option.equals("1")) {
                m = mark.BMW.toString();
            } else if (option.equals("2")) {
                m = mark.LAMBO.toString();
            } else if (option.equals("3")) {
                m = mark.YUGO.toString();
            } else if (option.equals("4")) {
                m = mark.OPEL.toString();
            }
        }

        return m;
    }

    public static String pickModel() {
        String option = "";
        String m = "";

        while (!option.matches("[1-4]")) {
            System.out.println("\n1) Model 1");
            System.out.println("2) Model 2");
            System.out.println("3) Model 3");
            System.out.println("4) Model 4");
            System.out.print(">>> Model : ");
            option = scanner.nextLine();

            if (option.equals("1")) {
                m = model.ONE.toString();
            } else if (option.equals("2")) {
                m = model.TWO.toString();
            } else if (option.equals("3")) {
                m = model.THREE.toString();
            } else if (option.equals("4")) {
                m = model.FOUR.toString();
            }
        }

        return m;
    }

    public static String pickFuel() {
        String option = "";
        String f = "";

        while (!option.matches("[1-4]")) {
            System.out.println("\n1) Dizel");
            System.out.println("2) Elektricni pogon");
            System.out.println("3) Gas");
            System.out.print(">>> Gorivo : ");
            option = scanner.nextLine();

            if (option.equals("1")) {
                f = fuel.DIZEL.toString();
            } else if (option.equals("2")) {
                f = fuel.ELECTRIC.toString();
            } else if (option.equals("3")) {
                f = fuel.GAS.toString();
            }
        }

        return f;
    }

    public static String pickSpecialization() {
        String option = "";
        String s = "";

        while (!option.matches("[1-4]")) {
            System.out.println("\n1) Auto-mehanicar");
            System.out.println("2) Auto-elektricar");
            System.out.println("3) Vulkanizer");
            System.out.println("4) Limar");
            System.out.print(">>> Specijalizacija : ");
            option = scanner.nextLine();

            if (option.equals("1")) {
                s = specialization.AUTOMEHANICAR.toString();
            } else if (option.equals("2")) {
                s = specialization.AUTOELEKTRICAR.toString();
            } else if (option.equals("3")) {
                s = specialization.VULKANIZER.toString();
            } else if (option.equals("4")) {
                s = specialization.LIMAR.toString();
            }
        }

        return s;
    }

    public static String pickGender() {
        String option = "";
        String g = "";

        while (!option.matches("[1-4]")) {
            System.out.println("\n1) Muski");
            System.out.println("2) Zenski");
            System.out.print(">>> Pol : ");
            option = scanner.nextLine();

            if (option.equals("1")) {
                g = gender.MALE.toString();
            } else if (option.equals("2")) {
                g = gender.FEMALE.toString();
            }
        }

        return g;
    }

    public static String pickStatus() {
        String option = "";
        String s = "";

        while (!option.matches("[1-4]")) {
            System.out.println("\n1) Gotov");
            System.out.println("2) U toku");
            System.out.println("3) Nije poceo");
            System.out.print(">>> Status : ");
            option = scanner.nextLine();

            if (option.equals("1")) {
                s = status.FINISHED.toString();
            } else if (option.equals("2")) {
                s = status.NOTFINISHED.toString();
            } else if (option.equals("3")) {
                s = status.NOTSTARTED.toString();
            }
        }

        return s;
    }
}