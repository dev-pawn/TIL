# Chapter 3 반복문과 배열 그리고 예외 처리



## 목차

- 반복문
- continue 문과 break 문
- 배열
- 다차원 배열
- 메소드에서 배열 리턴
- main() 메소드
- 자바의 예외 처리



## 반복문

자바는 반복 연산을 수행할 수 있도록 다음 3가지 종류의 반복문을 제공한다.

```
for, while, do-while
```

for문은 처음부터 반복 횟수를 알 수 있는 경우에, while문과 do-while 문은 반복 횟수를 알 수 없고 조건에 따라 반복이 계속 되거나 중단되는 경우에 이용한다.  
while문은 반복 조건을 처음부터 따지는 경우에, do-while 문은 반복 조건을 나중에 따지는 경우에 적합하다.



> for 문

![](./img/chapter3/ex1.jpg)

- 초기문

  초기문은 주로 조건식에서 사용하는 변수를 초기화한다.

  - 초기문은 시작할 때 한 번만 수행된다.
  - 콤마(,)로 분리하여 여러 문장을 나열할 수 있다.
  - 초기문은 빈 상태로 두어도 되지만 끝에 세미콜론(;)은 있어야 한다.



- 조건식

  조건식에는 논리형 변수나 논리 연산을 사용한다. 조건식의 결과가 true이면 반복이 계속되고 false이면 for 문을 벗어난다.  
  조건식은 for 문의 작업 문장을 수행하기 전에 검사되므로 조건식이 처음부터 false이면 바로 반복문을 벗어난다.

  ```java
  for(i=0; i<10; i++) {		// i가 0~9까지 10번 반복
  	System.out.print(i);
  }
  ```

  다음과 같이 조건식에 true가 있거나 비어 있으면 무한 반복(infinity loop) 된다.

  ```java
  for(초기문; true; 반복 후 작업) {		// 무한 반복
  	.......
  }
  for(초기문; ; 반복 후 작업) {			// 조건식이 비어 있으면 무한 반복
  	.......
  }
  ```



- 반복 후 작업

  for 문의 작업문이 실행된 후 '반복 후 작업문'이 실행된다.

  ``` java
  for(i=0; i<10; i+=2) {		// i가 0,2,4,6,8로 변하면서 5번 반복
    ........
  }
  ```

  반복 후 작업문'에는 콤마(,)로 분리하여 여러 문장을 나열할 수 있다.  
  예를 들면 다음과 같다. 이 코드는 i 값을 증가시키고 증가된 i 값을 화면에 출력한다.

  ```java
  for(i=0; i<10; i++, System.out.println(i)) {
  	........
  }
  ```

  

- 작업문

  작업문은 for 문이 반복되는 동안 반복 실행된다. 작업문이 하나의 문장일 경우 중괄호({})가 필요 없지만 여러 개의 문장으로 구성되는 경우 반드시 중괄호로 묶어야 한다.



> for 문 활용

- 반복문에 변수 선언

  다음과 같이 변수 i를 for 문 블록 내에서만 사용되는 지역 변수로 선언하여 사용할 수 있다.  
  이 때 변수 i는 for 문 밖에서는 사용할 수 없다.

  ```java
  for (int i=0; i<10; i++) // 변수 i는 for 문 밖에서 사용 불가
  	System.out.print(i);
  ```



- 1에서 100까지의 합 구하기

  ```java
  int sum = 0;
  for(int i=1; i<=100; i++)		// 1에서 100까지 반복
  	sum += i;
  
  int sum = 0;
  for(int i=100; i>=1; i--)		// 100에서 1까지 반복
    sum += i;
  
  int i, sum;
  for(i=1, sum=0; i<=100; i++)	// sum 변수를 0으로 초기화
    sum += i;
  ```



> while 문

![](./img/chapter3/ex2.jpg)

while 문은 반복 횟수를 알 수 없는 경우에 적합하다. while문의 조건식은 for 문의 경우와 동일하며, true인 동안 작업문의 실행을 반복하고, false가 되면 while 문을 벗어난다.  
for 문과 달리, while문에 조건식이 없으면 컴파일 오류가 발생한다.  
while 문을 사용하는 경우, 조건식에 사용되는 변수를 while 문 실행 전에 초기화하는 것을 잊지 말아야 한다. 그리고 반복이 진행되면서 조건식이  false가 되어 반복문을 빠져 나올 수 있도록 설계되어야 한다. 그렇지 않으면 무한 반복에 빠지게 된다.



> do-while문

![](./img/chapter3/ex3.jpg)

