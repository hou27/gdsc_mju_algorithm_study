#include<stdio.h>
#include<math.h>
#include<stdlib.h>

int main() {
  int T, rplus, rminus;
  int x1, y1, r1, x2, y2, r2;
  double d;

  scanf("%d", &T);

  for (int i = 0; i < T; i++) {
    scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);
    rplus = r1 + r2;
    rminus = abs(r1 - r2);
    d = sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));
    if (d > rplus || rminus > d) printf("0\n");
    else if (d < rplus && d > rminus) printf("2\n");
    else if (d == 0 && r1 == r2) printf("-1\n");
    else printf("1\n");
  }

  return 0;
}