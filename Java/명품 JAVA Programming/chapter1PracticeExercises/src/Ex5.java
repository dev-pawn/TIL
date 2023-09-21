// Scanner를 이용하여 삼각형의 변의 길이를 나타내는 정수를 3개 입력받고 이 3개의 수로 삼각형을 만들 수 있는지 판별하라.
// 삼각형이 되려면 두 변의 합이 다른 한 변의 합보다 커야 한다.
/*
정수 3개를 입력하시오>>4 3 5
삼각형이 됩니다.
 */

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 3개를 입력하시오>>");
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();

        if (((firstNum + secondNum) > thirdNum) && ((secondNum + thirdNum) > firstNum) && ((firstNum + thirdNum) > secondNum)) {
            System.out.print("삼각형이 됩니다.");
        } else {
            System.out.print("삼각형이 아닙니다.");
        }

        scanner.close();
    }
}
