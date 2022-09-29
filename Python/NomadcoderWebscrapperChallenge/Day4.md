# Day 4



## And & Or

`input` 함수는 사용자로부터 입력을 받아 리턴하는 함수이다.

```python
age = input("How old ar you?")
print(age)
```



`type` 함수는 매개변수의 type을 리턴하는 함수이다.

```python
age = input("How old ar you?")
print(type(age))
```



`int` 함수는 매개변수의 type을 int형으로 변환하는 함수이다.

```python
age = int(input("How old ar you?"))
print(type(age))
```



and를 이용해 if문이나 elif문에서 여러가지 조건을 모두 만족하는 경우를 확인할 수 있다.

```python
age = int(input("How old ar you?"))

if age < 18:
    print("You can't drink.")
elif age > 18 and age <35:
    print("You drink beer!")
else:
    print("Go ahead!")
```



or을 이용해 if문이나 elif문에서 여러가지 조건을 하나라도 만족하는 경우를 확인할 수 있다.

```python
age = int(input("How old ar you?"))

if age < 18:
    print("You can't drink.")
elif age > 18 and age <35:
    print("You drink beer!")
elif age == 30 or age == 70:
    print("Birthday party!")
else:
    print("Go ahead!")
```



## Python Standard Library

> 카지노 프로그램 만들기

```python
from random import randint

user_choice = int(input("Choose number."))
pc_choice = randint(1,100)

if user_choice == pc_choice:
    print("You won!")
elif user_choice > pc_choice:
    print("Lower! Computer chose", pc_choice)
elif user_choice < pc_choice:
    print("Higher Computer chose", pc_choice)
```

[파이썬표준라이브러리](https://docs.python.org/3/library/index.html)



## While

주석처리

```python
# 라인주석처리
"""
여러라인주석처리
print("A")
print("B")
"""
```



while문은 condition이 True이면 반복해서 작동됨

```python
while condition:
    print("again")
```



## Python Casino

위에서 작성한 카지노게임은 1회만 가능한 문제가 있음 이를 while문을 이용해 해결

```python
from random import randint

print("Welcome to Python Casino")
pc_choice = randint(1,100)

playing = True

while playing:
  user_choice = int(input("Choose number (1-100):"))
  if user_choice == pc_choice:
    print("You won!")
    playing = False
  elif user_choice > pc_choice:
    print("Lower!")
  elif user_choice < pc_choice:
    print("Higher!")
```

