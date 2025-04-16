package stepone;

import interfaces.MenuBtn;

import java.util.Scanner;

public class Calculator implements MenuBtn {
    private Scanner scanner;

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.println("첫 번째 숫자를 입력하세요: ");
        int num1 = scanner.nextInt();
        System.out.println("두 번째 숫자를 입력하세요: ");
        int num2 = scanner.nextInt();
        System.out.println("사칙연산 기호를 입력하세요: ");
        String operator = scanner.nextLine();

        String result = calculate(num1, num2, operator.charAt(0));
        System.out.println("결과: " + result);

        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        String answer = scanner.nextLine();

        if (answer.equals("exit")) {
            exitBtn();
        }
    }
    @Override
    public void exitBtn() {

    }
    @Override
    public void changeCalculator() {

    }

    public String calculate(int num1, int num2, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                return Integer.toString(result);
            case '-':
                result = num1 - num2;
                return Integer.toString(result);
            case '*':
                result = num1 * num2;
                return Integer.toString(result);
            case '/':
                result = num1 / num2;
                return Integer.toString(result);
            default:
                return "잘못된 연산자입니다.";
        }
    }

}
