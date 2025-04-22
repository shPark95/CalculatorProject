package interfaces;

import exception.UserException.DivZeroException;
import exception.UserException.TypeException;

public interface ExceptionThrower {
    void checknum2(int num)  throws DivZeroException;
    void checkInteger(String num)  throws TypeException;
}
