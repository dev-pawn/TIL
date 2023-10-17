/*
4 x 4의 2차원의 배열을 만들고 이곳에 1에서 10까지 범위의 정수를 10개만 랜덤하게 생성하여 임의의 위치에 삽입하라.
동일한 정수가 있어도 상관없다. 나머지 6개의 숫자는 모두 0이다. 만들어진 2차원 배열을 화면에 출력하라.
 */
public class Ex10 {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                array[i][j] =0;
            }
        }
        int count = 0;
        while(count != 10) {
            int i = (int)(Math.random()*4);
            int j = (int)(Math.random()*4);
            if(array[i][j] == 0){
                array[i][j] = (int)(Math.random() * 10 + 1);
                count++;
            }
        }
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println("");
        }
    }
}
