// import java.util.Scanner;

// public class Main {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int N = sc.nextInt(); // 수열 A의 크기
//     int[] A = new int[N]; // 수열 A
//     for (int i = 0; i < N; i++) {
//       A[i] = sc.nextInt();
//     }

//     sc.close();
//     int sequenceCnt = 1; // 증가하는 부분 수열의 길이
//     int max = A[0]; // 이전까지의 최대값

//     for (int i = 1; i < N; i++) {
//       if (max < A[i]) {
//         sequenceCnt++;
//         max = A[i];
//       }
//     }

//     System.out.println(sequenceCnt);
//   }

// }

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 수열 A의 크기
    int[] A = new int[N]; // 수열 A
    int[] D = new int[N]; // 증가하는 부분 수열

    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    sc.close();
    int sequenceCnt = 1; // 증가하는 부분 수열의 길이
    for (int i = 0; i < N; i++) {
      D[i] = 1;
    }

    for (int i = 1; i < N; i++) { // 2번째부터
      for (int j = 0; j < i; j++) { // 처음부터
        // 이전 값이 현재 값보다 작고, 이전 값의 증가하는 부분 수열의 길이가
        // 현재 값의 증가하는 부분 수열의 길이보다 크거나 같으면
        if (A[j] < A[i] && D[i] <= D[j]) {
          // 현재 위치에서 계산되는 수열의 길이를 j번째까지의 수열의 길이 + 1로 갱신
          D[i] = D[j] + 1;
        }
      }
      sequenceCnt = sequenceCnt < D[i] ? D[i] : sequenceCnt;
    }

    System.out.println(sequenceCnt);
  }

}
/*
 * 예제들
 * 6
 * 10 20 10 30 20 50
 * 4
 * 
 * 6
 * 2 3 4 5 6 1
 * 1 2 3 4 5 1
 * 5
 * 
 * 
 * 5
 * 10 50 10 20 30
 * 1 2 1 2 3
 * 3
 * 
 * 5
 * 50 10 30 20 40
 * 1 1 2 2 3
 * 3
 * 
 * 5
 * 10 50 30 10 20
 * 1 2 2 1 2
 * 2
 */