do-while 문의 조건식은 while 문과 동일하며 조건식이 없으면 컴파일 오류가 발생한다. 다른 반복문과는 달리,  do-while 문은 작업문 실행 후 조건식을 검사하므로 작업문이 최초 한 번은 반드시 실행된다.



> 중첩 반복

반복문 안에 다른 반복문을 만들 수 있다. 이것을 중첩 반복(nested loop)이라 한다.  
반복은 몇 번이고 중첩 가능하지만, 너무 깊은 중첩 반복은 프로그램 구조를 복잡하게 하므로 2중 또는 3중 중첩 이상하지 않는 것이 바람직하다.



## continue 문과  break 문

반복문 내에 continue 문이나 break 문을 이용하면 반복의 흐름을 바꾸거나 반복에서 벗어나게 할 수 있다.  
break 문은 현재 반복문을 벗어나게 하며, continue 문은 즉시 다음 반복으로 넘어간다.



> continue 문

continue 문은 반복문을 빠져나가지 않으면서 즉시 다음 반복으로 넘어가고자할 때 사용된다.

```java
continue;
```

아래 그림은 각 반복문에서 continue 문에 의해 실행 경로가 변경되는 것을 보여준다.

![](./img/chapter3/ex4.jpg)



> break 문

break 문은 하나의 반복문을 즉시 벗어날 때 사용하며 다음과 같이 사용한다.

```java
break;
```

중첩 반복의 경우 안쪽 반복문에서 break 문이 실행되면, 안쪽 반복문만 벗어나며 바깥 쪽 반복문 내에서 실행이 유지된다.



## 배열

> 배열이란?

배열(array)은 인덱스(index)와 인덱스에 대응하는 데이터들로 이루어진 연속적인 자료 구조로서, 같은 종류의 데이터들이 순차적으로 저장된다.  
아래 그림은 10개의 정수 값을 저장하고 합할 때, 10개의 변수를 사용한 경우와 자바의 배열을 사용한 경우를 대조하여 보여준다.

![](./img/chapter3/ex5.jpg)

배열을 사용하는 큰 이유 중 하나는 반복문의 활용에 있다. 배열을 사용하면 다음과 같이 for 문으로 10개의 정수 합을 간단히 구할 수 있다.

```java
for(sum=0, n=0; n<10; n++)
	sum += i[n];
```



> 배열 선언 및 생성

자바에서 배열의 생성은 C/C++와 달리 다음 두 단계로 이루어진다.

- 배열에 대한 레퍼런스 변수 선언
- 배열 생성 - 배열의 저장 공간 할당

아래 그림은 5개의 정수 값을 저장하는 배열을 만드는 코드로, 배열에 대한 레퍼런스 변수를 선언하는 단계와, 데이터를 저장할 배열 공간을 할당받는 단계로 구분된다.

![](./img/chapter3/ex6.jpg)

- 배열에 대한 레퍼런스 변수 선언

  다음은 배열 선언문으로 레퍼런스 변수 intArray를 선언한다.

  ```java
  int intArray[];
  ```

  이 선언만으로 배열 공간이 할당되지 않으며, 위 그림과 같이 레퍼런스 변수 intArray만 생성된다.  
  intArray는 배열 공간에 대한 주소 값(레퍼런스 값)을 가지며 그 자체가 배열은 아니다. 아직 정수를 저장할 배열 공간이 생성되지 않았으므로 intArray 값은 null이다.  
  자바에서는 배열의 주소를 레퍼런스라고 부르며, 배열에 대한 주소 값을 가지는 변수를 레퍼런스 변수라고 부른다.  
  배열의 타입은 배열을 구성하는 원소의 타입이며, 배열의 레퍼런스 변수는 다음 두 가지 방법으로 선언할 수 있다.

  ```java
  int intArray[];
  int [] intArray;
  ```

- 배열 선언 시 []에 크기를 지정하면 안 됨

  배열 선언 시 [] 안에 배열의 크기를 지정해서는 안 된다. 다음 문장은 컴파일 오류이다.

  ```java
  int intArray[10];		// 컴파일 오류. 배열의 크기를 지정할 수 없음
  ```

- 배열 생성

  배열 생성은 데이터를 저장할 배열 공간을 할당받는 과정이다. 반드시 new 연산자를 이용하여 배열을 생성하며 [] 안에 생성할 원소 개수를 지정한다.  
  다음 코드는 정수 5개의 배열 공간을 할당받고 이 배열에 대한 레퍼런스 값(주소 값)을  intArray에 저장한다.

  ```java
  intArray = new int[5];
  ```

