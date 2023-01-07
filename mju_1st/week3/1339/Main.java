import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  static int num = 9;
  static ArrayList<String> words = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] alphabet = new int[26];
    int N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      words.add(sc.next());
    }

    sc.close();

    Collections.sort(words, (a, b) -> b.length() - a.length()); // 길이가 긴 순서대로 정렬

    setNum(alphabet, 0, words.get(0).length()); // 알파벳에 숫자 할당

    // 알파벳에 할당된 숫자를 이용해 계산
    int sum = 0;
    for (int i = 0; i < N; i++) {
      int len = words.get(i).length();
      for (int j = 0; j < len; j++) {
        sum += alphabet[words.get(i).charAt(j) - 'A'] * Math.pow(10, len - j - 1);
      }
    }

    System.out.println(sum);
  }

  static void setNum(int[] alphabet, int idx, int digit) {
    if (words.get(idx).length() < digit) { // 단어의 길이가 짧아 숫자를 할당할 차례가 아닌 경우
      setNum(alphabet, 0, digit - 1); // 가장 긴 단어의 다음 자리수로 넘어감
      return;
    }

    int loc = words.get(idx).length() - digit; // 할당할 자리수
    if (alphabet[words.get(idx).charAt(loc) - 'A'] == 0) { // 아직 숫자가 할당되지 않은 경우
      alphabet[words.get(idx).charAt(loc) - 'A'] = num--;
    }
    if (idx + 1 < words.size()) { // 다음 단어로 넘어감
      setNum(alphabet, idx + 1, digit);
    } else if (idx + 1 == words.size() && digit > 1) { // 모든 단어를 다 돌았는데 자리수가 남은 경우
      setNum(alphabet, 0, digit - 1);
    }
  }

}
