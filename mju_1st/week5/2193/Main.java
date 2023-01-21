// import java.util.Scanner;

// public class Main {
//   static int cnt = 0;

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int N = sc.nextInt(); // 자릿수

//     sc.close();

//     if (N < 3) {
//       System.out.println(1);
//       return;
//     }

//     int[] pinary_number = new int[N];

//     pinary_number[0] = 1;
//     pinary_number[1] = 0;

//     pinary(pinary_number, 2);

//     System.out.println(cnt);
//   }

//   static void pinary(int[] pinary_number, int idx) {
//     if (idx == pinary_number.length) {
//       cnt++;
//       return;
//     }

//     if (pinary_number[idx - 1] == 0) {
//       pinary_number[idx] = 1;
//       pinary(pinary_number, idx + 1);
//       pinary_number[idx] = 0;
//       pinary(pinary_number, idx + 1);
//     } else {
//       pinary_number[idx] = 0;
//       pinary(pinary_number, idx + 1);
//     }
//   }
// }
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 자릿수

    sc.close();

    if (N < 3) {
      System.out.println(1);
      return;
    }

    // N = 90인 경우 int 범위를 넘어가므로 long으로 선언
    long[] pinary_number = new long[N];

    pinary_number[0] = 1;
    pinary_number[1] = 1;

    // 피보나치 수열을 만족하는 이친수의 개수
    for (int i = 2; i < N; i++) {
      pinary_number[i] = pinary_number[i - 1] + pinary_number[i - 2];
    }

    System.out.println(pinary_number[N - 1]);
  }
}