- 배열의 선언과 동시에 생성

  다음과 같이 배열의 선언과 생성을 동시에 할 수 있다.

  ```java
  int intArray[] = new int[5];
  ```

- 배열 초기화

  배열 선언문에서 {}에 원소를 나열하면 초기화 된 배열을 만들 수 있다.  
  배열을 초기화하는 예를 들면 다음과 같으며 실행 결과는 아래 그림과 같은 배열이 생긴다.

  ```java
  int intArray[] = {4, 3, 2, 1, 0};
  double doubleArray[] = {0.01, 0.02, 0.03, 0.04};
  ```

  IntArray 배열의 크기는 자동으로 5가 되며, doubleArray 배열의 크기는 자동으로 4가 된다. 생성되는 배열의 원소 개수는 {}에 나열된 값의 개수로 정해지므로 []에 크기를 주어선 안 된다.

  ![](./img/chapter3/ex7.jpg)

  

> 배열 인덱스와 배열 원소 접근

배열의 인덱스는 정수만 가능하다. 인덱스는 0부터 시작하며 마지막 원소의 인덱스는 (배열 크기 -1)이다.  
배열의 원소를 접근하려면 반드시 배열이 생성(공간 할당)되어 있어야 한다. 배열이 생성되어 있지 않는 상태에서 배열을 사용하면 배열이 초기화가 되지 않았따는 컴파일 오류가 발생하거나, 실행시간 오류가 발생한다.



> 레퍼런스 치환과 배열 공유

자바에서는 레퍼런스 변수와 배열 공간이 분리되어 있기 때문에, 다수의 레퍼런스 변수가 하나의 배열 공간을 가리키는 배열 공유가 쉽게 이루어진다.  
다음 코드와 함께 아래 그림을 보면서 배열이 공유되는 것을 알아보자.

```java
int intArray[] = new int[5];
int myArray[] = intArray;		// 레퍼런스 치환. myArray는 intArray와 동일한 배열 참조
```

앞의 코드에서 두 번째 라인은 레퍼런스 변수 myArray를 생성하고 intArray 변수의 값을 myArray에 치환하는 코드이다.  
이 치환으로 intArray 배열이 복사되는 것이 아니라, 레퍼런스 즉 배열에 대한 주소만 복사된다.  
그 결과 myArray는 intArray와 동일한 레퍼런스 값을 가지게 되어  myArray는  intArray의 배열을 공유하게 되고, myArray로  intArray의 배열 원소를 마음대로 접근할 수 있다.

아래 그림의 윗부분은 intArray가 참조하는 배열을 myArray도 참조하고 있음을 보여준다. intArray와 myArray가 같은 배열을 참조하고 있기 때문에, 그림의 아랫부분의 myArray[1]=6;에 의해 먼저 기록된 값 2가 6으로 변경되는 것을 보여준다.

![](./img/chapter3/ex8.jpg)

- 배열의 크기, length 필드

  자바는 배열을 객체로 다룬다. 배열이 생성되면 아래 그림과 같이 객체가 생성된다. 이 객체에는 배열의 저장 공간과 함께 배열의 크기 값을 가진 length 필드가 존재한다.

  ![](./img/chapter3/ex9.jpg)

  length 필드를 이용하면 배열의 크기를 다음과 같이 간단히 알아낼 수 있다.

  ```java
  int intArray [] = new int[5];
  int size = intArray.length;		// size는 5
  ```

  배열 객체에  length 필드가 있기 때문에, 프로그램에서 배열의 크기를 따로 관리할 필요가 없다. 배열의 크기만큼 반복할 때  length 필드는 매우 유용하다. 다음은 intArray 배열의 모든 값을 출력하는 코드이다.

  ```java
  for(int i=0; i<intArray.length; i++)		// intArray 배열 크기(5)만큼 반복한다.
  	System.out.println(intArray[i]);
  ```

