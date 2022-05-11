#include <stdio.h>

int main() {
    int number;

    scanf("%d", &number);

    printf("%d", ~number+1);
    return 0;
}