import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // 테스트 케이스의 개수
    for (int i = 0; i < T; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      // a^b를 계산 후 일의 자리 숫자를 구함
      int lastDigit = a;
      for (int j = 1; j < b; j++) {
        lastDigit = (lastDigit * a) % 10;
      }
      lastDigit = lastDigit % 10; // b가 1일 경우 a가 그대로 출력되는 것을 방지

      // 일의 자리 숫자가 0일 경우 10 출력
      if (lastDigit == 0) {
        System.out.println(10);
      } else {
        System.out.println(lastDigit);
      }
    }
    sc.close();
  }

}
