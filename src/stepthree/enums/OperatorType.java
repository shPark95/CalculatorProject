package stepthree.enums;

public enum OperatorType {
    ADD("+") {
        @Override
        public <T extends Number> double calculate(T a, T b) {
            return a.doubleValue() + b.doubleValue();
        }
    },
    SUB("-") {
        @Override
        public <T extends Number> double calculate(T a, T b) {
            return a.doubleValue() - b.doubleValue();
        }
    },
    MUL("*") {
        @Override
        public <T extends Number> double calculate(T a, T b) {
            return a.doubleValue() * b.doubleValue();
        }
    },
    DIV("/") {
        @Override
        public <T extends Number> double calculate(T a, T b) {
            if (b.doubleValue() == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a.doubleValue() / b.doubleValue();
        }
    };

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public abstract <T extends Number> double calculate(T a, T b);

    public static OperatorType expression(String operator) {
        for (OperatorType op : values()) {
            if (op.operator.equals(operator)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operator);
    }
}
