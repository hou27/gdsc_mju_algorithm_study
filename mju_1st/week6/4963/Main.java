import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int w, h;

    for (;;) {
      w = sc.nextInt(); // 너비
      h = sc.nextInt(); // 높이

      // 0 0이 입력되면 종료
      if (w == 0 && h == 0) {
        break;
      }

      // 지도 입력 받기
      int[][] map = new int[h][w];
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          map[i][j] = sc.nextInt();
        }
      }

      // 섬의 개수 계산
      int count = 0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1) {
            count++;
            bfs(map, i, j);
          }
        }
      }
      System.out.println(count);
    }

    sc.close();
  }

  static void bfs(int[][] map, int i, int j) {
    int h = map.length;
    int w = map[0].length;

    // 지도를 벗어나면 종료
    if (i < 0 || i >= h || j < 0 || j >= w) {
      return;
    }

    // 바다이면 종료
    if (map[i][j] == 0) {
      return;
    }

    // 방문한 곳은 0으로 바꿔서 방문 표시
    map[i][j] = 0;

    // 상하좌우대각선까지 전부 탐색
    bfs(map, i - 1, j);
    bfs(map, i + 1, j);
    bfs(map, i, j - 1);
    bfs(map, i, j + 1);
    bfs(map, i - 1, j - 1);
    bfs(map, i - 1, j + 1);
    bfs(map, i + 1, j - 1);
    bfs(map, i + 1, j + 1);
  }
}
