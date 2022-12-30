import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      System.out.println(calculateDistance(
          sc.nextInt(), sc.nextInt(),
          sc.nextInt(), sc.nextInt(),
          sc.nextInt(), sc.nextInt()));
    }

    sc.close();
  }

  static int calculateDistance(int x1, int y1, int r1, int x2, int y2, int r2) {
    double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    int rplus = r1 + r2;
    int rminus = Math.abs(r1 - r2);

    if (distance > rplus || rminus > distance) // 두 원이 만나지 않는 경우
      return 0;
    else if (distance < rplus && distance > rminus) // 두 원이 두 점에서 만나는 경우
      return 2;
    else if (distance == 0 && r1 == r2) // 두 원이 일치하는 경우
      return -1;
    else // 두 원이 한 점에서 만나는 경우
      return 1;
  }
}
