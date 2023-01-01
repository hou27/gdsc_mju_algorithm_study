import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();

    sc.close();

    if (K == 1) {
      System.out.println(1);
    } else if (K == 2) {
      System.out.println(N + 1);
    } else {

    }
  }

}
