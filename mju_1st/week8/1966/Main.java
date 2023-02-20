import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // 테스트 케이스 개수

    for (int i = 0; i < T; i++) {
      int N = sc.nextInt(); // 문서 개수
      int M = sc.nextInt(); // 몇 번째로 인쇄되었는지 궁금한 문서가 큐에 놓여있는 위치(0부터 시작)
      // int[] importance = new int[N]; // 문서의 중요도를 나타내는 배열
      Queue<Integer> importance = new LinkedList<>(); // 문서의 중요도를 나타내는 큐
      for (int j = 0; j < N; j++) {
        importance.add(sc.nextInt()); // 중요도 입력
      }

      System.out.println(print(importance, M));
    }

    sc.close();

  }

  static int print(Queue<Integer> importance, int M) {
    int count = 0;
    int max = Collections.max(importance); // 중요도 최대값
    Queue<Boolean> goalInfo = new LinkedList<>(); // 목표 문서 위치 정보 큐

    // 목표 문서 위치 정보 큐에 정보 입력
    for (int i = 0; i < importance.size(); i++) {
      if (i == M) {
        goalInfo.add(true);
      } else {
        goalInfo.add(false);
      }
    }

    for (;;) {
      int tmp = importance.poll();
      boolean goal = goalInfo.poll();
      if (tmp == max) { // 중요도가 최대값이면
        count++; // 인쇄
        if (goal) { // 목표 문서면
          return count; // 인쇄 횟수 반환
        }
        max = Collections.max(importance); // max값 갱신
      } else {
        // 중요도가 최대값이 아니면 맨 뒤로 보냄
        importance.add(tmp);
        goalInfo.add(goal);
      }
    }
  }

}
