// 2차원 평면에서 직사각형은 문제 7번처럼 두 점으로 표현된다.
// 키보드로부터 직사각형을 구성하는 두 점 (x1, y1), (x2, y2)를 입력받아 (100, 100), (200, 200)의 두 점으로 이루어진 직사각형과 충돌하는지 판별하는 프로그램을 작성하라.
/*
힌트
다음은 점 (x,y)가 (rectx1, recty1), (rectx2, recty2)의 사각형 안에 있으면 true를 리턴하는 메소드이다. 이 메소드를 활용하라.
public static boolean inRect(int x, int y, int rectx1, int recty1, int rectx2, int recty2) {
    if ((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2))
        return true;
    else return false;
}
*/

import java.util.Scanner;

public class Ex8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("두 점의 좌표를 입력하시오 (공백으로 구분, x1,y1,x2,y2의 순서로 입력)>>");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if (inRect(x1, y1, 100, 100, 200, 200) || inRect(x2, y2, 100, 100, 200, 200)) {
            System.out.println("직사각형과 충돌합니다!");
        } else {
            System.out.println("직사각형과 충돌하지 않습니다!");
        }
        scanner.close();
    }

    public static boolean inRect(int x, int y, int rectx1, int recty1, int rectx2, int recty2) {
        if ((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2))
            return true;
        else return false;
    }
}
