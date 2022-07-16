#include <stdio.h>

int main(void)
{
	int i, j, sum;
	int arr[5][5] = { 0 };
	
	for (i = 0; i < 4; i++)
	{
		sum = 0;
		printf("%d번째 학생의 순서입니다.\n", i + 1);
		for (j = 0; j < 4; j++)
		{
			printf("%d번째 과목 점수 입력 : ", j + 1);
			scanf_s("%d", &arr[i][j]);
			sum += arr[i][j];
		}
		arr[i][4] = sum;
	}
	
	for (j = 0; j < 5; j++)
	{
		sum = 0;
		for (i = 0; i < 5; i++)
		{
			sum += arr[i][j];
		}
		arr[4][j] = sum;
	}

	for (i = 0; i < 5; i++)
	{
		for (j = 0; j < 5; j++)
		{
			printf("%3d", arr[i][j]);
		}
		printf("\n");
	}
	return 0;
}