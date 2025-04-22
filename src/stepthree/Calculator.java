package stepthree;

import exception.UserException;
import interfaces.ExceptionThrower;
import interfaces.MenuBtn;
import stepthree.enums.OperatorType;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Calculator<T extends Number> implements MenuBtn, ExceptionThrower {
    private final Class<T> type;
    private Scanner scanner;
    private final List<Double> calResultList = new ArrayList<>();
    private T num1;
    private T num2;

    public Calculator(Class<T> type, Scanner scanner) {
        this.type = type;
        this.scanner = scanner;
    }

    public double calculate(T a, T b, OperatorType op) {
        return op.calculate(a, b);
    }

    public void getOneResult() {
        CalHistory history = new CalHistory(calResultList);
        List<Double> resultList = history.getDistinctSortedResults();

        if (resultList.isEmpty()) {
            System.out.println("조건을 만족하는 결과가 없습니다.");
        } else {
            System.out.println("중복없는 정렬된 모든 결과 표시:");
            for (int i = 0; i < resultList.size(); i++) {
                System.out.println("[" + (i + 1) + "] : " + resultList.get(i));
            }
        }
    }

    public void getTwoResult() {
        System.out.print("기준이 되는 숫자를 입력하세요: ");
        int inputValue = Integer.parseInt(scanner.nextLine());

        CalHistory history = new CalHistory(calResultList);
        List<Double> resultList = history.getGreaterThan(inputValue);

        if (resultList.isEmpty()) {
            System.out.println("조건을 만족하는 결과가 없습니다.");
        } else {
            System.out.println("입력한 값보다 큰 결과 목록:");
            resultList.forEach(System.out::println);
        }
    }

    @Override
    public void run() {
        System.out.println("첫 번째 숫자를 입력하세요: ");
        num1 = parseNumber(scanner.nextLine());
        System.out.println("두 번째 숫자를 입력하세요: ");
        num2 = parseNumber(scanner.nextLine());
        System.out.println("사칙연산 기호를 입력하세요: ");
        String operator = scanner.nextLine();

        OperatorType op = OperatorType.expression(operator);
        double result = calculate(num1, num2, op);
        calResultList.add(result);

        System.out.println("결과: " + result);
    }
    @Override
    public void showCalMenu() {
        System.out.println("===============MENU===============");
        System.out.println("|  모든 값 중복 없이 정렬보기  [1] 입력  |");
        System.out.println("|  입력한 값보다 큰 결과 보기  [2] 입력  |");
        System.out.println("|  홈으로 이동            다른키 입력  |");
        System.out.println("==================================");
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
    @Override
    public boolean exitBtn() {
        try {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    getOneResult();
                    return true;
                case 2:
                    getTwoResult();
                    return true;
                default:
                    return false;
            }
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private T parseNumber(String input) {
        try {
            if (type == Integer.class) {
                try {
                    checkInteger(input);
                } catch (UserException.TypeException e) {
                    System.out.println(e.getMessage());
                    input = parseInteger(input);
                }
                return type.cast(Integer.parseInt(input));

            } else if (type == Double.class) {
                return type.cast(Double.parseDouble(input));
            }
            throw new UnsupportedOperationException("지원하지 않는 숫자 타입입니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }

}