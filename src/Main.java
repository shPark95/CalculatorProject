import java.util.Scanner;

public class Main {
    private static boolean flag = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choiceCal = 0;

        while (getFlag()) {
            showMainMenu(scanner);
            choiceCal = Integer.parseInt(scanner.nextLine());
            choiceCalculator(choiceCal, scanner);
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
    }

    public static void choiceCalculator(int choiceCal, Scanner scanner) {
        switch (choiceCal) {
            case 0:
                setFlag(false);
                break;
            case 1:
                setFlag(App.runStepOneCalculator(scanner));
                break;
            case 2:
                setFlag(App.runStepTwoCalculator(scanner));
                break;
            case 3:
                setFlag(App.runStepThreeCalculator(scanner));
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
}