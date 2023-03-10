#include<stdio.h>
#include<math.h>
#include<stdbool.h>

bool isPrime(int n) {
  bool flag = true;
  int l = (int)sqrt(n);
  for (int i = 2; i <= l; i++) {
    if (n % i == 0) {
      flag = false;
      break;
    }
  }

  return flag;
}

int main() {
  int n, T, l;

  l = (int)sqrt(10000);

  scanf("%d", &T);

  for (int i = 0; i < T; i++) {
    scanf("%d", &n);
    for (int j = n / 2; j >= 2; j--) {
      if (isPrime(j) && isPrime(n - j)) {
        printf("%d %d\n", j, n - j);
        break;
      }
    }
  }

  return 0;
}