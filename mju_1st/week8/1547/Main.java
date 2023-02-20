import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt(); // 컵을 바꾼 횟수
    int[] cups = { 1, 2, 3 }; // 컵의 위치 정보(인덱스가 컵 번호, 값이 컵의 위치)

    for (int i = 0; i < M; i++) {
      int X = sc.nextInt(); // 바꿀 컵
      int Y = sc.nextInt(); // 바꿀 컵

      // 컵의 위치를 바꾼다.
      int tmp = cups[X - 1];
      cups[X - 1] = cups[Y - 1];
      cups[Y - 1] = tmp;
    }

    sc.close();

    // 컵의 위치가 1인 컵의 번호를 출력한다.
    for (int i = 0; i < cups.length; i++) {
      if (cups[i] == 1) {
        System.out.println(i + 1);
        break;
      }
    }
  }
}
