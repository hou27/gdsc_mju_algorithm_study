// import java.util.ArrayList;
// import java.util.Scanner;

// public class Main {
//   static ArrayList<Integer> heap = new ArrayList<>();

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int N = sc.nextInt(); // 연산의 개수

//     for (int i = 0; i < N; i++) {
//       int x = sc.nextInt();
//       if (x == 0) {
//         // 배열에서 가장 작은 값을 출력하고 그 값을 제거
//         if (heap.size() == 0) {
//           System.out.println(0);
//         } else {
//           System.out.println(heap.get(0));

//           heap.remove(0);
//           buildHeap();
//         }
//       } else {
//         // 배열에 x라는 값을 넣는다.
//         insert(x);
//       }
//     }

//     sc.close();
//   }

//   static ArrayList<Integer> insert(int x) {
//     heap.add(x);
//     percolateUp(heap.size() - 1);

//     return null;
//   }

//   static void percolateUp(int i) {
//     int parent = (i - 1) / 2;
//     if (i > 0 && heap.get(i) < heap.get(parent)) {
//       int temp = heap.get(i);
//       heap.set(i, heap.get(parent));
//       heap.set(parent, temp);
//       percolateUp(parent);
//     }
//   }

//   static void percolateDown(int i) {
//     int child = i * 2 + 1, right = i * 2 + 2;
//     if (child < heap.size()) {
//       if (right < heap.size()) {
//         if (heap.get(child) > heap.get(right)) {
//           child = right;
//         }
//       }
//       if (heap.get(i) > heap.get(child)) {
//         int temp = heap.get(i);
//         heap.set(i, heap.get(child));
//         heap.set(child, temp);
//         percolateDown(child);
//       }
//     }
//   }

//   static void buildHeap() {
//     for (int i = (heap.size() - 2) / 2; i > -1; i--) {
//       percolateDown(i);
//     }
//   }
// }

// import java.util.Collections;
// import java.util.LinkedList;
// import java.util.Scanner;

// public class Main {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int N = sc.nextInt(); // 연산의 개수
//     // ArrayList<Integer> heap = new ArrayList<>();

//     LinkedList<Integer> heap = new LinkedList<Integer>();

//     for (int i = 0; i < N; i++) {
//       int x = sc.nextInt();
//       if (x == 0) {
//         // 배열에서 가장 작은 값을 출력하고 그 값을 제거
//         if (heap.size() == 0) {
//           System.out.println(0);
//         } else {
//           System.out.println(heap.remove(0));
//           Collections.sort(heap);
//         }
//       } else {
//         // 배열에 x라는 값을 넣는다.
//         heap.add(x);
//         Collections.sort(heap);
//       }
//     }

//     sc.close();
//   }
// }

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 연산의 개수

    // queue
    Queue<Integer> heap = new PriorityQueue<>(); // 오름차순으로 선언

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      if (x == 0) {
        // 우선순위 큐에서 가장 작은 값을 출력하고 그 값을 제거
        if (heap.size() == 0) {
          System.out.println(0);
        } else {
          System.out.println(heap.remove());
        }
      } else {
        // 우선순위 큐에 x라는 값을 넣는다.
        heap.add(x);
      }
    }

    sc.close();
  }
}