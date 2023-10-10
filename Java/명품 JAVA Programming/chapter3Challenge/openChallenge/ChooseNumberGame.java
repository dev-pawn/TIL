import java.util.Scanner;
import java.util.Random;
//숨겨진 카드의 수를 맞추는 게임을 만들어보자. 0에서 99까지의 임의의 수를 가진 카드를 한 장 숨기고 이 카드의 수를 맞추는 게임이다.
//아래의 화면과 같이 카드 속의 수가 7인 경우를 보자. 수를 맞추는 시람이 55라고 입력하면 "더 높게", 다시 70을 입력하면 "더 높게"라는 식으로 범위를 좁혀가면서 수를 맞춘다.
//게임을 반복하기 위해 y/n을 묻고, n인 경우 종료된다.
/*
수를 결정하였습니다. 맞추어보세요.
0-99
1>>55
더 높게
55-99
2>>70
더 높게
70-99
3>>85
더 낮게
70-85
4>>77
맞았습니다.
다시하시겠습니까?(y/n)>>y
수를 결정하였습니다. 맞추어보세요.
 */

public class ChooseNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        while (true) {
            int randomNumber = r.nextInt(100);
            int numberTrials = 1;
            int low = 0;
            int top = 99;
            System.out.println(randomNumber);
            System.out.println("수를 결정하였습니다. 맞추어보세요.");
            while (true) {
                System.out.println(low + "-" + top);
                System.out.print(numberTrials + ">>");
                int playerChoose = scanner.nextInt();
                if (playerChoose < randomNumber) {
                    System.out.println("더 높게");
                    low = playerChoose;
                } else if (playerChoose > randomNumber) {
                    System.out.println("더 낮게");
                    top = playerChoose;
                } else {
                    System.out.println("맞았습니다.");
                    break;
                }
                numberTrials++;
            }
            System.out.println("다시하시겠습니까?(y/n)>>");
            String willYouContinue = scanner.next();
            if (willYouContinue.equals("n"))
                break;
        }
        System.out.println("게임이 종료되었습니다.");
    }
}
