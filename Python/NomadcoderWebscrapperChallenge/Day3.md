# Day 3



## Default Parameters

사용자에게 에러 메시지를 노출하지 않기 위해서 함수 매개변수에 기본 값을 설정할 수 있음

```python
def test(num1=0):
    print(num)

test()
```



## Return Values

return을 이용해 함수의 반환값을 가져올 수 있음

```python
def test(num1, num2):
    return(num1*num2)

multiply = test(2, 3)
print(multiply)
```



## Return Recap

스트링안에 변수를 넣기 위해선 스트링 앞에 f(fomat)를 붙여줘야 함

```python
my_name = "hyun"
my_age = 12
my_color_eyes = "brown"

print(f"Hello I'm {my_name}, I have {my_age} years in the earth, {my_color_eyes} is my eye color")
```



> 주스 메이커 만들기

```python
def make_juice(fruit):
    return f"{fruit}+🧃"

def add_ice(juice):
    return f"{juice}+🧊"

def add_sugar(iced_juice):
    return f"{iced_juice}+🍷"

juice = make_juice("🍏")
cold_juice = add_ice(juice)
perfect_juice = add_sugar(cold_juice)

print(perfect_juice)
```



## If

condition이 참이면 true를 출력

```python
if condition:
    print("true")
```



## Else & Elif

condition이 참이면 true를 출력, 거짓이면 false를 출력

```python
if condition:
    print("true")
else:
    print("false")
```



condition1이 참이면 true를 출력, condition1이 거짓이고 condition2가 참이면 true2를 출력, condition1, 2가 모두 거짓이면 false를 출력

```python
if condition:
    print("true")
elif condition2:
    print("true2")
else:
    print("false")
```



## 실습 - 계산기 만들기

> 구현해야 할 것

- 덧셈, 뺄셈, 곰셉, 나누기, 제곱
- 사용자에게 에러를 보여주지 않기
- 직접 숫자를 입력받지는 않고 각 연산의 함수호출을 통해 print



> 결과

[calculator.py](./calculator.py)
