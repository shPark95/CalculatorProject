package exception;

public class UserException {
    public static class DivZeroException extends Exception {
        public DivZeroException() {
            super("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
    }

    public static class TypeException extends Exception {
        public TypeException() {
            super("정수 연산에서 소수점 이하의 값은 제외됩니다.");
        }
    }
}