- 배열의 for-each 문

  기존의  for 문을 변형하여, 배열이나 나열(enumeration)의 크기만큼 루프를 돌면서 각 원소를 순차적으로 접근하는데 유용하게 만든 for 문을 for-each 문(오라클에서는  advanced for라고 부름)이라고 부르며, 구조는 아래 그림과 같다.

  ![](./img/chapter3/ex10.jpg)

  배열  n에 들어 있는 모든 정수를 더하는 코드를  for-each 문으로 작성하면 다음과 같다.

  ```java
  int [] n = { 1,2,3,4,5 };
  int sum = 0;
  for (int k : n) { // n.length번 반복. k는 n[0], ..., n[4]로 번갈아 반복
  	sum += k;
  }
  System.out.println("합은" + sum);
  ```

  앞의 for-each 문은  k=n[0], n[1], n[2], n[3], n[4] 값으로 바꾸면서, 배열  n의 크기만큼 반복한다. 그러므로 sum의 결과는  15가 된다.  
  또 다른 예를 들어보자. 문자열 배열에 있는 모든 문자열을 for-each 문으로 출력하는 코드와 실행 결과는 다음과 같다.

  ```java
  String name[] = { "사과", "배", "바나나", "체리", "딸기", "포도"} ;
  for (String s : names) { // 반복할 때마다 s는 names[0], ..., names[5]로 설정
  	System.out.print(s + " ";)
  }
  ```

  배열뿐만 아니라 나열 타입(enum)에 대해서도 다음과 같이 for-each 문이 사용된다.

  ```java
  enum week = {월, 화, 수, 목, 금, 토, 일}
  for (Week day : Week.values()) // 반복될 때마다 day는 월, 화, 수, 목, 금, 토, 일로 설정
  	System.out.print(day + "요일");
  ```

  앞의 코드는 enum 타입 Week를 선언한다. Week 타입은 월, 화, 수, 목, 금, 토, 일의 7개의 값 중 하나만 가지도록 선언되었기 때문에,  Week 타입의 객체 day는 이 7개의 값외 다른 값을 가질 수 없다.



## 다차원 배열

자바의 다차원 배열은 C/C++와 달리 독특한 구조를 가지기 때문에 주의하여 학습하기 바란다.



> 2차원 배열

- 2차원 배열의 선언과 생성

  1차원 배열과 마찬가지로 2차원 배열에서도 레퍼런스 변수 선언 후 배열을 생성한다.  
  2차원 배열의 레퍼런스 변수를 선언하는 방법은 다음 두 가지가 있다.

  ```java
  int intArray [][];
  char charArray [][];
  double doubleArray [][];
  ```

  또는

  ```java
  int [][] intArray;
  char [][] charArray;
  double [][] doubleArray;
  ```

  이제, 2차원 배열의 저장 공간은 다음과 같이  new 연산자를 이용하여 생성하며, 첫 번째 []는 행의 개수를, 두 번째 []는 열의 개수를 나타낸다.

  ```java
  intArray = new int [2][5];					// 2행 5열의 2차원 배열 생성
  charArray = new char [5][5];				// 5행 5열의 2차원 배열 생성
  doubleArray = new double [5][2];		// 5행 2열의 2차원 배열 생성
  ```

  아래 그림은 new int ``[2][5]``에 의해 생성된  2 * 5의 2차원 배열 구조를 보여준다. 2차원 배열에서는 행의 각 원소는 1차원 배열에 대한 레퍼런스가 된다.

  ![](./img/chapter3/ex11.jpg)

  위 그림에서 2차원 배열의 length 의미를 살펴보면 다음과 같다.

  - i.length       ->  2차원 배열의 행의 개수, 2
  - i[0].length   ->  0번째 행에 있는 열의 개수, 5
  - i[1].length   ->  1번째 행에 있는 열의 개수, 5

  2차원 배열도 다음과 같이 레퍼런스 변수 선언과 배열 생성을 동시에 할 수 있다.

  ```java
  int intArray [][] = new int [2][5];
  char charArray [][] = new char [5][5];
  double doubleArray [][] = new double [5][2];
  ```

- 2차원 배열의 초기화

  다음과 같이 2차원 배열을 선언할 때 각 원소를 초기화할 수 있다. 그러면 자동으로 원소 개수만한 배열 공간이 할당되고, 원소 값으로 초기화된다.

  ```java
  int intArray [][] = { {0,1,2}, {3,4,5,}, {6,7,8}};				// 3x3 배열 생성
  char charArray [][] = { {'a', 'b', 'c'}, {'d', 'e', 'f'}};		// 2x3 배열 생성
  double doubleArray [][] = {{0.01, 0.02}, {0.03, 0.04}};				// 2x2 배열 생성
  ```



> 비정방형 배열

지금까지 공부한 배열은 모두 정방형 배열이다. 정방형 배열은 각 행의 열 개수가 모두 동일한 배열을 말하며,  
비정방형 배열은 행마다 열의 개수가 서로 다른 배열을 말한다.  
아래 그림은 모든 행의 열의 개수가 동일한 4 x 4의 정방형 배열을 보여주며,

![](./img/chapter3/ex12.jpg)

