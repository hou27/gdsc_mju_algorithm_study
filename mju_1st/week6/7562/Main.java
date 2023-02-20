// import java.util.Scanner;

// public class Main {
//   static int x2, y2;
//   static int min = -1;

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int T = sc.nextInt(); // 테스트 케이스의 개수
//     for (int i = 0; i < T; i++) {
//       int l = sc.nextInt(); // 체스판 한 변의 길이
//       int[][] board = new int[l][l]; // 체스판

//       // 나이트의 현재 위치
//       int x1 = sc.nextInt();
//       int y1 = sc.nextInt();

//       // 나이트가 이동하려고 하는 위치
//       x2 = sc.nextInt();
//       y2 = sc.nextInt();
//       board[x2][y2] = -1;

//       // 나이트가 이동하려고 하는 위치까지의 최소 이동 횟수
//       move(board, x1, y1, 0);

//       System.out.println(min);
//       min = -1;
//     }

//     sc.close();
//   }

//   static void move(int[][] board, int x1, int y1, int cnt) {
//     if (x1 < 0 || x1 >= board.length || y1 < 0 || y1 >= board.length) {
//       return;
//     }

//     // 나이트가 이동하려고 하는 위치에 도착했으면 종료
//     if (board[x1][y1] == -1) {
//       if (min == -1 || min > cnt) {
//         min = cnt;
//       }
//       return;
//     } else if (board[x1][y1] == -2) { // 이미 방문한 곳
//       return;
//     }

//     board[x1][y1] = -2;

//     cnt++;

//     // 나이트가 이동할 수 있는 8가지 방향
//     if (x1 > x2) {
//       if (y1 > y2) {
//         move(board, x1 - 2, y1 - 1, cnt); // 좌2 하1
//         move(board, x1 - 1, y1 - 2, cnt); // 좌1 하2
//       } else {
//         move(board, x1 - 2, y1 + 1, cnt); // 좌2 상1
//         move(board, x1 - 1, y1 + 2, cnt); // 좌1 상2
//       }
//     } else if (x1 < x2) {
//       if (y1 > y2) {
//         move(board, x1 + 1, y1 - 2, cnt); // 우1 하2
//         move(board, x1 + 2, y1 - 1, cnt); // 우2 하1
//       } else {
//         move(board, x1 + 1, y1 + 2, cnt); // 우1 상2
//         move(board, x1 + 2, y1 + 1, cnt); // 우2 상1
//       }
//     } else if (x1 == x2) {
//       move(board, x1 - 1, y1 - 2, cnt); // 좌1 하2
//       move(board, x1 - 1, y1 + 2, cnt); // 좌1 상2
//       move(board, x1 - 2, y1 - 1, cnt); // 좌2 하1
//       move(board, x1 - 2, y1 + 1, cnt); // 좌2 상1
//       move(board, x1 + 1, y1 - 2, cnt); // 우1 하2
//       move(board, x1 + 1, y1 + 2, cnt); // 우1 상2
//       move(board, x1 + 2, y1 - 1, cnt); // 우2 하1
//       move(board, x1 + 2, y1 + 1, cnt); // 우2 상1
//     }

//     return;
//   }
// }

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static int x2, y2;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // 테스트 케이스의 개수
    for (int i = 0; i < T; i++) {
      int l = sc.nextInt(); // 체스판 한 변의 길이
      int[][] board = new int[l][l]; // 체스판

      // 나이트의 현재 위치
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();

      // 나이트가 이동하려고 하는 위치
      x2 = sc.nextInt();
      y2 = sc.nextInt();

      System.out.println(bfs(board, x1, y1));
    }

    sc.close();
  }

  static int bfs(int[][] board, int x1, int y1) {
    // 탐색할 위치들을 저장할 큐
    Queue<Integer[]> queue = new LinkedList<Integer[]>();
    queue.add(new Integer[] { x1, y1, 0 });
    board[x1][y1] = -2; // 시작 위치 방문 표시

    int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

    // 큐가 빌 때까지 반복
    while (!queue.isEmpty()) {
      Integer[] pos = queue.poll();
      x1 = pos[0];
      y1 = pos[1];
      int currCnt = pos[2];

      // 나이트가 이동하려고 하는 위치에 도착했으면 종료
      if (x1 == x2 && y1 == y2) {
        return currCnt;
      }

      // board[x1][y1] = -2; // 방문한 곳은 -2로 표시

      // 너비 우선 탐색
      for (int i = 0; i < 8; i++) {
        int x = x1 + dx[i];
        int y = y1 + dy[i];

        // 체스판을 벗어나는 경우
        if (x < 0 || x >= board.length || y < 0 || y >= board.length) {
          continue;
        }
        if (!(board[x][y] == -2)) { // 이미 방문한 곳이 아니면
          board[x][y] = -2; // 방문한 곳은 -2로 표시
          queue.add(new Integer[] { x, y, currCnt + 1 }); // 큐에 삽입
        }
      }
    }

    return -1;
  }
}