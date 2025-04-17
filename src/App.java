import java.util.Scanner;

public class App {
    public static void runStepOneCalculator(Scanner scanner) {
        String answer;

        System.out.println();
        System.out.println("==========================");
        System.out.println("|      1단계 계산기입니다     |");
        System.out.println("|                         |");
        System.out.println("==========================");

        stepone.Calculator calc = new stepone.Calculator(scanner);
        do {
            calc.run();
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            answer = scanner.nextLine();
        } while (!answer.equals("exit"));

        do {
            calc.showCalMenu();
        } while (calc.exitBtn());
    }

    public static void runStepTwoCalculator(Scanner scanner) {
        String answer;

        System.out.println();
        System.out.println("==========================");
        System.out.println("|      2단계 계산기입니다     |");
        System.out.println("|                         |");
        System.out.println("==========================");

        steptwo.Calculator calc = new steptwo.Calculator(scanner);
        do {
            calc.run();
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            answer = scanner.nextLine();
        } while (!answer.equals("exit"));

        do {
            calc.showCalMenu();
        } while (calc.exitBtn());
    }

    public static void runStepThreeCalculator(Scanner scanner) {
        String answer;

        System.out.println();
        System.out.println("==========================");
        System.out.println("|      3단계 계산기입니다     |");
        System.out.println("|                         |");
        System.out.println("==========================");

        stepthree.Calculator calc = new stepthree.Calculator(scanner);
        do {
            calc.run();
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            answer = scanner.nextLine();
        } while (!answer.equals("exit"));

        do {
            calc.showCalMenu();
        } while (calc.exitBtn());
    }

}
