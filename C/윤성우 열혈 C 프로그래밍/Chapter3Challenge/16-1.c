#include <stdio.h>

int main(void)
{
	int i, j;
	int arr[3][9] = { 0 };
	
	for (i = 0; i < 3; i++)
		for (j = 0; j < 9; j++)
			arr[i][j] = (i+2) * (j+1);


	for (i = 0; i < 3; i++)
	{
		for (j = 0; j < 9; j++)
		{
			printf("%3d", arr[i][j]);
		}
		printf("\n");
	}
	return 0;
}