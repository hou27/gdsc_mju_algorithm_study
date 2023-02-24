import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 끊어진 기타줄 개수
    int M = sc.nextInt(); // 기타줄 브랜드 개수

    int minPackage = 0, minSingle = 0, minTotal = 0;
    for (int i = 0; i < M; i++) {
      int p = sc.nextInt(); // 패키지(기타줄 6개) 가격
      int s = sc.nextInt(); // 낱개 가격

      // 브랜드별 가격을 비교하여 최소값을 저장
      if (i == 0) {
        minPackage = p;
        minSingle = s;
      } else {
        if (p < minPackage) {
          minPackage = p;
        }
        if (s < minSingle) {
          minSingle = s;
        }
      }
    }
    sc.close();

    // 최소값을 이용하여 최소 비용 계산(필요한 기타줄 개수보다 많이 구매하는 경우가 있음)
    minTotal = N >= 6 ? (N / 6) * minPackage + Math.min((N % 6) * minSingle, minPackage)
        : Math.min(N * minSingle, minPackage);

    System.out.println(minTotal);
  }

}
