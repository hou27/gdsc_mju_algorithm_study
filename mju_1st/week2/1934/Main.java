import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      System.out.println(lcm(sc.nextInt(), sc.nextInt()));
    }

    sc.close();
  }

  /**
   * 최소공배수
   * 
   * @param a
   * @param b
   * @return a와 b의 최소공배수
   */
  static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

  /**
   * 최대공약수
   * 
   * @param a
   * @param b
   * @return a와 b의 최대공약수
   */
  static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}