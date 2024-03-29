import java.util.Scanner;

/*
컴퓨터와 독자 사이의 가위 바위 보 게임을 만들어보자. 예시는 다음 그림과 같다. 독자부터 먼저 시작한다.
독자가 가위 바위 보 중 하나를 입력하고 <Enter>키를 치면, 프로그램은 가위 바위 보 중에서 랜덤하게 하나를 선택하고 컴퓨터가 낸 것으로 한다.
독자가 입력한 값과 랜덤하게 선택한 값을 비교하여 누가 이겼는지 판단한다.
독자가 가위 바위 보 대신 "그만"을 입력하면 게임을 끝낸다.
컴퓨터와 가위 바위 보 게임을 합니다.
가위 바위 보!>>바위
사용자 = 바위 , 컴퓨터 = 가위, 사용자가 이겼습니다.
가위 바위 보!>>가위
사용자 = 가위 , 컴퓨터 = 가위, 비겼습니다.
가위 바위 보!>>그만
게임을 종료합니다...
 */
public class Ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
        String[] choices = {"가위", "바위", "보"};
        while (true) {
            System.out.print("가위 바위 보!>>");
            String userChoice = scanner.next();
            String computerChoice = choices[(int)(Math.random()*3)];
            if (userChoice.equals("그만")) break;
            System.out.print("사용자 = " + userChoice + " , 컴퓨터 = " + computerChoice + ", ");
            if (userChoice.equals("가위")) {
                switch (computerChoice) {
                    case "가위":
                        System.out.println("비겼습니다.");
                        break;
                    case "바위":
                        System.out.println("컴퓨터가 이겼습니다.");
                        break;
                    case "보":
                        System.out.println("사용자가 이겼습니다.");
                }
            } else if (userChoice.equals("바위")) {
                switch (computerChoice) {
                    case "가위":
                        System.out.println("사용자가 이겼습니다.");
                        break;
                    case "바위":
                        System.out.println("비겼습니다.");
                        break;
                    case "보":
                        System.out.println("컴퓨터가 이겼습니다.");
                        break;
                }
            } else if (userChoice.equals("보")) {
                switch (computerChoice) {
                    case "가위":
                        System.out.println("컴퓨터가 이겼습니다.");
                        break;
                    case "바위":
                        System.out.println("사용자가 이겼습니다.");
                        break;
                    case "보":
                        System.out.println("비겼습니다.");
                        break;
                }
            }
        }
        System.out.println("게임을 종료합니다...");
        scanner.close();
    }
}
