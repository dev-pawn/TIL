# Day 4 Challenge



## 코드 챌린지

- 오늘의 강의: [Python으로 웹 스크래퍼 만들기: From #3.3 to #3.7](https://nomadcoders.co/python-for-beginners/lectures/3774)
- 오늘의 과제: 위의 강의를 시청하신 후, 아래 코드 챌린지를 제출하면 됩니다.
- 제출기간: 익일 오전 6시까지

### Challenge goals:

- Using everything that we have learnt so far to make a calculator that uses the user's input.
- 이때까지 배운 것을 활용하여, 유저의 인풋을 활용하는 계산기를 만드세요.
- 아래와 같은 영상처럼 출력되어야 합니다.

[영상](https://i.imgur.com/zY7PBqs.mp4)

### Requirements:

- Use `if/elif`
- Use `while`



## 챌린지 템플릿

```python
playing = True


a = int(input("Choose a number:\n"))
b = int(input("Choose another one:\n"))
operation = input("Choose an operation:\n    Options are: + , - , * or /.\n    Write 'exit' to finish.\n")
  
# add your code here!
```



## 챌린지 요구사항 정리

- Choose a number: 를 프린트 한 뒤 첫 번째 숫자를 받음
- Choose another one: 를 프린트 한 뒤 두 번째 숫자를 받음
- Choose an operation: 를 프린트 한 뒤 연산자를 받음
  - 연산자가 아닌 exit를 입력할 경우 프로그램 종료



## 코드 작성

[Day4Challenge](./Day4Challenge.py)