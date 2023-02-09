import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static class Node {
    int idx;
    Node parent;
    ArrayList<Node> childs;

    public Node(int idx) {
      this.idx = idx;
      this.childs = new ArrayList<Node>();
    }

    public void setParent(Node parent) {
      this.parent = parent;
    }

    public void addChild(Node child) {
      this.childs.add(child);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 노드의 개수
    int[][] nodeInfo = new int[N - 1][2];
    ArrayList<Node> nodes = new ArrayList<Node>();
    for (int i = 1; i < N + 1; i++) {
      nodes.add(new Node(i));
    }

    for (int i = 0; i < N - 1; i++) {
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();

      nodeInfo[i] = new int[] { n1, n2 };
    }

    // nodeInfo 정렬
    Arrays.sort(nodeInfo, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    for (int i = 0; i < N - 1; i++) {
      int n1 = nodeInfo[i][0];
      int n2 = nodeInfo[i][1];

      Node node1 = nodes.get(n1 - 1);
      Node node2 = nodes.get(n2 - 1);

      if (node1.parent == null && n1 != 1) {
        node1.setParent(node2);
        node2.addChild(node1);
      } else {
        node2.setParent(node1);
        node1.addChild(node2);
      }
    }

    sc.close();

    for (int i = 1; i < N; i++) {
      System.out.println(nodes.get(i).parent.idx);
    }
  }
}
