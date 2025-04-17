package stepthree;

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

    }
    @Override
    public void showCalMenu() {
        System.out.println("==========MENU==========");
        System.out.println("|  프로그램 종료  [0] 입력  |");
        System.out.println("|  홈으로 이동  다른키 입력  |");
        System.out.println("========================");
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

    @Override
    public void checknum2(int num) throws UserException.DivZeroException {
        if (num == 0) {
            throw new UserException.DivZeroException();
        }
    }

}