아래 그림은 행마다 열의 개수가 다른 비정방형 배열을 보여준다.

![](./img/chapter3/ex13.jpg)

비정방형 배열은 다음 코드로 작성한다. 위 그림은 이 과정을 보여준다.

```java
int i [][];			// 2차원 배열의 레퍼런스 변수 i 선언
i = new int[4][];		// 각 행을 가리키는 레퍼런스 배열 생성
i[0] = new int [1];		// 첫째 행에 1개 크기의 배열 생성
i[1] = new int [2];		// 둘째 행에 2개 크기의 배열 생성
i[2] = new int [3];		// 셋째 행에 3개 크기의 배열 생성
i[3] = new int [4];		// 넷째 행에 4개 크기의 배열 생성
```

여기서  length 필드의 의미를 살펴보자.

- i.length	->	2차원 배열의 행의 개수, 4
- i[0].length    ->        0번째 행의 열의 개수, 1
- i[1].length    ->        1번째 행의 열의 개수, 2
- i[2].length     ->        2번째 행의 열의 개수, 3
- I[3].length     ->        3번째 행의 열의 개수, 4

어떤 메소드가 배열을 매개변수로 받을 때, 배열이 정방형인지 비정방형인지는 표시되지 않기 때문에 항상  length 필드를 사용하여 각 행의 열의 개수를 파악하여야 한다.  
배열 생성 시에 초기화를 통해 비정방형 배열을 생성할 수도 있다. 다음 코드는 위 그림의 비정방형 배열을 생성하고 순서대로 각 원소에 정수 0, 1, 2, ..., 9값을 저장하는 코드이다.

```java
int intArray[][] = { {0}, {1,2}, {3,4.5}, {6,7,8,9} };
```



## 메소드에서 배열 리턴

메스드가 배열을 리턴하는 경우에 대해 알아보자.  
메소드에서 어떤 배열이든지 리턴하면, 배열 공간 전체가 아니라 배열에 대한 레퍼런스만 리턴된다.  
아래 그림은 int[] 배열을 리턴하는  makArray() 메소드 코드이다.

![](./img/chapter3/ex14.jpg)

메소드는 레퍼런스만 리턴하기 때문에, 리턴 타입을 선언할 때 [] 안에 배열의 크기를 지정하지 않는다. 또한 리턴하는 배열의 타입이 리턴받는 레퍼런스 변수의 타입과 일치해야 한다.  
makeArray() 메소드로부터 배열을 리턴받는 코드를 작성해보자.

```java
int [] intArray;		// makeArray()의 리턴 타입과 동일한 타입 선언
intArray = makeArray();		// makeArray() 메소드가 리턴하는 배열 받음
```

이 코드의 실행 결과는 아래 그림과 같으며, intArray는  makeArray()가 만들어 리턴한 배열을 가리키게 되어, 다음과 같이 intArray로 배열 원소에 접근 가능하다.

```java
intArray[0] = 5;			intArray[1] = 6;			intArray[2] = 7;			intArray[3] = 8;
```

![](./img/chapter3/ex15.jpg)

2차원 배열을 리턴하는 메소드와 배열을 리턴받는 코드는 다음과 같이 작성할 수 있다. 메소드의 리턴 타입에 주목하기 바란다.

```java
int [][] make2DArray() {
  return new int [3][4];		// 2차원 배열 생성 및 리턴
}
int [][] int2Array = make2DArray();		// 2차원 배열 리턴 받기(레퍼런스만)
```



## main() 메소드

> main() 메소드의 특징

main() 메소드는 자바 응용프로그램의 실행이 시작되는 특별한 메소드로서 원형은 아래 그림과 같다.

![](./img/chapter3/ex16.jpg)

Main() 메소드의 특징을 정리해보자.

- 자바 응용프로그램의 실행은  main() 메소드부터 시작한다.

- Main() 메소드는 public 속성이다.

  public 속성은 메소드가 다른 클래스에서 호출 가능함을 나타낸다. 자바 응용프로그램이 실행을 시작할 때 자바 가상 기계(JVM)에 의해 호출되어야 하므로  public 속성으로 선언되어야 한다.

- Main() 메소드는  static 속성이다.

  main() 메소드는 자신을 포함하는 클래스의 객체가 생성되기 전에, 처음부터 자바 가상 기계에 의해 호출되므로  static 속성으로 선언되어야 한다.

- main() 메소드의 리턴 타입은  void이다.

  아무 값도 리턴하지 않기 때문에 void 타입이다.  main() 메소드르르 끝내기 위해 리턴하려면 단순히 return; 문을 사용하면 된다.

