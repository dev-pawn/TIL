import java.util.Scanner;

// 사칙 연산을 입력받아 계산하는 프로그램을 작성하고자 한다. 연산자는 +,-,+,/의 네가지로 하고 피 연산자는 모두 실수로 한다.
// 피연산자와 연산자는 실행 사례와 같이 빈 칸으로 분리하여 입력한다. 0으로 나누기 시 "0으로 나눌 수 없습니다."를 출력하고 종료한다.
/*
연산>> 2 + 4
2+4의 계산 결과는 6
 */
public class Ex12_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temp = 0;
        System.out.print("연산>>");
        int operand1 = scanner.nextInt();
        String operator = scanner.next();
        int operand2 = scanner.nextInt();

        if (operator.equals("+")) {
            System.out.println(operand1 + operator + operand2 + "의 계산 결과는 " + (operand1 + operand2));
        } else if (operator.equals("-")) {
            System.out.println(operand1 + operator + operand2 + "의 계산 결과는 " + (operand1 - operand2));
        } else if (operator.equals("*")) {
            System.out.println(operand1 + operator + operand2 + "의 계산 결과는 " + (operand1 * operand2));
        } else if (operator.equals("/")) {
            if (operand1 == 0 || operand2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
            } else {
                System.out.print(operand1 + operator +operand2 + "의 계산 결과는 ");
                if (operand2 > operand1) {
                    temp = operand1;
                    operand1 = operand2;
                    operand2 = temp;
                }
                System.out.println(operand1 / operand2);
            }
        } else {
            System.out.println(" ERROR : 잘못된 연산자 입력");
        }
        scanner.close();
    }
}
