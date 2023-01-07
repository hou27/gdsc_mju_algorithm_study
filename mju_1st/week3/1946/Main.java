// import java.util.Scanner;

// public class Main {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int T = sc.nextInt();

//     for (int i = 0; i < T; i++) {
//       int N = sc.nextInt();
//       int[][] rank = new int[N][2];
//       for (int j = 0; j < N; j++) {
//         rank[j][0] = sc.nextInt(); // 서류심사 성적 순위
//         rank[j][1] = sc.nextInt(); // 면접심사 성적 순위
//       }

//       // 서류심사 성적 순위 기준 오름차순 정렬
//       for (int j = 0; j < N - 1; j++) {
//         for (int k = j + 1; k < N; k++) {
//           if (rank[j][0] > rank[k][0]) {
//             int tmp = rank[j][0];
//             rank[j][0] = rank[k][0];
//             rank[k][0] = tmp;
//             tmp = rank[j][1];
//             rank[j][1] = rank[k][1];
//             rank[k][1] = tmp;
//           }
//         }
//       }

//       int cnt = 1; // 서류 점수가 가장 높은 사람은 무조건 카운트
//       int top_interview_rate = rank[0][1]; // 현재까지 가장 높은 순위의 면접 성적
//       for (int j = 1; j < N; j++) {
//         if (rank[j][1] < top_interview_rate) { // 서류 점수는 더 낮지만 면접 성적이 더 높은 경우 카운트
//           top_interview_rate = rank[j][1]; // 카운트와 동시에 가장 높은 순위의 면접 성적 갱신
//           cnt++;
//         }
//       }
//       System.out.println(cnt);
//     }

//     sc.close();

//   }

// }

// import java.util.Arrays;
// import java.util.Scanner;

// public class Main {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int T = sc.nextInt();

//     for (int i = 0; i < T; i++) {
//       int N = sc.nextInt();
//       int[][] rank = new int[N][2];
//       for (int j = 0; j < N; j++) {
//         rank[j][0] = sc.nextInt(); // 서류심사 성적 순위
//         rank[j][1] = sc.nextInt(); // 면접심사 성적 순위
//       }

//       // 서류심사 성적 순위 기준 오름차순 정렬
//       Arrays.sort(rank, (a, b) -> a[0] - b[0]);

//       int cnt = 1; // 서류 점수가 가장 높은 사람은 무조건 카운트
//       int top_interview_rate = rank[0][1]; // 현재까지 가장 높은 순위의 면접 성적
//       for (int j = 1; j < N; j++) {
//         if (rank[j][1] < top_interview_rate) { // 서류 점수는 더 낮지만 면접 성적이 더 높은 경우 카운트
//           top_interview_rate = rank[j][1]; // 카운트와 동시에 가장 높은 순위의 면접 성적 갱신
//           cnt++;
//         }
//       }
//       System.out.println(cnt);
//     }

//     sc.close();

//   }

// }

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.Scanner;

// public class Main {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int T = sc.nextInt();

//     for (int i = 0; i < T; i++) {
//       int N = sc.nextInt();
//       ArrayList<int[][]> rank = new ArrayList<>();
//       for (int j = 0; j < N; j++) {
//         rank.add(new int[][] { { sc.nextInt() }, { sc.nextInt() } });
//       }

//       // 서류심사 성적 순위 기준 오름차순 정렬
//       Collections.sort(rank, new Comparator<int[][]>() {
//         @Override
//         public int compare(int[][] o1, int[][] o2) {
//           return o1[0][0] - o2[0][0];
//         }
//       });

//       int cnt = 1; // 서류 점수가 가장 높은 사람은 무조건 카운트
//       int top_interview_rate = rank.get(0)[1][0]; // 현재까지 가장 높은 순위의 면접 성적
//       for (int j = 1; j < N; j++) {
//         if (rank.get(j)[1][0] < top_interview_rate) { // 서류 점수는 더 낮지만 면접 성적이 더 높은 경우 카운트
//           top_interview_rate = rank.get(j)[1][0]; // 카운트와 동시에 가장 높은 순위의 면접 성적 갱신
//           cnt++;
//         }
//       }
//       System.out.println(cnt);
//     }

//     sc.close();

//   }

// }

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      ArrayList<int[]> rank = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        rank.add(new int[] { sc.nextInt(), sc.nextInt() });
      }

      // 서류심사 성적 순위 기준 오름차순 정렬
      // Collections.sort(rank, new Comparator<int[]>() {
      // @Override
      // public int compare(int[] o1, int[] o2) {
      // return o1[0] - o2[0];
      // }
      // });
      Collections.sort(rank, (o1, o2) -> o1[0] - o2[0]);

      int cnt = 1; // 서류 점수가 가장 높은 사람은 무조건 카운트
      int top_interview_rate = rank.get(0)[1]; // 현재까지 가장 높은 순위의 면접 성적
      for (int j = 1; j < N; j++) {
        if (rank.get(j)[1] < top_interview_rate) { // 서류 점수는 더 낮지만 면접 성적이 더 높은 경우 카운트
          top_interview_rate = rank.get(j)[1]; // 카운트와 동시에 가장 높은 순위의 면접 성적 갱신
          cnt++;
        }
      }
      System.out.println(cnt);
    }

    sc.close();

  }

}