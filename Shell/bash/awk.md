# awk

- 형식

  pattern {Action}

- 사용예시

```jsx
예제 파일

smawley, andy
smiley, allen
smith, alan
smithern, harry
smithhern, anne
smitters, alexis
```

- 정규식

  - awk '/smi/' testfile :  testfile에서 smi를 포함하는 라인을 출력

  - awk '/smith+ern/' testfile : smith로 시작하고 하나 이상의 h 문자가 나오고 ern문자로 끝나는 문자열

  - awk '/allen | alan /' testfile : | 로 구분된 문자열중 하나라도 일치하면 출력

  - awk '/smith?/' testfile : smith로 시작하고 뒤에 0개 이상의 문자열이 존재하면 출력

  - awk '/a(ll)?(nn)?e/' testfile : ae, alle, anne, allnne 을 포함하는 문자열을 출력

  - awk '/l{2}/' testfile : l이 2번 연속으로 존재하는 문자열을 출력

  - awk '/t{2,}/' testfile : t가 최소 2번 연속으로 존재하는 문자열을 출력

  - awk '/er{1, 2}/' testfile: er이 최소1번 최대2번 연속으로 존재하는 문자열을 출력

  - awk '/sm[a-h]/' testfile: sm다음 [a-h]중 하나의 문자가 존재하는 문자열을 출력

  - awk '/sm[^a-h]/' testfile: sm다음 [a-h]중 하나의 문자가 존재하지 않는 문자열을 출력

  - awk '$1 ~ /n/' testfile: 지정된 변수가 정규식과 일치() 또는 불일치(!~)하는 조건문을 나타냄

    위 문장은 1번째 필드가 n의 문자를 포함하고 있는 문자열을 출력

  - awk '$2 ~ /^h/' testfile : ^는 필드나 레코드의 시작을 나타냄

    위 문장은 2번째 필드가 h로 시작하는 문자열을 출력

  - awk '$2 ~ /y$/' testfile : $는 필드나 레코드의 끝을 나타냄 ($2의 $는 해당되지 않는다.)

    위 문장은 2번째 필드가 y로 끝나는 문자열을 출력

  - awk '/a..e/' testfile : .는 모든 단일 문자를 의미함(개행을 제외)

    위 문장은 a와 e 사이에 2개(..)의 임의의 문자가 존재하는 문자열을 출력

  - awk '/a*e/' testfile : *는 0개 이상의 문자가 존재함을 의미함

    위 문장은 a와 e 사이에 0개 이상의 문자가 존재하는 문자열을 출력

  - \ : 이스케이프 문자입니다. 이스케이프 문자가 확장 정규식 내에서 특별한 의미를 가지고 있는 문자 앞에 있으면, 문자로부터 해당 의미를 제거합니다

  - /a\/\// : 위 이스케이프 문자의 사용 예제 입니다. 이 문장은 /a///과 동일한 의미를 가지며

    a//과 같습니다.

  - 인식되는 이스케이프 시퀸스

    - \” : "(이중 인용 부호) 표시
    - \// : (슬래시) 문자
    - \*ddd :* 1자리, 2자리 또는 3자리 8진 정수로 인코딩을 표시하는 문자입니다. 여기서, *d*는 8진 숫자를 나타냅니다.
    - \\ : \(백슬래시) 문자
    - \a : 경고 문자
    - \b : 백스페이스 문자
    - \f : 용지 넘김 문자
    - \n : 줄 바꾸기 문자(다음 참고 참조)
    - \r : 캐리지 리턴(CR) 문자
    - \t : 탭 문자
    - \v : 세로 탭.

- 패턴의 조합

  - ,로 구분하기 예 ) /begin/,/end/

  - ()는 패턴을 그룹화 합니다.

  - 부울 연산자 사용가능 (&&,||,!)

    예) $1 == "al" && $2 == "123"

    위 예제는 첫번째 필드에 al가 존재하고 두번째 필드에 123이 존재하는 문자열을 출력

- 참고 자료

  - IBM AWK 페이지 : https://www.ibm.com/docs/ko/ssw_aix_72/com.ibm.aix.cmds1/awk.htm
  - NR NF 설명 : https://jhnyang.tistory.com/494