import java.util.Scanner;

public class Main {
    private static boolean flag = true;
    private static int typeCal = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (getFlag()) {
            showMainMenu(scanner);
            choiceCalculator(scanner);
        }
        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }

    public static void showMainMenu(Scanner scanner) {
        System.out.println("계산기 모드를 선택하세요:");
        System.out.println("========CALCULATOR========");
        System.out.println("| 숫자 [1] 입력 : 1단계 계산기 |");
        System.out.println("| 숫자 [2] 입력 : 2단계 계산기 |");
        System.out.println("| 숫자 [3] 입력 : 3단계 계산기 |");
        System.out.println("==========================");
        System.out.println("프로그램 종료시 [0] 입력");

        try {
            setTypeCal(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            setTypeCal(0);
        }
    }

    public static void choiceCalculator(Scanner scanner) {
        switch (getTypeCal()) {
            case 0:
                setFlag(false);
                break;
            case 1:
                App.runStepOneCalculator(scanner);
                break;
            case 2:
                App.runStepTwoCalculator(scanner);
                break;
            case 3:
                App.runStepThreeCalculator(scanner);
                break;
            default:
                break;
        }
    }

    public static boolean getFlag() {
        return flag;
    }
    public static void setFlag(boolean value) {
        flag = value;
    }
    public static int getTypeCal() {
        return typeCal;
    }
    public static void setTypeCal(int value) {
        typeCal = value;
    }
}