- main() 메소드에는 문자열 배열(String [])이 매개변수로 전달된다.

  자바는 명령행에 입력된 인자들을 문자열 배열로 만들어  main() 메소드에 전달한다.



> main() 메소드의 매개변수

자바에서  main() 메소드의 매개변수에 어떤 값이 어떻게 전달되는지 알아보자. 다음은 Hello 클래스를 실행하는 명령의 사례이다.

```java
C:\>java Hello option1 option2 ... optionN
```

option, option2, ..., optionN 명령행 인자(command line argument)라고 부르며, 이들은 모두  Hello 클래스의 main() 메소드의 매개변수로 전달된다.  
이 과정을 구체적으로 설명하면 아래 그림과 같다. 그림에서는 총 3개의 명령행 인자들이 있다. Hello 클래스의  main() 메소드가 시작되기 전, 이 인자들은 각각 문자열로 만들어지고 문자열(String) 배열에 저장된다.  
그리고 문자열 배열에 대한 레퍼런스가 main()의 매개변수 args에 전달된다. 이런 방식으로 main() 메소드는 명령행 인자들을 전달받는다.  
args를 이용하여 명령행 인자를 전달받는 코드는 다음과 같이 작성할 수 있다.

```java
public static void main(String [] args) {
	String a = args[0];		// a는 "abc"
	String b = args[1];		// b는 "3"
	String c = args[2];		// c는 "5.7"
}
```

![](./img/chapter3/ex17.jpg)

> 이클립스에서  main() 메소드의 인자 전달

main() 메소드에 인자를 전달하기 위해 일부러 명령창을 열고 "java Hello abc 3 5.7"을 입력하는 수고를 할 필요는 없다.  
이클립스에서는 아래 그림과 같이 Run 메뉴의 Run Configurations 메뉴 항목에서  main() 메소드에 전달할 인자를 지정할 수 있다.

![](./img/chapter3/ex18.jpg)



> main()에 명령행 인자를 전달하고 활용하는 예

main(String [] args) 메소드에서  args[0], args[1] 등은 모두 String 타입이므로 필요한 경우 다른 타입으로 변환하여 사용해야 한다.  
명령행 인자의 개수는 args의 length 필드를 이용하여 알 수 있다.  
아래 예제를 통해 구체적인 사용법을 익혀보자. 우선 예제의 소스를 C:\Temp 폴더에 Calc.java 이름으로 저장한다. 그리고 다음과 같이 Calc.java를 컴파일한다.

```bash
C:\Temp>javac Calc.java
```

컴파일이 성공하면, 다음 명령을 입력하여  Calc를 실행시킨다.

```bash
C:\Temp>java Calc 2 20.5 88.1
```

Calc 클래스의 main() 메소드에는 "2", "20.5", "88.1" 문자열을 포함하는 배열로 만들어져 전달되고,  main() 메소드는 각 문자열을 실수로 변환하여 모두 더한 후 출력한다.

```java
public class Calc {
	public static void main(String[] args) {
    double sum = 0.0;
    
    for (int i=0; i<args.length; i++)			// 인자 개수만큼 반복
      sum += Double.parseDouble(args[i]);			// 문자열을 실수(double 타입)로 변환하여 합산
    
    System.out.println("sum = " + sum);
  }
}
```



## 자바의 예외 처리

> 예외(Exception)란?

자바에서 오동작이나 결과에 악영향을 미칠 수 있는 실행 중 발생한 오류를 예외(exception)라고 한다. 문법에 맞지 않게 작성된 코드는 사전에 컴파일러에 의해 컴파일 오류(compile time error)로 걸러지지만, 예외는 사용자의 잘못된 입력이나 배열의 인덱스가 배열의 크기를 넘어가는 등, 예기치 못한 상황에 의해 프로그램 실행 중에 발생한다.  
실행 중에 예외가 발생하는 몇 가지 경우를 나열해보자.

- 정수를 0으로 나누는 경우
- 배열의 크기보다 큰 인덱스로 배열의 원소를 접근하는 경우
- 존재하지 않는 파일을 읽으려고 하는 경우
- 정수 입력을 기다리는 코드가 실행되고 있을 때, 사용자가 문자를 입력한 경우

실행 중에 예외가 발생하면 자바 플랫폼이 가장 먼저 알게 되어, 현재 실행 중인 응용프로그램에게 예외를 전달한다.  
만일 응용프로그램이 예외에 대처하는 코드를 가지고 있지 않다면, 자바 플랫폼은 응용프로그램을 곧바로 종료시킨다.



