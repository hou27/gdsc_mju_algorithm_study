import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static int[] cards;
  static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); // 상근이가 가지고 있는 숫자 카드 개수
    cards = new int[N]; // 상근이가 가지고 있는 숫자 카드
    for (int i = 0; i < N; i++) {
      cards[i] = sc.nextInt();
    }
    int M = sc.nextInt(); // 상근이가 가지고 있는지 구해야 하는 숫자 카드 개수
    int[] numbers = new int[M]; // 상근이가 가지고 있는지 구해야 하는 숫자 카드
    for (int i = 0; i < M; i++) {
      numbers[i] = sc.nextInt();
    }

    Arrays.sort(cards); // 오름차순 정렬

    for (int i : numbers) {
      System.out.print(finder(i) + " ");
    }

    sc.close();

  }

  // 이진 탐색
  static int finder(int n) {
    int left = 0, right = N - 1, idx = (N - 1) / 2;
    int flag = 0;
    while (left <= right) {
      idx = (left + right) / 2;
      if (cards[idx] > n) {
        right = idx - 1;
      } else if (cards[idx] == n) {
        flag = 1;
        break;
      } else {
        left = idx + 1;
      }
    }
    return flag;
  }
}