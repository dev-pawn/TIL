import java.util.Scanner;

// 숫자를 입력받아 3~5는 "봄", 6~8은 "여름", 9~11은 "가을", 12,1,2의 경우 "겨울"을,
// 그 외 숫자를 입력한 경우 "잘못입력"을 출력하는 프로그램을 작성하라.
/*
달을 입력하세요(1~12)>>9
가을
 */
public class Ex11_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("달을 입력하세요(1~12)>>");
        int inputNum = scanner.nextInt();
        switch (inputNum) {
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            default:
                System.out.println("잘못입력");
        }
        scanner.close();
    }
}
