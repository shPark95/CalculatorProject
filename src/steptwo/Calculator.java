package steptwo;

import exception.UserException;
import interfaces.ExceptionThrower;
import interfaces.MenuBtn;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator implements MenuBtn, ExceptionThrower {
    private Scanner scanner;
    private ArrayList<Integer> results = new ArrayList<>();
    private int num1, num2;
    private char operator;

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.println("첫 번째 숫자를 입력하세요: ");
        setNum1(Integer.parseInt(scanner.nextLine()));
        System.out.println("두 번째 숫자를 입력하세요: ");
        setNum2(Integer.parseInt(scanner.nextLine()));
        System.out.println("사칙연산 기호를 입력하세요: ");
        String operator = scanner.nextLine();
        setOperator(operator);

        String result = calculate();
        System.out.println("결과: " + result);
    }
    @Override
    public void showCalMenu() {
        System.out.println("============MENU============");
        System.out.println("|  마지막 결과 지우기  [1] 입력  |");
        System.out.println("|  결과 모두 보기     [2] 입력  |");
        System.out.println("|  홈으로 이동      다른키 입력  |");
        System.out.println("============================");
    }
    @Override
    public boolean exitBtn() {
        try {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    removeResult();
                    return true;
                case 2:
                    printResult();
                    return true;
                default:
                    return false;
            }
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    @Override
    public void checknum2(int num) throws UserException.DivZeroException {
        if (num == 0) {
            throw new UserException.DivZeroException();
        }
    }

    public String calculate() {
        int result;
        try {
            switch (getOperator()) {
                case '+':
                    result = getNum1() + getNum2();
                    results.add(result);
                    return Integer.toString(result);
                case '-':
                    result = getNum1() - getNum2();
                    results.add(result);
                    return Integer.toString(result);
                case '*':
                    result = getNum1() * getNum2();
                    results.add(result);
                    return Integer.toString(result);
                case '/':
                    checknum2(getNum2());
                    result = getNum1() / getNum2();
                    results.add(result);
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

    public void removeResult() {
        results.remove(results.size() - 1);     // .remove(int index) 값이 없을 때 예외처리 추가 필요
    }

    public void printResult() {
        for (int i = 0; i < results.size(); i++) {
            System.out.println("[" + i + "]번째 결과 : " + results.get(i));
        }
    }

    int getNum1() { return num1; }
    void setNum1(int num1) {
        this.num1 = num1;
    }
    int getNum2() {
        return num2;
    }
    void setNum2(int num2) {
        this.num2 = num2;
    }
    char getOperator() {
        return operator;
    }
    void setOperator(String operator) {
        this.operator = operator.charAt(0);
    }
}