> 예외 발생 사례

실제 예외가 발생하는 사례를 들어보자. 아래 예제는 0으로 나누기를 실행할 때 예외가 발생하여 응용프로그램이 강제로 종료되는 경우를 보여준다.

```java
import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int dividend;		// 나뉨수
    int divisor;		// 나눗수
    
    System.out.print("나뉨수를 입력하시오:");
    dividend = scanner.nextInt();		// 나뉨수 입력
    System.out.print("나눗수를 입력하시오:");
    divisor = scanner.nextInt();		// 나눗수 입력
    System.out.println(dividend+"를 "+ divisor + "로 나누면 몫은 " + dividend/divisor + "입니다.");
    scanner.close();
  }
}
```



실행 결과

```java
나뉨수를 입력하시오:100
나눗수를 입력하시오:0
Exception in thread "main" java.lang.ArithmeticException: / by zero
at DivideByZero.main(DivideByZero.java:14)
```

위 예제를 실행하고 100과 0을 입력하면 라인 14의 dividend/divisor를 실행하는 도중,  JVM은 정수를 0으로는 나눌 수 없기 때문에  ArithmeticException 예외를 발생시킨다.  
예제 프로그램은 이 예외에 대한 대처 코드가 없기 때문에 자바 플랫폼에 의해 강제 종료된다. 예제의 실행 오류 메시지는 발생한 예외의 종류가 ArithmeticException임을 알려준다.  
사용자가 0을 입력하는 예외 상황은 컴파일 시에 미리 걸러낼 수 없다. 다만, 예외가 발생할 때 응용프로그램이 이에 적절히 대응함으로써(handling) 강제 종료되지 않고 사용자의 입력을 다시 받는 등 별도의 조치를 취할 수 있다.  
이제, 예외가 발생할 때 이에 적절히 대응하는 코드를 작성해보자.

> 예외 처리,  try-catch-finally 문

예외 처리란, 개발자가 작성한 프로그램의 실행 중에 예외가 발생하면 이에 대응하는 것을 말한다.  
자바는 예외 처리를 위해 try-catch-finally 문을 사용한다. 사용법은 다음과 같다.

```java
try {
	예외가 발생할 가능성이 있는 실행문(try 블록)	
}
catch (처리할 예외 타입 선언) {
  예외 처리문(catch 블록)
}
finally {
  예외 발생 여부와 상관없이 무조건 실행되는 문장(finally 블록)(*생략 가능)
}
```

예외가 발생할 가능성이 있는 실행문들을  try { } 블록으로 묶고, 예외 처리 코드는 catch { } 블록 내에 작성한다.  
catch( ) 문의  ( ) 안에는 처리하고자 하는 예외의 타입을 선언한다. catch { } 블록은 예외마다 하나씩 작성되어야 한다.  
아래 그림은 try 블록에서 정상적인 경우와 예외가 발생한 경우, 실행 과정을 대비하여 보여준다.  
try 블록에서 예외가 발생하면 응용프로그램은 남은 실행문을 실행하지 않고 바로 catch 블록의 예외 처리문으로 점프하여 실행한다. 물론 발생한 예외의 타입과 일치하는  catch( ) 블록으로 점프한다.

![](./img/chapter3/ex19.jpg)

finally { } 블록은 생략해도 상관없으며 실제 많은 경우 생략한다.  finally 블록은 예외가 발생하든 하지않든 마지막에 반드시 실행된다.



> 자바의 예외 클래스

응용프로그램에서는 자바 플랫폼에서 제공하는 예외 클래스를 이용하여 예외 발생을 탐지할 수 있다. 자주 활용되는 예외 클래스는 아래 표와 같다.  
실행 중  try 블록 내에ㅐ서 예외가 발생되면, 자바 플랫폼은  catch( ) 문의 '처리할 예외 타입 선언'부에 객체로 만들어 전달한다. 예외 객체는 발생한 예외에 대한 정보를 제공한다.

![](./img/chapter3/ex20.jpg)

다음은 배열의 범위를 벗어나 배열의 원소를 접근할 때 발생하는 ArrayIndexOutOfBoundException 예외를 처리하는 예이다.

```java
int intArray [] = new int[5];			// 인덱스는 0~4까지 가능
try {
	intArray [3] = 2;		// 예외 발생하지 않음
	intArray [6] = 5;		// 예외 발생	<-	이 문장 실행 시 ArrayIndexOutOfBoundException 예외 발생
}
catch (ArrayIndexOutOfBoundException e) {		// 객체 e에 예외 정보가 넘어옴
	System.out.println("배열의 범위를 초과하여 원소를 접근하였습니다.")
}
```

