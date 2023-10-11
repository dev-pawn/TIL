/*
다음 2차원 배열을 출력하는 프로그램을 작성하라.
int n [][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};
1
1 2 3
1
1 2 3 4
1 2
 */
public class Ex2 {
    public static void main(String[] args) {
        int n [][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};
        for(int i=0; i<n.length; i++) {
            for(int j=0; j<n[i].length; j++)
                System.out.print(n[i][j] + " ");
            System.out.println("");
        }
    }
}
