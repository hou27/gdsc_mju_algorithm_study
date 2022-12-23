import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // Test case 개수

    for (int i = 0; i < T; i++) { // 각각의 Test case에 대해 작업
      int k = sc.nextInt(); // 층
      int n = sc.nextInt(); // 호수
      int[] floor0 = new int[n]; // 각 층의 각 호수에 사는 사람 수를 저장할 배열

      for (int j = 0; j < n; j++) { // 0층의 각 호수에 사는 사람 수 초기화
        floor0[j] = j + 1;
      }

      for (int j = 0; j < k; j++) { // 1층부터 k층까지 계산
        for (int l = 1; l < n; l++) {
          floor0[l] += floor0[l - 1]; // k층 n호에 사는 사람 수 = k층 n-1호에 사는 사람 수 + k-1층 n호에 사는 사람 수
        }
      }

      System.out.println(floor0[n - 1]); // k층 n호에 사는 사람 수 출력
    }

    sc.close();
  }
}