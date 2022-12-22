import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// public class Main {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int N = sc.nextInt(); // 총 사람 수
//     int K = sc.nextInt(); // 제거 간격
//     int len = 0; // 초기 순열 길이

//     sc.close();

//     int[] people = new int[N]; // 각 사람이 제거되었는지 여부를 저장할 배열

//     System.out.print("<"); // 순열 출력 시작
//     int loc = K - 1; // 현재 위치
//     int cnt = K; // 간격 카운트
//     for (;;) {
//       if (cnt == K) { // 제거 간격 도달 시 제거
//         cnt = 0; // 간격 카운트 초기화
//         people[loc] = 1; // 제거 표시
//         len++; // 순열 길이 증가
//         if (len == N) { // 순열 길이가 총 사람 수와 같아지면 종료
//           System.out.print(loc + 1); // 마지막 사람 출력
//           break;
//         } else { // 아니면 쉼표까지 출력 후 다음 반복으로
//           System.out.print(loc + 1 + ", ");
//         }
//       }
//       loc = (loc + 1) % N; // 원형 배열처럼 다음 위치로 이동
//       if (people[loc] == 0) // 제거되지 않은 사람일 때만 간격 카운트 증가
//         cnt++;
//     }
//     System.out.println(">"); // 순열 출력 종료
//   }

// }

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 총 사람 수
    int K = sc.nextInt(); // 제거 간격

    sc.close();

    List<Integer> people = new LinkedList<>(); // 제거되지 않은 사람들을 저장할 리스트
    Queue<Integer> result = new LinkedList<>(); // 제거된 사람들을 저장할 큐

    for (int i = 1; i <= N; i++) // 큐에 사람들을 저장
      people.add(i);

    while (!people.isEmpty()) {
      for (int i = 0; i < K - 1; i++) { // 제거 간격 만큼 반복
        people.add(people.remove(0)); // 맨 앞의 사람을 뒤로 이동
      }
      result.add(people.remove(0)); // 제거 간격 만큼 이동한 사람을 큐에 저장
    }
    System.out.print("<"); // 순열 출력 시작
    while (!result.isEmpty()) {
      if (result.size() == 1) { // 마지막 사람일 때는 쉼표 없이 출력
        System.out.print(result.remove());
      } else { // 아니면 쉼표까지 출력 후 다음 반복으로
        System.out.print(result.remove() + ", ");
      }
    }
    System.out.println(">"); // 순열 출력 종료
  }

}