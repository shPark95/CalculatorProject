import java.util.Scanner;

public class App {
    public static void runStepOneCalculator(Scanner scanner) {
        System.out.println();
        System.out.println("==========================");
        System.out.println("|      1단계 계산기입니다     |");
        System.out.println("|                         |");
        System.out.println("==========================");

        stepone.Calculator calc = new stepone.Calculator(scanner);
        calc.run();
    }

    public static void runStepTwoCalculator(Scanner scanner) {
        System.out.println();
        System.out.println("==========================");
        System.out.println("|      2단계 계산기입니다     |");
        System.out.println("|                         |");
        System.out.println("==========================");

        steptwo.Calculator calc = new steptwo.Calculator(scanner);
        calc.run();
    }

    public static void runStepThreeCalculator(Scanner scanner) {
        System.out.println();
        System.out.println("==========================");
        System.out.println("|      3단계 계산기입니다     |");
        System.out.println("|                         |");
        System.out.println("==========================");

        stepthree.Calculator calc = new stepthree.Calculator(scanner);
        calc.run();
    }
}
