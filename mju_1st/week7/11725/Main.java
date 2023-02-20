import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static class Node {
    int idx;
    Node parent;
    ArrayList<Node> childs;
    ArrayList<Integer> nodeInfos;

    public Node(int idx) {
      this.idx = idx;
      this.childs = new ArrayList<Node>();
      this.nodeInfos = new ArrayList<Integer>();
    }

    public void setParent(Node parent) {
      this.parent = parent;
    }

    public void addChild(Node child) {
      this.childs.add(child);
    }

    public void addNodeInfo(Integer nodeInfo) {
      this.nodeInfos.add(nodeInfo);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 노드의 개수
    ArrayList<Node> nodes = new ArrayList<Node>();
    for (int i = 1; i < N + 1; i++) {
      nodes.add(new Node(i));
    }

    for (int i = 0; i < N - 1; i++) {
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();

      Node node1 = nodes.get(n1 - 1);
      Node node2 = nodes.get(n2 - 1);

      if (n2 != 1)
        node1.addNodeInfo(n2);
      if (n1 != 1)
        node2.addNodeInfo(n1);
    }

    sc.close();

    Queue<Node> queue = new LinkedList<Node>();
    Boolean[] visited = new Boolean[N + 1];
    for (int i = 0; i < N + 1; i++) {
      visited[i] = false;
    }

    // 1번 노드부터 있는 것부터 처리
    for (int i = 0; i < nodes.get(0).nodeInfos.size(); i++) {
      int nodeIdx = nodes.get(0).nodeInfos.get(i) - 1;
      Node child = nodes.get(nodeIdx);
      nodes.get(0).addChild(child);
      queue.add(child);
      child.setParent(nodes.get(0));
      visited[nodeIdx] = true;
    }

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      // 자식 노드들 설정 후 큐에 추가
      for (int i = 0; i < node.nodeInfos.size(); i++) {
        int nodeIdx = node.nodeInfos.get(i) - 1;
        if (!visited[nodeIdx]) {
          Node child = nodes.get(nodeIdx);
          node.addChild(child);
          child.setParent(node);
          queue.add(child);
          visited[nodeIdx] = true;
        }
      }
    }

    for (int i = 1; i < N; i++) {
      System.out.println(nodes.get(i).parent.idx);
    }
  }
}
