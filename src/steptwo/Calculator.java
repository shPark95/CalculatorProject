package steptwo;

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
