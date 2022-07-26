#include <stdio.h>

void	MaxAndMin(int *arr, int **maxPtr, int **minPtr)
{
	int i;
	int* max;
	int* min;

	max = min = &arr[0];
	for (i = 0 ; i < 5; i++)
	{
		if (*max < arr[i])
			max = &arr[i];
		if (*min > arr[i])
			min = &	arr[i];
	}
	*maxPtr = max;
	*minPtr = min;
	
}

int main(void)
{
	int* maxPtr;
	int* minPtr;
	int arr[5];
	int i;

	for (i = 0; i < 5; i++)
	{
		printf("ũ�� �񱳸� �� ���� �Է��Ͻÿ�.\n5���� %d��° : ",1+i);
		scanf_s("%d", &arr[i]);
	}
	MaxAndMin(arr, &maxPtr, &minPtr);
	printf("max : %d\n", *maxPtr);
	printf("min : %d\n", *minPtr);	
	return 0;
}