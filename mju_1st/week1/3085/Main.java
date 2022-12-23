import java.util.Scanner;

public class Main {
  static int max = 1, N;
  static char[][] board;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); // 보드의 크기
    board = new char[N][N]; // 보드

    // 보드에 사탕 채우기
    for (int i = 0; i < N; i++) {
      String color = sc.next();
      for (int j = 0; j < N; j++) {
        board[i][j] = color.charAt(j);
      }
    }

    sc.close();

    // 브루트 포스
    bfs();

    System.out.println(max);
  }

  static void bfs() {
    // 가로 순회
    for (int i = 0; i < N; i++) { // 행
      for (int j = 0; j < N - 1; j++) { // 열
        if (board[i][j] != board[i][j + 1]) {
          swap(i, j, i, j + 1); // 이웃한 두 칸 교환
          count(); // 먹을 수 있는 사탕 최대 개수 카운트
          swap(i, j, i, j + 1); // 원상태로 복구
        }
      }
    }

    // 세로 순회
    for (int i = 0; i < N; i++) { // 행
      for (int j = 0; j < N - 1; j++) { // 열
        if (board[j][i] != board[j + 1][i]) {
          swap(j, i, j + 1, i);
          count();
          swap(j, i, j + 1, i);
        }
      }
    }
  }

  static void swap(int row1, int col1, int row2, int col2) {
    char tmp = board[row1][col1];
    board[row1][col1] = board[row2][col2];
    board[row2][col2] = tmp;
  }

  static void count() {
    int count = 1;

    // 세로 count
    for (int i = 0; i < N; i++) { // 행
      for (int j = 0; j < N - 1; j++) { // 열
        if (board[i][j] == board[i][j + 1]) { // 이웃한 두 칸이 같은 색이면
          count++; // count 증가
        } else {
          count = check(count); // 다른 색이면 count 초기화 및 max값 갱신
        }
      }
      count = check(count); // 마지막 열까지 검사한 후 count 초기화 및 max값 갱신
    }

    // 가로 count
    for (int i = 0; i < N; i++) { // 행
      for (int j = 0; j < N - 1; j++) { // 열
        if (board[j][i] == board[j + 1][i]) {
          count++;
        } else {
          count = check(count);
        }
      }
      count = check(count);
    }

  }

  static int check(int count) {
    if (count > max) {
      max = count;
    }
    count = 1;

    return count;
  }

}
