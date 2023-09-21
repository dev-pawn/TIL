// Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고,
// 십의 자리와 1의 자리가 같은지 판별하여 출력하는 프로그램을 작성하라.
/*
2자리수 정수 입력(10~99)>>77
Yes! 10의 자리와 1의 자리가 같습니다.
 */

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("2자리수 정수 입력(10~99)>>");
        int inputNumber = scanner.nextInt();
        if (inputNumber / 10 == inputNumber % 10) {
            System.out.print("Yes! 10의 자리와 1의 자리가 같습니다.");
        } else {
            System.out.print("No! 10의 자리와 1의 자리가 다릅니다!");
        }
        scanner.close();
    }
}
