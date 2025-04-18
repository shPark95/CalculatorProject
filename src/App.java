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
        System.out.println("|   [1] 입력시 정수형 계산기   |");
        System.out.println("|   [2] 입력시 실수형 계산기   |");
        System.out.println("==========================");

        stepthree.Calculator<? extends Number> calc = null;
        try {
            String typeInput = scanner.nextLine();
            if (typeInput.equals("1")) {
                calc = new stepthree.Calculator<>(Integer.class, scanner);
            } else if (typeInput.equals("2")) {
                calc = new stepthree.Calculator<>(Double.class, scanner);
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 선택입니다. 기본으로 정수형 계산기를 실행합니다.");
            calc = new stepthree.Calculator<>(Integer.class, scanner);
        }

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
