# strcat

| 헤더 파일 | c : string.h c++ : cstring                    |
| --------- | --------------------------------------------- |
| 함수원형  | char *strcat(char* dest, const char* origin); |

origin에 있는 문자를 dest뒤에 붙이는 함수이다.

dest마지막에 붙어 있는 ‘\0’ 널값을 삭제하고 origin을 붙이는 것이 특징이다.

*dest의 길이가 충분하지 않을 경우 예측하지 못한 결과값이 나올 수 있다.