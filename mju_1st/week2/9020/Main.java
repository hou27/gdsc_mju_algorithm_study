import java.util.Scanner;

public class Main {
  static boolean[] isPrime = new boolean[10001];
  static int start = 2; // 소수 구할 때 중복 계산을 피하기 위한 변수

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    isPrime[1] = true;

    for (int i = 0; i < T; i++) {
      calculate_goldbach(sc.nextInt());
    }

    sc.close();

  }

  static void calculate_goldbach(int n) {
    for (int i = start; i < n; i++) { // n보다 작은 소수 구하기
      isPrime[i] = isPrime(i);
    }
    start = n + 1; // 다음 소수 구할 때 중복 계산을 피하기 위한 값 갱신

    int a = 0, b = 0;
    for (int i = 2; i <= n / 2; i++) {
      if (isPrime[i] && isPrime[n - i]) { // n = i + (n - i) 둘 다 소수인 경우
        a = i;
        b = n - i;
      }
    }

    System.out.println(a + " " + b);
  }

  static boolean isPrime(int n) { // 소수 판별용 메서드
    if (n < 2) {
      return false;
    }

    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}
