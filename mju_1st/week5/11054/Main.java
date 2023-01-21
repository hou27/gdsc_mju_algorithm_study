import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 수열 A의 크기
    int[] A = new int[N]; // 수열 A

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    sc.close();

    int[] I = new int[N]; // 증가하는 부분 수열
    int[] D = new int[N]; // 감소하는 부분 수열
    int[] S = new int[N]; // 증가하는 부분 수열 + 감소하는 부분 수열 - 1

    for (int i = 0; i < N; i++) {
      I[i] = 1;
      D[i] = 1;
      S[i] = 1;
    }

    // 증가하는 부분 수열 계산
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (A[j] < A[i] && I[i] <= I[j]) {
          I[i] = I[j] + 1;
        }
      }
    }

    // 감소하는 부분 수열 계산
    for (int i = N - 2; i >= 0; i--) {
      for (int j = N - 1; j > i; j--) {
        if (A[j] < A[i] && D[i] <= D[j]) {
          D[i] = D[j] + 1;
        }
      }
    }

    // 증가하는 부분 수열 + 감소하는 부분 수열 - 1(바이토닉 수열 길이)
    for (int i = 0; i < N; i++) {
      S[i] = I[i] + D[i] - 1;
    }

    // 최대값 출력
    System.out.println(Arrays.stream(S).max().getAsInt());

  }

}
