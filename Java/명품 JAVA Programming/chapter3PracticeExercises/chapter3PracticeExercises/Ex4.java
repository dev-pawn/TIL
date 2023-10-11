import java.util.Scanner;

/*
Scanner를 이용하여 소문자 알파벳을 하나 입력받고 다음과 같이 출력하는 프로그램을 작성하라. 다음은 e를 입력받았을 경우이다.
소문자 알파벳 하나를 입력하시오>>e
abcde
abcd
abc
ab
a
 */
public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("소문자 알파벳 하나를 입력하시오>>");
        String s = scanner.next();
        char alph = s.charAt(0);
        for (int i=0; i<=alph - 'a'; i++) {
            for (char j = 'a'; j <= alph - i; j++)
                System.out.print(j);
            System.out.println();
        }
        scanner.close();
    }
}
