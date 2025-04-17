package stepone;

import exception.UserException;
import interfaces.ExceptionThrower;
import interfaces.MenuBtn;

import java.util.Scanner;

public class Calculator implements MenuBtn, ExceptionThrower {
    private Scanner scanner;

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.println("첫 번째 숫자를 입력하세요: ");
        int num1 = Integer.parseInt(scanner.nextLine());        // scanner.nextInt()를 사용하는 경우 개행문자를 남겨
        System.out.println("두 번째 숫자를 입력하세요: ");            // 다음 scanner.nextLine()에 문제를 일으킴
        int num2 = Integer.parseInt(scanner.nextLine());
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

    @Override
    public void checknum2(int num) throws UserException.DivZeroException {
        if (num == 0) {
            throw new UserException.DivZeroException();
        }
    }

    public String calculate(int num1, int num2, char operator) {
        int result;
        try {
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
                    checknum2(num2);
                    result = num1 / num2;
                    return Integer.toString(result);
                default:
                    return "잘못된 연산자입니다.";
            }
        }
        catch (UserException.DivZeroException e) {
            return e.getMessage();
        }
        catch (Exception e) {
            return "계산실패";
        }
    }

}
