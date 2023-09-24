import java.util.Scanner;

// 원의 중심을 나타내는 한 점과 반지름을 실수 값으로 입력받아라.
// 그리고 실수 값으로 다른 점 (x, y)를 입력받아 이 점의 원의 내부에 있는지 판별하여 출력하라.
/*
원의 중심과 반지름 입력>> 10 10 6.5
점 입력>> 13 13
점 (13.0, 13.0)는 원 안에 있다.
*/
public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원의 중심과 반지름 입력>>");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        double radius = scanner.nextDouble();
        System.out.print("점 입력>>");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if (radius >= Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2))) {
            System.out.println("(" + x2 + ", " + y2 + ")" + "는 원 안에 있다.");
        } else {
            System.out.println("(" + x2 + ", " + y2 + ")" + "원의 내부가 아니다.");
        }
        scanner.close();
    }
}
