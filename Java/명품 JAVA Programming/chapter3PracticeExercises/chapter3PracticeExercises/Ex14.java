import java.util.Scanner;

/*
다음 코드와 같이 과목과 점수가 짝을 이루도록 2개의 배열을 작성하라.
String course [] = { "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
int score [] = {95, 88, 76, 62, 55};
그리고 다음 예시와 같이 과목 이름을 입력받아 점수를 출력하는 프로그램을 작성하라. "그만"을 입력받으면 종료한다.
과목 이름>>Jaba
없는 과목입니다.
과목 이름>>Java
Java의 점수는 95
과목 이름>>안드로이드
안드로이드의 점수는 55
과목 이름>>그만
 */
public class Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String course [] = { "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
        int score [] = {95, 88, 76, 62, 55};
        String inputText = "";
        while (true) {
            System.out.print("과목 이름>>");
            inputText = scanner.next();
            int i;
            for (i=0;i<course.length;i++) {
                if (course[i].equals(inputText)) {
                    System.out.println(course[i] + "의 점수는 " + score[i]);
                    break;
                }
            }
            if (inputText.equals("그만"))
                break;
            if (i == course.length) {
                System.out.println("없는 과목입니다.");
            }

        }
        scanner.close();
    }
}
