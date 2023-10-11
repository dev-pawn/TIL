import java.util.Scanner;

/*
Scanner를 이용해 정수를 입력받 다음과 같이 *을 출력하는 프로그램을 작성하라. 다음은 5를 입력받았을 경우이다.
정수를 입력하시오>>5
*****
****
***
**
*
 */
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하시오>>");
        int count = scanner.nextInt();
        for(int i=count;i>0;i--) {
            for (int j=i; j > 0; j--)
                System.out.print("*");
            System.out.println("");
        }
        scanner.close();
    }
}
