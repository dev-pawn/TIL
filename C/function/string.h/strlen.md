| 헤더 파일 | c : string.h
c++ : cstring |
| --- | --- |
| 함수원형 | size_t strlen(const char *str) |

const char 타입의 문자열을 받아서 해당 문자열의 길이를 반환하는 함수

반환형인 size_t타입은 어떤 객체나 값이 포함할 수 있는 최대 크기의 데이터를 표현하는 타입으로 반드시 unsigned형으로 나타낸다.

strlen함수는 str 배열의 시작부터 ‘\0’ 널 문자를 만날 때 까지 문자의 개수를 카운트 한다.

*그로인해 문자열의 중간에 널값이 포함되어 있으면 거기까지만 카운트한다.

- 참고 자료
    
    [https://blockdmask.tistory.com/381](https://blockdmask.tistory.com/381)
    
    size_t : [https://namu.wiki/w/size_t](https://namu.wiki/w/size_t)
