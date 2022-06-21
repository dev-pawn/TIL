#include <stdio.h>

int	main(void)
{
	int arr[6] = { 1, 2, 3, 4, 5, 6 };
	int* head = &arr[0];
	int* tail = &arr[5];
	int temp, i = 0;

	for (i = 0; i < 3; i++)
	{
		temp = *head;
		*head = *tail;
		*tail = temp;
		head++;
		tail--;
	}
	for (i = 0; i < 6; i++)
	{
		printf("%d ", arr[i]);
	}
	return 0;
}