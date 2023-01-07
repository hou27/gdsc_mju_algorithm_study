import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] YenArr = { 500, 100, 50, 10, 5, 1 };
    int change = 1000 - sc.nextInt();

    sc.close();

    int cnt = 0;
    for (int yen : YenArr) {
      cnt += change / yen;
      change %= yen;
    }

    System.out.println(cnt);
  }

}
