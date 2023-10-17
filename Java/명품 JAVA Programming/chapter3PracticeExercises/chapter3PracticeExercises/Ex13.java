/*
반복문을 이용하여 369게임에서 박수를 쳐야 하는 경우를 순서대로 화면에 출력해보자. 1부터 시작하며 99까지만 한다. 실행 사례는 다음과 같다.
3 박수 짝
6 박수 짝
9 박수 짝
13 박수 짝
16 박수 짝
19 박수 짝
23 박수 짝
26 박수 짝
29 박수 짝
30 박수 짝
31 박수 짝
32 박수 짝
33 박수 짝짝
34 박수 짝
35 박수 짝
36 박수 짝짝
37 박수 짝
..............
 */
public class Ex13 {
    public static void main(String[] args) {
        for (int i=1;i<100;i++) {
            int crapCount = 0;
            if (i/10 == 3 || i/10 == 6 || i/10 == 9)
                crapCount++;
            if (i%10 == 3 || i%10 == 6 || i%10 == 9)
                crapCount++;
            if (crapCount == 1) {
                System.out.println(i + " 박수 짝");
            } else if (crapCount == 2) {
                System.out.println(i + " 박수 짝짝");
            }
        }
    }
}
