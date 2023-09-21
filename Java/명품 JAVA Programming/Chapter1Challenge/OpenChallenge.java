import java.util.Scanner;

/*
두 사람이 하는 가위바위보 게임을 만들어보자.
두 사람의 이름은 '철수'와 '영희'이다. 먼저 "철수 >>"를 출력하고 "가위", "바위", "보" 중 하나를 문자열로 입력받는다.
그리고 "영희 >>"를 출력하고 마찬가지로 입력받는다.
입력받은 문자열을 비교하여 누가 이겼는지 판별하여 승자를 출력한다.
*/
public class OpenChallenge {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
    System.out.print("철수 >>");
    String chulsoo = scanner.next();
    System.out.print("영희 >>");
    String yeonghui = scanner.next();

    if (chulsoo.equals("보")) {
        if (yeonghui.equals("보"))
            System.out.println("비겼습니다!");
        else if (yeonghui.equals("가위"))
            System.out.println("영희가 이겼습니다.");
        else if (yeonghui.equals("바위"))
            System.out.println("철수가 이겼습니다.");
        else
            System.out.println("ERR: 잘못된 입력값 (영희)");
    } else if (chulsoo.equals("가위")) {
        if (yeonghui.equals("보"))
            System.out.println("철수가 이겼습니다.");
        else if (yeonghui.equals("가위"))
            System.out.println("비겼습니다!");
        else if (yeonghui.equals("바위"))
            System.out.println("영희가 이겼습니다.");
        else
            System.out.println("ERR: 잘못된 입력값 (영희)");
    } else if (chulsoo.equals("바위")) {
        if (yeonghui.equals("보"))
            System.out.println("영희가 이겼습니다.");
        else if (yeonghui.equals("가위"))
            System.out.println("철수가 이겼습니다.");
        else if (yeonghui.equals("바위"))
            System.out.println("비겼습니다!");
        else
            System.out.println("ERR: 잘못된 입력값 (영희)");
    } else
        System.out.println("ERR: 잘못된 입력값 (철수)");
        scanner.close();

    }
}
