package interfaces;

import exception.UserException.DivZeroException;

public interface ExceptionThrower {
    void checknum2(int num)  throws DivZeroException;
}
