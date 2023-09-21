import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /*Scanner 클래스로 이름, 도시, 나이, 체중, 독신 여부를 입력받고 다시 출력하는 프로그램을 작성하라*/
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String city = scanner.next();
        int age = scanner.nextInt();
        double weight = scanner.nextDouble();
        boolean isSingle = scanner.nextBoolean();

        System.out.println("이름 : " + name);
        System.out.println("도시 : " + city);
        System.out.println("나이 : " + age);
        System.out.println("체중 : " + weight);
        System.out.println("독신여부 : " + isSingle);
        scanner.close();
    }
}
