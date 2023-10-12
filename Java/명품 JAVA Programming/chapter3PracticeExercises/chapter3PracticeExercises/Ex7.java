import java.util.Scanner;

/*
정수를 10개 저장하는 배열을 만들 1에서 10까지의 범위의 정수를 랜덤하게 생성하여 배열에 저장하라.
그리고 배열에 든 숫자들과 평균을 출력하라.
랜덤한 정수들 : 10 5 2 9 1 4 1 5 1 5
평균은 4.3
 */
public class Ex7 {
    public static void main(String[] args) {
        int[] array = new int[10];
        double sum = 0;
        for (int i=0;i<10;i++) {
            int number = (int) (Math.random() * 10 + 1);
            array[i] = number;
        }
        System.out.print("랜덤한 정수들 :");
        for (int i=0;i<10;i++) {
            System.out.print(" " + array[i]);
            sum += array[i];
        }
        System.out.println("");
        System.out.println("평균은 " + sum/10);
    }
}
