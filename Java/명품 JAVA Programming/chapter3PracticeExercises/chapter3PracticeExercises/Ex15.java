/*
다음은 2개의 정수를 입력 받아 곱을 구하는 Multiply 클래스이다.
import java.util.Scanner;
public class Multiply {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("곱하고자하는 두 수 입력>>");
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    System.out.print(n + "x" + m + "=" + n*m);
    scanner.close();
    }
}
다음과 같이 실행할 때 프로그램은 10과 5를 곱해 50을 잘 출력한다.
곱하고자 하는 두 수 입력>>10 5
10x5=50
하지만, 다음과 같이 실수를 입력하였을 때, 예외가 발생한다.
곱하고자 하는 두 수 입력>>2.5 4
Exception in thread "main" java.util.InputMismatchException
    at java.util.Scanner.throwFor(Unknown Source)
    at java.util.Scanner.next(Unknown Source)
    at java.util.Scanner.nextInt(Unknown Source)
    at java.util.Scanner.nextInt(Unknown Source)
    at Multiply.main(Multiply.java:6)  //라인 6에서 예외 발생

다음과 같이 실수가 입력되면 정수를 다시 입력하도록 하여 예외 없이 정상적으로 처리되도록 예외 처리 코드를 삽입하여 Multiply 클래스를 수정하라.
곱하고자 하는 두 수 입력>>2.5 4
실수는 입력하면 안됩니다.
곱하고자 하는 두 수 입력>>4 3.5
실수는 입력하면 안됩니다.
곱하고자 하는 두 수 입력>>4 3
4x3=12
 */

import java.util.InputMismatchException;
import java.util.Scanner;

//문제 표시를 위해 Multiply 대신 Ex15로 작성함.
public class Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("곱하고자하는 두 수 입력>>");
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                System.out.print(n + "x" + m + "=" + n*m);
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("실수는 입력하면 안됩니다.");
                scanner.nextLine();
                continue;
            }
        }
        scanner.close();
    }
}
