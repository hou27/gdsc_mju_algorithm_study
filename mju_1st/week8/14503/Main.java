import java.util.Scanner;

public class Main {
  // 로봇 청소기
  static class RobotVacuum {
    // 로봇 청소기의 좌표 r : 세로, c : 가로
    int r;
    int c;
    // 로봇 청소기가 바라보는 방향 d
    int d; // 0:북, 1:동, 2:남, 3:서
    // 로봇 청소기가 청소한 칸의 수
    int cleaned = 0;

    // 로봇 청소기 초기화
    public RobotVacuum(int r, int c, int d) {
      this.r = r;
      this.c = c;
      this.d = d;
    }

    // 스캔
    public boolean scan(int[][] room, int N, int M) {
      int[] drs = { -1, 0, 1, 0 };
      int[] dcs = { 0, 1, 0, -1 };
      int curD = (this.d + 3) % 4;
      for (int i = 0; i < 4; i++) {
        // 탐색할 좌표 설정
        int dr = r + drs[curD];
        int dc = c + dcs[curD];
        // 조건 확인
        if (dr >= 0 && dc >= 0 && dr < N && dc < M && room[dr][dc] == 0) {
          this.d = curD;
          return true;
        }
        curD = (curD + 3) % 4;
      }
      return false;
    }

    // 한 칸 전진
    public void goForward() {
      switch (this.d) {
        case 0:
          this.r--;
          break;
        case 1:
          this.c++;
          break;
        case 2:
          this.r++;
          break;
        case 3:
          this.c--;
          break;
      }
    }

    // 후진
    public void goBack() {
      switch (this.d) {
        case 0:
          this.r++;
          break;
        case 1:
          this.c--;
          break;
        case 2:
          this.r--;
          break;
        case 3:
          this.c++;
          break;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 방의 크기 N : 세로, M : 가로
    int N = sc.nextInt();
    int M = sc.nextInt();

    // 로봇 청소기의 좌표 r : 세로, c : 가로
    // 로봇 청소기가 바라보는 방향 d
    RobotVacuum robotVacuum = new RobotVacuum(sc.nextInt(), sc.nextInt(), sc.nextInt());

    // 방의 청소 상태
    int[][] room = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        room[i][j] = sc.nextInt();
      }
    }

    sc.close();

    while (robotVacuum.r >= 0 && robotVacuum.r < N &&
        robotVacuum.c >= 0 && robotVacuum.c < M && room[robotVacuum.r][robotVacuum.c] != 1) {
      // 현재 위치를 청소
      if (room[robotVacuum.r][robotVacuum.c] == 0) {
        room[robotVacuum.r][robotVacuum.c] = 2;
        robotVacuum.cleaned++;
      }

      if (robotVacuum.scan(room, N, M)) { // 청소되지 않은 빈칸이 있는 경우
        robotVacuum.goForward();
      } else { // 청소되지 않은 빈칸이 없는 경우
        robotVacuum.goBack();
      }
    }

    System.out.println(robotVacuum.cleaned);
  }
}
