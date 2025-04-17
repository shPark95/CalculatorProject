import java.util.Scanner;

public class App {
    public static boolean runStepOneCalculator(Scanner scanner) {
        boolean value;
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

        showCalMenu();
        value = calc.exitBtn();
        return value;
    }

    public static boolean runStepTwoCalculator(Scanner scanner) {
        boolean value;
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

        showCalMenu();
        value = calc.exitBtn();
        return value;
    }

    public static boolean runStepThreeCalculator(Scanner scanner) {
        boolean value;
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

        showCalMenu();
        value = calc.exitBtn();
        return value;
    }

    public static void showCalMenu() {
        System.out.println("==========MENU==========");
        System.out.println("|  프로그램 종료  [0] 입력  |");
        System.out.println("|  홈으로 이동  다른키 입력  |");
        System.out.println("========================");
    }

}
