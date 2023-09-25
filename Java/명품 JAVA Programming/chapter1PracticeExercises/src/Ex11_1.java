import java.util.Scanner;

// 숫자를 입력받아 3~5는 "봄", 6~8은 "여름", 9~11은 "가을", 12,1,2의 경우 "겨울"을,
// 그 외 숫자를 입력한 경우 "잘못입력"을 출력하는 프로그램을 작성하라.
/*
달을 입력하세요(1~12)>>9
가을
 */
public class Ex11_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("달을 입력하세요(1~12)>>");
        int inputNum = scanner.nextInt();
        if ((inputNum == 12) || (inputNum == 1) || (inputNum == 2)) {
            System.out.println("겨울");
        } else if ((inputNum == 3) || (inputNum == 4) || (inputNum == 5)) {
            System.out.println("봄");
        } else if ((inputNum == 6) || (inputNum == 7) || (inputNum == 8)) {
            System.out.println("여름");
        } else if ((inputNum == 9) || (inputNum == 10) || (inputNum == 11)) {
            System.out.println("가을");
        } else {
            System.out.println("잘못입력");
        }
        scanner.close();
    }
}
