import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int xA = sc.nextInt();
    int yA = sc.nextInt();
    int xB = sc.nextInt();
    int yB = sc.nextInt();
    int xC = sc.nextInt();
    int yC = sc.nextInt();

    sc.close();

    // Line AB, Line AC의 기울기
    double slopeAB = (double) (yB - yA) / (xB - xA);
    double slopeAC = (double) (yC - yA) / (xC - xA);

    // 평행사변형이 될 수 없는 세점일 경우 -1 출력
    if (xA == xB && yA == yB || xA == xC && yA == yC || xB == xC && yB == yC || slopeAB == slopeAC) {
      System.out.println(-1.0);
      return;
    } else {
      // 각 좌표 간의 거리
      double distAB = Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2));
      double distAC = Math.sqrt(Math.pow(xA - xC, 2) + Math.pow(yA - yC, 2));
      double distBC = Math.sqrt(Math.pow(xB - xC, 2) + Math.pow(yB - yC, 2));

      // 모든 경우의 둘레 길이
      double perimeter1 = distAB * 2 + distBC * 2;
      double perimeter2 = distAB * 2 + distAC * 2;
      double perimeter3 = distAC * 2 + distBC * 2;

      // 가장 큰 둘레 길이와 가장 작은 둘레 길이의 차이 double형으로 출력
      System.out.println(String.format("%.15f", Math.max(perimeter1, Math.max(perimeter2, perimeter3))
          - Math.min(perimeter1, Math.min(perimeter2, perimeter3))));
    }
  }

}
