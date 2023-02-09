import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    sc.close();

    int[] arr = new int[M];
    boolean[] visited = new boolean[N + 1];
    dfs(arr, visited, 0, N, M);
  }

  static void dfs(int[] arr, boolean[] visited, int depth, int N, int M) {
    if (depth == M) { // 수열 길이가 M이면 완성됐으므로 출력
      for (int i = 0; i < M; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }

    int start = depth - 1 >= 0 ? arr[depth - 1] : 1;

    // 매 자리(depth)마다 arr[start]부터 N까지의 수를 넣어보며 오름차순 수열 완성
    for (int i = start; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        dfs(arr, visited, depth + 1, N, M); // 다음 자리 수 채우러 이동
        visited[i] = false;
      }
    }
  }
}
