#include <stdio.h>

int main() {
    int leftX, leftY, rightX, rightY;
    scanf("%d %d %d %d", &leftX, &leftY, &rightX, &rightY);

    printf("좌 상단의 x, y 좌표: %d %d\n", leftX, leftY);
    printf("우 상단의 x, y 좌표: %d %d\n", rightX, rightY);
    printf("두 점이 이루는 직사각형의 넓이는 %d입니다.\n", (rightX-leftX)*(rightY-leftY));
    return 0;
}