#include <stdio.h>

int conveter(int word)
{
	if (word >= 'A' && word <= 'Z')
		return word + 32;
	else if (word >= 'a' && word <= 'z')
		return word - 32;
	else
		return -1;
}

int main(void)
{
	int word;
	printf("���ڸ� �Է��Ͻÿ� : ");
	word = getchar();
	word = conveter(word);
	if (word == -1)
	{
		printf("�߸��� �Է��Դϴ�.");
		return -1;
	}
	putchar(word);
	return 0;
}