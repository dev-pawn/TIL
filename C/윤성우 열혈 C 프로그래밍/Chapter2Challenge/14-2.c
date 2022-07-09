#include <stdio.h>

void	Swap3(int* num1, int* num2, int* num3)
{
	int temp = 0;
	temp = *num1;
	*num1 = *num3;
	*num3 = *num2;
	*num2 = temp;
}

int	main(void)
{
	int num1, num2, num3;
	num1 = 1;
	num2 = 2;
	num3 = 3;

	Swap3(&num1, &num2, &num3);
	printf("num1 = %d\nnum2 = %d\nnum3 = %d\n", num1, num2, num3);
	return 0;
}