import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static int cnt = 0, N;
  static Node[] nodes;

  static class Node {
    ArrayList<Integer> neighbors;

    Node() {
      this.neighbors = new ArrayList<>();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); // 컴퓨터 수
    int cntOfPairs = sc.nextInt();
    nodes = new Node[N + 1];

    for (int i = 1; i < N + 1; i++) {
      nodes[i] = new Node();
    }

    // 연결 정보 입력받기
    for (int i = 0; i < cntOfPairs; i++) {
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();

      // 양 노드 모두에 연결 정보 저장
      nodes[n1].neighbors.add(n2);
      nodes[n2].neighbors.add(n1);
    }
    sc.close();

    System.out.println(bfs());
  }

  static int bfs() {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[N + 1];
    visited[1] = true;

    // 1번 노드에 대한 연결 정보 계산(감염 컴퓨터 개수 계산 시작)
    for (int i = 0; i < nodes[1].neighbors.size(); i++) {
      Integer currNode = nodes[1].neighbors.get(i);
      visited[currNode] = true;
      queue.add(currNode);
      cnt++;
    }

    // 나머지 노드에 대해 bfs를 통해 감염 컴퓨터 개수 계산
    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      for (int i = 0; i < nodes[node].neighbors.size(); i++) {
        Integer currNode = nodes[node].neighbors.get(i);
        if (!visited[currNode]) {
          queue.add(currNode);
          visited[currNode] = true;
          cnt++;
        }
      }
    }

    return cnt;
  }
}