다수의 예외를 처리하고자 하는 경우에는 여러 개의  catch 블록을 연속으로 작성할 수 있으며, 발생한 예외와 타입이 일치하는 catch 블록이 실행된다. 만일 발생한 예외 타입과 일치하는 catch 블록이 없으면 프로그램은 강제 종료된다.  
catch 블록 내에서  System.exit(0)을 호출하면 언제든지 프로그램을 종료할 수 있다.

- 0으로 나눌 때 발생하는  ArithmeticException 예외 처리

  ```java
  import java.util.Scanner;
  
  public class DevideByZeroHandling {
  	public static void main (String[] args) {
      Scanner scanner = new Scanner(System.in);
      
      while (true) {
        System.out.print("나뉨수를 입력하시오:");
        int dividend = scanner.nextInt();		// 나뉨수 입력
        System.out.print("나뉨수를 입력하시오:");
        int divisor = scanner.nextInt();		// 나눗수 입력
        try {
          System.out.println(dividend + "를 " + divisor + "로 나누면 몫은 "
                             + dividend/divisor + "입니다.");
          break;		// 정상적인 나누기 완료 후 while 벗어나기
        }
        catch (ArithmeticException e) {		// ArithmeticException 예외 처리 코드
          System.out.println("0으로 나눌 수 없습니다! 다시 입력하세요");
        }
      }
    }
    scanner.close();
  }
  ```

  실행 결과

  ```java
  나뉨수를 입력하시오:100
  나눗수를 입력하시오:0
  0으로 나눌 수 없습니다! 다시 입력하세요.
  나뉨수를 입력하시오:100
  나눗수를 입력하시오:5
  100을 5로 나누면 몫은 20입니다.
  ```

- 범위를 벗어난 배열의 접근(ArrayIndexOutOfBoundsException)

  ```java
  public class ArrayException {
  	public static void main (String[] args) {
      int[] intArray = new int[5];
      intArray[0] = 0;
      try {
        for (int i=0; i<5; i++) {
          intArray[i+1] = i+1 + intArray[i];		// i=4인 경우 예외 발생
          System.out.println("intArray[" + i +"]" + "=" + intArray[i]);
        }
      }
        catch (ArithmeticException e) {
          System.out.println("배열의 인덱스가 범위를 벗어났습니다.");
        }
    }
  }
  ```

  실행 결과

  ```java
  intArray[0]=0;
  intArray[1]=1
  intArray[2]=3
  intArray[3]=6
  배열의 인덱스가 범위를 벗어났습니다.
  ```

- 입력 오류 시 발생하는 예외(InputMismatchException)

  ```java
  import java.util.Scanner;
  import java.util.InputMismatchException;
  
  public class InputException {
  	public static void main (String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("정수 3개를 입력하세요");
      int sum=0, n=0;
      for(int i=0; i<3; i++) {
        System.out.print(i+">>");
        try {
          n = scanner.nextInt();		// 정수 입력
        }
        catch(InputMismatchException e) {
          System.out.println("정수가 아닙니다. 다시 입력하세요!");
          scanner.nextLine();		// 현재 입력 스트림에 남아 있는 토큰을 지운다.
          i--;	// 인덱스가 증가하지 않도록 미리 감소
          continue;		// 다음 루프
        }
        sum += n;		// 합하기
      }
      System.out.println("합은 " + sum);
      scanner.close();
    }
  }
  ```

  실행 결과

  ```
  정수 3개를 입력하세요
  0>>5
  1>>R
  정수가 아닙니다. 다시 입력하세요!
  1>>4
  2>>6
  합은 15
  ```

- 정수가 아닌 문자열을 정수로 변환할 때 예외 발생(NumberFormatException)

  ```java
  public class NumException {
  	public static void main (String[] args) {
      String[] stringNumber = {"23", "12", "3.141592", "998"};
      
      int i=0;
      try {
        for (i=0; i<stringNumber.length; i++) {
          int j = Integer.parseInt(stringNumber[i]);
          System.out.println("정수로 변환된 값은 " + j);
        }
      }
      catch (NumberFormatException e) {
        System.out.println(stringNumber[i] + "는 정수로 변환할 수 없습니다.");
      }
    }
  }
  ```

  실행 결과

  ```java
  정수로 변환된 값은 23
  정수로 변환된 값은 12
  3.141592는 정수로 변환할 수 없습니다.
  ```

  
