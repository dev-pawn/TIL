/*
다음과 같이 작동하는 Add.java를 작성하라. 명령행 인자 중에서 정수 만을 골라 합을 구하라.
다음 화면은 Add.class 파일을 c:\Temp 디렉터리에 복사한 뒤 실행한 경우이다.
C:\Temp>java Add 2 3 aa 5 6.5
10

C:\Temp>java Add Hell 3 4 4.3 c
7

C:\Temp>
 */

import java.util.InputMismatchException;

//문제 표시를 위해 Add.java 대신 Ex12로 작성함.
public class Ex12 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=0; i<args.length;i++){
            try {
                sum += Integer.parseInt(args[i]);
            }
            catch(NumberFormatException e) {
            }
        }
        System.out.println(sum);
    }
}
