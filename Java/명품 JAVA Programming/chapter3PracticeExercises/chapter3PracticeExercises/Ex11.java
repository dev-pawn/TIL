/*
다음과 같이 작동하는 Average.java를 작성하라. 명령행 인자는 모두 정수만 사용되며 정수들의 평균을 출력한다.
다음 화면은 컴파일된 Average.class 파일을 c:\Temp 디렉토리에 복사한 뒤 실행한 경우이다.

c:\Temp>java Average 2 3 4
3
c:\Temp>
 */

//문제 표시를 위해 Average.java 대신 Ex11로 작성함.
public class Ex11 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=0; i<args.length;i++) {
            sum += Integer.parseInt(args[i]);
        }
        System.out.println(sum/args.length);
    }
}
