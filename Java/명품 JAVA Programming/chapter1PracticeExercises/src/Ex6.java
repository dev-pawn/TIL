// 369게임을 간단히 작성해보자. 1~99까지의 정수를 입력받고 정수에 3, 6, 9 중 하나가 있는 경우는 "박수작"을 출력하고
// 두 개 있는 경우는 "박수짝짝"을 출력하는 프로그램을 작성하라.
// 예를 들면, 키보드로 입력된 수가 13인 경우 "박수짝"을, 36인 경우 "박수짝짝"을 출력하면 된다.
/*
1~99 사이의 정수를 입력하시오>>36
박수짝짝
 */

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1~99 사이의 정수를 입력하시오>>");
        int inputNum = scanner.nextInt();
        int tens = inputNum/10;
        int units = inputNum%10;
        int crapNum = 0;

        if ((tens == 3) || (tens == 6) || (tens == 9)) {
            crapNum += 1;
        }
        if ((units == 3) || (units == 6) || (units == 9)) {
            crapNum += 1;
        }

        if (crapNum == 2) {
            System.out.println("박수짝짝");
        } else if (crapNum == 1) {
            System.out.println("박수짝");
        } else {
            System.out.println("박수못쳐");
        }
        scanner.close();
    }
}
