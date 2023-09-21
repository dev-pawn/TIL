import java.util.Scanner;

// Scanner 클래스로 정수 3개를 입력하고 3개의 숫자 중 중간 크기의 수를 출력하라.
// 평균값을 구하는 것이 아님에 주의하라.
/*
정수 3개 입력>>20 100 33
중간 값은 33
 */
public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 3개 입력>>");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();
        int middleValue;
        if ((firstNumber >= secondNumber && firstNumber <= thirdNumber) || (firstNumber >= thirdNumber && firstNumber <= secondNumber)) {
            middleValue = firstNumber;
        } else if ((secondNumber >= firstNumber && secondNumber <= thirdNumber) || (secondNumber >= thirdNumber && secondNumber <= firstNumber)) {
            middleValue = secondNumber;
        } else {
            middleValue = thirdNumber;
        }
        System.out.print("중간 값은 " + middleValue);
        scanner.close();
    }
}
