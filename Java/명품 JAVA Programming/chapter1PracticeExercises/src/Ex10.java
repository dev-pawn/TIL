import java.util.Scanner;

// 원의 정보를 받기 위해 키보드로부터 원의 중심을 나타내는 한 점과 반지름을 입력받는다.
// 두 개의 원을 입력받고 두 원이 서로 겹치는지 판단하여 출력하라.
/*
첫번째 원의 중심과 반지름 입력>>10 10 3
두번째 원의 중심과 반지름 입력>>12 12 2
두 원은 서로 겹친다.
 */
public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫번째 원의 중심과 반지름 입력>>");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        double radius1 = scanner.nextDouble();
        System.out.println("두번째 원의 중심과 반지름 입력>>");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        double radius2 = scanner.nextDouble();
        if ((radius1 + radius2) >= Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2))) {
            System.out.println("두 원은 서로 겹친다.");
        } else {
            System.out.println("두 원은 서로 겹치지 않는다.");
        }
        scanner.close();
    }
}
