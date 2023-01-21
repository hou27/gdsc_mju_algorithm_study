import java.util.Scanner;

public class Main {
  static int cnt = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 자릿수

    sc.close();

    if (N < 3) {
      System.out.println(1);
      return;
    }

    int[] pinary_number = new int[N];

    pinary_number[0] = 1;
    pinary_number[1] = 0;

    pinary(pinary_number, 2);

    System.out.println(cnt);
  }

  static void pinary(int[] pinary_number, int idx) {
    if (idx == pinary_number.length) {
      cnt++;
      return;
    }

    if (pinary_number[idx - 1] == 0) {
      pinary_number[idx] = 1;
      pinary(pinary_number, idx + 1);
      pinary_number[idx] = 0;
      pinary(pinary_number, idx + 1);
    } else {
      pinary_number[idx] = 0;
      pinary(pinary_number, idx + 1);
    }
  }
}
