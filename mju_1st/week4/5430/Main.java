// import java.util.LinkedList;
// import java.util.Scanner;

// public class Main {
//   static LinkedList<String> list = new LinkedList<String>();
//   static boolean errFlag = false;

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int T = sc.nextInt(); // 테스트 케이스의 개수
//     String[] arr = null;

//     for (int i = 0; i < T; i++) {
//       String p = sc.next(); // 수행할 함수
//       int n = sc.nextInt(); // 배열에 들어있는 수의 개수
//       String arrString = sc.next(); // 배열 문자열

//       // 배열로 만들기
//       if (n == 0) {
//         errFlag = true;
//       } else {
//         arrString = arrString.substring(1, arrString.length() - 1);
//         arr = arrString.split(",");

//         for (int j = 0; j < arr.length; j++) {
//           list.add(arr[j]);
//         }

//         for (int j = 0; j < p.length(); j++) {
//           if (errFlag) {
//             break;
//           }
//           if (p.charAt(j) == 'R') {
//             R();
//           } else if (p.charAt(j) == 'D') {
//             D();
//           }
//         }
//       }

//       if (errFlag) {
//         System.out.println("error");
//         errFlag = !errFlag;
//       } else {
//         printArr();
//       }
//       list.clear();
//     }
//     sc.close();
//   }

//   // 배열에 있는 수의 순서를 뒤집는 함수
//   static void R() {
//     for (int i = 0; i < list.size() / 2; i++) {
//       String tmp = list.get(i);
//       list.set(i, list.get(list.size() - 1 - i));
//       list.set(list.size() - 1 - i, tmp);
//     }
//   }

//   // 배열의 첫 번째 수를 버리는 함수
//   static void D() {
//     if (list.size() == 0) {
//       errFlag = true;
//       return;
//     }
//     list.remove(0);
//   }

//   // 배열 포맷으로 출력
//   static void printArr() {
//     System.out.print("[");
//     for (int i = 0; i < list.size() - 1; i++) {
//       System.out.print(list.get(i));
//       System.out.print(",");
//     }
//     System.out.print(list.get(list.size() - 1));
//     System.out.println("]");
//   }
// }

// import java.util.LinkedList;
// import java.util.Scanner;

// public class Main {
//   static LinkedList<String> list = new LinkedList<String>();
//   static boolean errFlag = false;
//   static int n;

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int T = sc.nextInt(); // 테스트 케이스의 개수
//     String[] arr = null;

//     for (int i = 0; i < T; i++) {
//       String p = sc.next(); // 수행할 함수
//       n = sc.nextInt(); // 배열에 들어있는 수의 개수
//       String arrString = sc.next(); // 배열 문자열

//       // 배열로 만들기
//       if (n == 0 && p.contains("D")) {
//         errFlag = true;
//       } else if (n == 0) {
//         System.out.println("[]");
//         continue;
//       } else {
//         arrString = arrString.substring(1, arrString.length() - 1);
//         arr = arrString.split(",");

//         for (int j = 0; j < arr.length; j++) {
//           list.add(arr[j]);
//         }

//         for (int j = 0; j < p.length(); j++) {
//           if (errFlag) {
//             break;
//           }
//           if (p.charAt(j) == 'R') {
//             R();
//           } else if (p.charAt(j) == 'D') {
//             D();
//           }
//         }
//       }

//       if (errFlag) {
//         System.out.println("error");
//         errFlag = !errFlag;
//       } else {
//         printArr();
//       }
//       list.clear();
//     }
//     sc.close();
//   }

//   // 배열에 있는 수의 순서를 뒤집는 함수
//   static void R() {
//     for (int i = 0; i < list.size() / 2; i++) {
//       String tmp = list.get(i);
//       list.set(i, list.get(list.size() - 1 - i));
//       list.set(list.size() - 1 - i, tmp);
//     }
//   }

//   // 배열의 첫 번째 수를 버리는 함수
//   static void D() {
//     if (list.size() == 0) {
//       errFlag = true;
//       return;
//     }
//     list.remove(0);
//   }

//   // 배열 포맷으로 출력
//   static void printArr() {
//     System.out.print("[");
//     if (list.size() != 0) {
//       for (int i = 0; i < list.size() - 1; i++) {
//         System.out.print(list.get(i));
//         System.out.print(",");
//       }
//       System.out.print(list.get(list.size() - 1));
//     }
//     System.out.println("]");
//   }
// }

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  static Deque<String> deque = new LinkedList<String>();
  static boolean errFlag = false, tailFirst = false;
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // 테스트 케이스의 개수
    String[] arr = null;

    for (int i = 0; i < T; i++) {
      String p = sc.next(); // 수행할 함수
      n = sc.nextInt(); // 배열에 들어있는 수의 개수
      String arrString = sc.next(); // 배열 문자열

      // 배열로 만들기
      if (n == 0 && p.contains("D")) {
        System.out.println("error");
        continue;
      } else if (n == 0) {
        System.out.println("[]");
        continue;
      } else {
        arrString = arrString.substring(1, arrString.length() - 1);
        arr = arrString.split(",");

        for (int j = 0; j < arr.length; j++) {
          deque.add(arr[j]);
        }

        for (int j = 0; j < p.length(); j++) {
          if (errFlag) {
            break;
          }
          if (p.charAt(j) == 'R') {
            R();
          } else if (p.charAt(j) == 'D') {
            D();
          }
        }
      }

      if (errFlag) {
        System.out.println("error");
        errFlag = !errFlag;
      } else {
        printArr();
      }
      tailFirst = false;
    }
    sc.close();
  }

  // 배열에 있는 수의 순서를 뒤집는 함수
  static void R() {
    tailFirst = !tailFirst;
  }

  // 배열의 첫 번째 수를 버리는 함수
  static void D() {
    if (deque.isEmpty()) {
      errFlag = true;
      return;
    }
    if (tailFirst) {
      deque.removeLast();
    } else {
      deque.removeFirst();
    }
  }

  // 배열 포맷으로 출력
  static void printArr() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    if (!deque.isEmpty()) {
      if (tailFirst) {
        while (deque.size() > 1) {
          sb.append(deque.removeLast() + ",");
        }
        sb.append(deque.removeLast());
      } else {
        while (deque.size() > 1) {
          sb.append(deque.removeFirst() + ",");
        }
        sb.append(deque.removeFirst());
      }
    }
    sb.append("]\n");
    System.out.print(sb);
  }
}