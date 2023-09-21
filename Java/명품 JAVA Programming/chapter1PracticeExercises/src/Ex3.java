import java.util.Scanner;

// Scanner 클래스를 이용하여 정수로 된 돈의 액수를 입력받아 오만 원권, 만 원권, 천 원권,
// 500원짜리 동전, 100원짜리 동전, 50원짜리 동전, 10원짜리 동전, 1원짜리 동전 각 몇 개로 변환되는지 출력하라.
/*
금액을 입력하시오>>655376
오만원권 1매
만원권 1매
천원권 5매
백원 3개
오십원 1개
십원 2개
일원 6개
 */
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("금액을 입력하시오>>");
        int amount = scanner.nextInt();
        int fiftyThousandWon = amount / 50000;
        int tenThousandWon = amount % 50000 / 10000;
        int oneThousandWon = amount % 10000 / 1000;
        int oneHundredWon = amount % 1000 / 100;
        int tenWon = amount % 100 / 10;
        int oneWon = amount % 10;
        if (fiftyThousandWon > 0) {
            System.out.println("오만원권 " + fiftyThousandWon + "매");
        }
        if (tenThousandWon > 0) {
            System.out.println("만원권 " + tenThousandWon + "매");
        }
        if (oneThousandWon > 0) {
            System.out.println("천원권 " + oneThousandWon + "매");
        }
        if (oneHundredWon > 0) {
            System.out.println("백원 " + oneHundredWon + "개");
        }
        if (tenWon > 0) {
            System.out.println("십원 " + tenWon + "개");
        }
        if (oneWon > 0) {
            System.out.println("일원 " + oneWon + "개");
        }
        scanner.close();
    }
}
