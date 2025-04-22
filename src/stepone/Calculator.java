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
        int num1;
        int num2;

        System.out.println("첫 번째 숫자를 입력하세요: ");
        String input1 = scanner.nextLine();
        try {
            checkInteger(input1);
        } catch (UserException.TypeException e) {
            System.out.println(e.getMessage());
            input1 = parseInteger(input1);
        } finally {
            num1 = Integer.parseInt(input1);                // scanner.nextInt()를 사용하는 경우 개행문자를 남겨
        }                                                   // 다음 scanner.nextLine()에 문제를 일으킴
        System.out.println("두 번째 숫자를 입력하세요: ");
        String input2 = scanner.nextLine();
        try {
            checkInteger(input2);
        } catch (UserException.TypeException e) {
            System.out.println(e.getMessage());
            input2 = parseInteger(input2);
        } finally {
            num2 = Integer.parseInt(input2);
        }
        System.out.println("사칙연산 기호를 입력하세요: ");
        String operator = scanner.nextLine();

        String result = calculate(num1, num2, operator.charAt(0));
        System.out.println("결과: " + result);
    }
    @Override
    public void showCalMenu() {
        System.out.println("==========MENU==========");
        System.out.println("|  홈으로 이동  다른키 입력  |");
        System.out.println("========================");
    }
    @Override
    public boolean exitBtn() {
        scanner.nextLine();
        return false;
    }
    @Override
    public void checknum2(int num) throws UserException.DivZeroException {
        if (num == 0) {
            throw new UserException.DivZeroException();
        }
    }
    @Override
    public void checkInteger(String num) throws UserException.TypeException {
        int index = num.indexOf(".");
        if (index != -1) {
            throw new UserException.TypeException();
        }
    }
    public String parseInteger(String num) {
        int index = num.indexOf(".");
        if (index != -1) {
            num = num.substring(0, index);
        }
        return num;
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
