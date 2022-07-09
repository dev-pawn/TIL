#include <stdio.h>

int	SquareByValue(int num)
{
	return (num * num);
}

void SquareByReference(int *num)
{
	*num *= *num;
}

int main(void)
{
	int num = 5;
	printf("%d\n", SquareByValue(num));
	SquareByReference(&num);
	printf("%d", num);

	return 0;
}