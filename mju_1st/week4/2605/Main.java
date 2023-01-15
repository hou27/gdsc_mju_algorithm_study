import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 학생 수
    LinkedList<Integer> students = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      int foward = sc.nextInt(); // 앞으로 갈 칸 수
      students.add(i - foward, i + 1); // i번째 학생은 i - foward번째에 앉는다.
    }
    sc.close();

    for (int i : students) {
      System.out.print(i + " ");
    }
  }
}
