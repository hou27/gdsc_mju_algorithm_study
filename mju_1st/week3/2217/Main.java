// import java.util.Scanner;

// public class Main {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int N = sc.nextInt();
//     int max = 0;

//     int[] rope = new int[N];
//     for (int i = 0; i < N; i++) {
//       rope[i] = sc.nextInt();
//       if (rope[i] > max) {
//         max = rope[i];
//       }
//     }
//     sc.close();

//     for (int i = 0; i < N; i++) {
//       int cur_max = check(rope, i);
//       if (cur_max > max) {
//         max = cur_max;
//       }
//     }

//     System.out.println(max);
//   }

//   static int check(int[] rope, int loc) {
//     int cur = rope[loc];
//     int weight = cur;
//     for (int i = 0; i < rope.length; i++) {
//       if (i != loc && rope[i] >= cur) {
//         weight += cur;
//       }
//     }

//     return weight;
//   }

// }

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int max = 0;

    Integer[] rope = new Integer[N];
    for (int i = 0; i < N; i++) {
      rope[i] = sc.nextInt();
    }
    sc.close();

    // Arrays.sort(rope, Collections.reverseOrder()); // 내림차순 정렬
    Arrays.sort(rope, (o1, o2) -> o2 - o1);

    for (int i = 0; i < N; i++) {
      int cur_max = rope[i] * (i + 1); // 현재 로프가 버틸 수 있는 중량을 기준으로 계산
      if (cur_max > max) {
        max = cur_max;
      }
    }

    System.out.println(max);
  }
}