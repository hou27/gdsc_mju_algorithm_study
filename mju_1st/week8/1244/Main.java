import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // 스위치 개수
    int[] sw = new int[n + 1]; // 스위치 상태
    for (int i = 1; i <= n; i++) {
      sw[i] = sc.nextInt();
    }
    int studentCount = sc.nextInt(); // 학생 수
    for (int i = 0; i < studentCount; i++) {
      int gender = sc.nextInt(); // 성별
      int swIdx = sc.nextInt(); // 스위치 번호

      toggleSwitch(sw, gender, swIdx);
    }

    sc.close();

    // 출력은 한줄에 20개의 숫자까지만 출력하고 다음줄로 개행
    for (int i = 1; i <= n; i++) {
      System.out.print(sw[i] + " ");
      if (i % 20 == 0) {
        System.out.println();
      }
    }
  }

  // 스위치 상태를 변경하는 메소드
  static void toggleSwitch(int[] sw, int gender, int swIdx) {
    if (gender == 1) { // 남자인 경우
      for (int i = swIdx; i < sw.length; i += swIdx) {
        sw[i] = sw[i] == 0 ? 1 : 0;
      }
    } else if (gender == 2) { // 여자인 경우
      sw[swIdx] = sw[swIdx] == 0 ? 1 : 0;
      int left = swIdx - 1;
      int right = swIdx + 1;

      // 범위에 벗어나지 않는 동시에 좌우 대칭인 경우
      while (left >= 1 && right < sw.length && sw[left] == sw[right]) {
        sw[left] = sw[left] == 0 ? 1 : 0;
        sw[right] = sw[right] == 0 ? 1 : 0;
        left--;
        right++;
      }
    }
  }
}