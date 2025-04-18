package stepthree;

import exception.UserException;
import interfaces.ExceptionThrower;
import interfaces.MenuBtn;
import stepthree.enums.OperatorType;

import java.util.Scanner;

public class Calculator<T extends Number> implements MenuBtn, ExceptionThrower {
    private final Class<T> type;
    private Scanner scanner;
    private T num1;
    private T num2;

    public Calculator(Class<T> type, Scanner scanner) {
        this.type = type;
        this.scanner = scanner;
    }

    public double calculate(T a, T b, OperatorType op) {
        return op.calculate(a, b);
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

        System.out.println("결과: " + result);
    }
    @Override
    public void showCalMenu() {
        System.out.println("===============MENU===============");
        System.out.println("|  입력한 값보다 큰 결과 보기  [1] 입력  |");
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
    public boolean exitBtn() {
        try {
            if (Integer.parseInt(scanner.nextLine()) == 0) {
                return false;
            } else {
                return true;
            }
        }
        catch (NumberFormatException e) {
            return true;
        }
    }

    private T parseNumber(String input) {
        try {
            if (type == Integer.class) {
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