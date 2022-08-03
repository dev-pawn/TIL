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
	printf("문자를 입력하시오 : ");
	word = getchar();
	word = conveter(word);
	if (word == -1)
	{
		printf("잘못된 입력입니다.");
		return -1;
	}
	putchar(word);
	return 0;
}