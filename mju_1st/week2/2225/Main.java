import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();

    sc.close();

    if (K == 1) {
      System.out.println(1);
    } else if (K == 2) {
      System.out.println(N + 1);
    } else {
      long[][] dp = new long[N + 1][K + 1];
      for (int i = 0; i <= N; i++) {
        dp[i][1] = 1;
      }
      for (int i = 0; i <= K; i++) {
        dp[0][i] = 1;
      }

      for (int i = 1; i <= N; i++) {
        for (int j = 2; j <= K; j++) {
          dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
        }
      }

      System.out.println(dp[N][K]);
    }
  }

}
