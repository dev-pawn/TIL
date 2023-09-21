# Chapter 2 자바 기본 프로그래밍



## 목차

- 자바 프로그램의 구조
- 식별자
- 자바의 데이터 타입
- 자바에서 키 입력
- 연산
- 조건문



## 자바 프로그램의 구조



```java
/*
*  소스 파일 : Hello.java
*/

public class Hello {                                              // 클래스
    
    public static int sum(int n, int m) {                         // 메소드
        return n + m;                                             
    }                                                             
    
    // main() 메소드에서 실행 시작
    public static void main(String args[]){                       // 메소드
        int i = 20;
        int s;
        char a;
        
        s = sum(i, 10);                   // 메소드 호출
        a = '?';
        System.out.println(a);            // 문자 '?' 출력
        System.out.println("Hello");      // "Hello" 문자열 출력
        System.out.println(s);            // 정수 s 값 30 출력
    }
}
```

- 클래스 만들기

  자바 프로그램 작성에서 가장 중요하고 기본적인 것은 클래스를 만들고 , 그 안에 변수, 상수, 함수(메소드) 등 모든 프로그램 요소를 작성한다는 것이다.  
  클래스 바깥에 어떤 것도 작성해서는 안 된다.  
  class 키워드로 클래스 이름을 선언하고 {} 사이에 필드(변수)와 메소드(함수) 코드를 작성한다.  
  public은 __접근 지정자(access specifier)__ 로서 다른 모든 클래스에서 해당 클래스를 자유롭게 사용할 수 있다는 의미이다.

  

- 주석문

  주석문은 실제 프로그램의 실행에 영향을 미치지 않으며, 프로그램에 대한 설명이나 특이사항을 기록하기 위해 사용한다.  
  주석문은 두 가지 방법을 이용해 만들수 있다.

  ```java
  // 한 라인 주석 한 행이 끝날때까지 주석 처리
  
  /*
  여러 라인 주석으로 /*으로 시작하여 */까지 주석처리
  2줄
  3줄
  */ 
  ```

  

- main() 메소드

  자바 프로그램은 항상 main() 메소드에서부터 실행을 시작한다.  
  메인은 반드시 public, static, void 타입으로 선언되어야 하며, 한 클래스에는 두 개 이상의 main()을 작성하면 안된다.  
  여러 개의 클래스로 자바 프로그램이 이루어졌을 경우, 실행을 시작할 클래스에만 main()을 두면 되므로, 모든 클래스가 main()을 가지지는 않는다.

  

- 메소드

  클래스의 맴버 함수를 자바에서는 __메소드(method)__라고 부른다. 메소드의 이름은 개발자가 지정하며, 메소드의 개수는 제한이 없다. 

  다음은 메소드 sum()을 호출하는 코드이다.

  ```java
  int i = 20;
  s = sum(i, 10);
  ```

  이 코드는 변수 i의 값 20과 정수 10을 sum()의 매개변수 n, m에 각각 전달한다.  
  메소드 sum()은 n과 m 값을 더해서 30을 리턴하고 그 결과 s에는 30이 저장된다.

  

- 변수 선언

  변수(variable)란 프로그램 실행 동안 데이터를 저장하는 공간으로 개발자가 이름을 붙이고 다음과 같이 선언한다.

  ```java
  int i;
  char a;
  ```

  메소드 내에 선언되어 사용되는 변수를 <b>지역변수</b>(local variable)라고 한다. 지역변수는 메소드 내에서만 사용되며, 메소드의 실행이 끝나면 소멸된다.  
  다음과 같이 선언하면 선언과 동시에 값을 초기화 할 수 있다.

  ```java
  int i = 20;	//선언과 동시에 초기화
  ```

  

- 문장

  자바에서 모든 문장은 다음과 같이 ';'로 끝나야 한다.

  ```java
  int i = 20;
  s = sum(i, 20);
  ```

  자바 컴파일러는 ';'를 문장의 끝으로 인식하므로 한 문장이 반드시 한 줄에 작성될 필요는 없다. 예를 들어 아래와 같이 작성해도 정상적인 문장으로 인식한다.

  ```java
  s = sum(i,
  20);
  ```

  

- 화면 출력

  정수, 문자, 문자열 등 데이터를 화면에 출력하기 위해 <b>System.out.println()</b> 이나 <b>System.out.print()</b> 를 이용하면 된다.  
  System.out.println()은 출력 후 다음 행으로 이동하지만, System.out.print()는 다음 줄로 넘어가지 않는다.

  ```java
  System.out.println("Hello");			// "Hello" 문자열 출력
  System.out.println(3);						// 3 출력
  System.out.println(2*5);					// 10 출력
  ```




## 식별자

<b>식별자</b>(identifier)란 클래스, 변수, 상수, 메소드 등에 붙이는 이름을 말한다.



> 식별자 이름 규칙

자바에서 식별자(이름)를 만들 때 다음 규칙이 준수 되어야 한다.

- 특수문자(%, *, &, @, ^ 등), 공백(탭, space 등)은 식별자로 사용할 수 없으나, '_', '$'는 예외로 사용할 수 있다.
- 한글도 식별자로 사용 가능하다.
- if, while, class 등 자바 언어의 키워드는 식별자로 사용할 수 없다.
- 식별자의 첫번째 문자로 숫자는 사용할 수 없다.
- true, false, nulld은 자바의 키워드이므로 식별자로 사용할 수 없다.
- '_'와 '$'는 식별자의 첫 번째 문자로 사용할 수 있으나, <b>일반적으로 잘 사용하지 않는다.</b>
- 대소문자를 구별한다.
- 길이 제한이 없다.



> 자바 키워드

<b>자바 키워드</b>란 자바에서 이미 그 용도가 정해진 것으로 <b>예약어</b>(reserved word)라고도 하며, 식별자의 이름으로 사용할 수 없다. 자바의 예약어는 아래와 같다.

| abstract | continue | for        | new       | switch       |
| -------- | -------- | ---------- | --------- | ------------ |
| assert   | default  | if         | package   | synchronized |
| boolean  | do       | goto       | private   | this         |
| break    | double   | implements | protected | throw        |
| byte     | else     | import     | public    | throws       |
| case     | enum     | instanceof | return    | transient    |
| catch    | extends  | int        | short     | try          |
| char     | final    | interface  | static    | void         |
| class    | finally  | long       | strictfp  | volatile     |
| const    | float    | native     | super     | while        |



> 좋은 이름 붙이는 관습

- 목적에 맞는 이름 붙이기

- 이름의 길이에 연연하지 말고 충분히 긴 이름으로 붙이기

- 이름을 붙이는 <b>언어의 관습</b> 따르기

  - 클래스 이름

    클래스 이름의 첫 번째 문자는 <b>대문자</b>로 시작하고, 여러 단어가 복합되면 각 단어의 첫 번째 문자만 대문자로 표시한다.

    ```java
    public class HelloWorld()
    class AutoVendingMachine()
    ```

    - 변수, 메소드 이름

      변수와 메소드이름은 첫 단어는 <b>소문자</b>로 표기하고 이후 각 단어의 첫 번재 문자만 대문자로 표기한다.  
      이렇게 함으로써, 변수와 클래스를 쉽게 구분할 수 있다.

      ```java
      int myAge;
      boolean isSingle;
      public int getAge() {return 20;}
      ```

    - 상수 이름

      <b>상수</b>는 이름 전체를 <b>대문자</b>로 표기하도록 권장한다. 다음은 상수 PI를 선언하는 예이다. 상수는 다음 절에서 설명한다.

      ```
      final double PI = 3.141592;
      ```



> 자바의 데이터 타입

<b>데이터 타입</b>(data type)이란 자바에서 다룰 수 있는 데이터의 종류를 말한다. 자바 언어는 다음과 같이 총 <b>9개</b> 타입의 데이터를 다룰 수 있다.

- 기본 타입(basic type): 8개

  - boolean
  - char
  - byte
  - short
  - int
  - long
  - float
  - double

- 레퍼런스 타입(reference type): 1개

  레퍼런스 타입은 한 가지이지만 용도는 3가지이다.

  - 배열에 대한 레퍼런스
  - 클래스(class)에 대한 레퍼런스
  - 인터페이스(interface)에 대한 레퍼런스

  레퍼런스란 C/C++의 포인터와 비슷한 개념이다. 그러나 C/C++와 달리 실제 주소 값을 가지지 않는다.



> 자바의 기본 타입

![](./img/Chapter2/2-2.jpg)

[그림 2-2]는 자바의 <b>기본 타입</b>과 메모리 공간, 데이터 값의 범위를 보여준다.  
정수를 저장하는 타입은 byte, short, int, long의 4개이고, 실수는 float, double의 두 타입을 사용한다.  
자바에서는 영어 한글 상관없이 문자 하나는 <b>2바이트의 유니코드</b>로 저장된다.  
이것은 영어는 1바이트 한글은 2바이트로 표현되는 C/C++과는 다르게 문자를 처리하는데 있어 자바가 가지고 있는 대단한 강점이다.  
한편 <b>문자열</b>은 자바의 기본 타입에 속하지 않기 때문에, 다음과 같이 자바 라이브러리에서 제공하는 <b>String 클래스</b>를 이용한다.

```java
String strName = "kihyun";
```



> 문자열

자바에서 문자열은 기본 타입에 속하지 않으며 JDK에서 제공하는 <b>String</b>클래스를 이용한다.

```java
String toolName = "JDK";
```

자바에서는 문자열과 기본 타입의 + 연산이 실행되면, <b>기본 타입의 값이 문자열로 바뀌고 두 문자열이 연결된 새로운 문자열이 생성된다.

```java
toolName + 1.8								-> "JDK1.8"
"(" + 3 + "," + 5 + ")"				-> "(3,5)"
System.out.println(toolName + "이 출시됨");	// "JDK1.8이 출시됨" 출력
```



>  변수와 선언

변수는 데이터를 저장하는 공간이며, 변수를 선언하면 데이터 타입 크기의 메모리가 할당된다.

- 변수 선언

  자바에서는 [그림 2-3]과 같이 데이터 타입과 이름으로 변수를 선언한다.

  ![](./img/Chapter2/2-3.jpg)

  같은 타입의 변수를 여러 개 선언 하려면 다음과 같이 콤마로 분리하며 된다.

  ```java
  char c1, c2, c3;					// 3개의 문자 변수 c1, c2, c3 선언
  ```

- 변수 선언과 동시에 초기화

  ```java
  int radius = 10;
  char c1 = 'a', c2 = 'b', c3 = 'c';
  double weight = 75.56;
  ```

- 변수 읽기와 저장

  변수를 선언한 후에는 다음과 같이 변수에 값을 저장하고 읽을 수 있다.

  ```java
  radius = 10 * 5;					// 변수 radius에 10x5의 결과 50 저장
  c1 = 'r';									// 변수 c에 문자 'r' 저장
  weight = weight + 5.0;		// 변수 weight의 값을 읽고 5.0을 더해 weight에 다시 저장
  ```



> 리터럴

리터럴이란 프로그램에 직접 표현한 값을 말한다. 정수, 실수, 문자, 논리, 문자열 타입 모두 리터럴이 있으며, 예를 들면 다음과 같다.

```java
34, 42.195, '%', true, "hello"
```

- 정수 리터럴

  정수 리터럴은 아래 표와 같이 4가지 유형이 있으며 변수와 함께 사용하면 다음과 같다.

  ```java
  int n = 15;						// 십진수 15
  int m = 015;					// 015는 8진수로서 십진수 13
  int k = 0x15;					// 0x15는 16진수로서 십진수 21
  int b = 0b0101;				// 0b0101은 2진수로서 십진수 5
  ```

  정수 리터럴은 int 타입으로 자동 컴파일 된다. 만일 long 타입으로 지정하려면 숫자 뒤에 L 또는 l을 붙이면 된다.

  ```java
  long g = 24L; // 24L은 24l과 동일
  ```

  | 유형   | 설명                   | 사례                         |
  | ------ | ---------------------- | ---------------------------- |
  | 10진수 | 0으로 시작하지 않는 수 | 15 -> 10진수 15              |
  | 8진수  | 0으로 시작하는 수      | 015 -> 10진수 13(1*8+5=13)   |
  | 16진수 | 0x로 시작하는 수       | 0x15 -> 10진수 21(1*16+5=21) |
  | 2진수  | 0b로 시작하는 수       | 0b0101 -> 10진수 5           |

- 실수 리터럴

  실수 리터럴은 소수점 형태나 지수(exponent) 형태로 다음과 같이 실수를 표현한 값이다.

  ```java
  12.	12.0	.1234, 0.1234, 1234E-4
  ```

  실수 리터럴은 double 타입으로 자동 처리되며, 변수와 함께 쓰면 다음과 같다.

  ```java
  double d = 0.1234;
  double e = 1234E-4;		// 1234E-4 = 1234X1/10000이므로 0.1234와 동일
  ```

  숫자 뒤에 f나 F를 붙이면 float, d나 D를 붙이면 double 타입으로 강제 변환할 수 있다.

  ```java
  float f =0.1234f;			// f = 0.1234로 하면 컴파일 오류
  double w = .1234D;		//.1234D와 .1234는 동일
  ```

- 문자 리터럴

  문자 리터럴은 <b>단일 인용부호</b>('')로 문자를 표현하거나 \u 다음에 문자의 유니코드 값을 사용하여 표현한다.

  ```java
  'w', 'A', '가', '*', '3', '글', \u0041
  ```

  문자 리터럴을 변수와 함께 쓰면 다음과 같다.

  ```java
  char a = 'A';
  char b = '글';
  char c = \u0041;		// 문자 'A'의 유니코드 값(0041) 사용
  char d = \uae00;		// 문자 '글'의 유니코드 값(ae00) 사용
  ```

  특수문자 리터럴도 있다. 백슬래시(\\\) 다음에 특수 기호를 붙여서 표현한다. 특수 문자를 이스케이프 시퀸스(escapse sequence)라고도 하며 그 종류는 아래 표와 같다.

  | 종류 | 의미                  | 종류   | 의미                         |
  | ---- | --------------------- | ------ | ---------------------------- |
  | '\b' | 백스페이스(backspace) | '\r'   | 캐리지 리턴(carriage return) |
  | '\t' | 탭(tab)               | '\\\"' | 이중 인용부호(double quote)  |
  | '\n' | 라인피드(line feed)   | '\\\'' | 단일 인용부호(single quote)  |
  | '\f' | 폼피드(form feed)     | '\\\\' | 백슬레시(backslash)          |

- 논리 리터럴과 boolean 타입

  논리 리터럴은 true, false 두 개 밖에 없으며, boolean 타입의 변수에 직접 치환하거나 조건문에 사용한다.

  ```java
  boolean a = true;
  boolean b = 10 > 0;				// 10>0가 참이므로 b 값은 true;
  boolean c = 1;						// 타입 불일치 오류. C/C++와 달리 자바에서 숫자를 참, 거짓으로 사용 불가
  while (true) {						// 자바에서 무한 루프. while(1)로 하면 안됨
  	...
  }
  ```

- var

  Java 10부터 <b>지역 변수를 선언할 때</b> 변수의 타입 대신 <b>var 키워드</b>를 사용할 수 있다.

  ```java
  var price = 200;									// price는 int 타입으로 결정
  var name = "kihyun";							// name은 String 타입으로 결정
  var pi = 3.14;										// pi는 double 타입으로 결정
  var point = new Point();					// point는 Point 타입으로 결정
  var v = new Vector<Integer>				// v는 Vector<integer> 타입으로 결정
  ```

  하지만 변수 선언문에 초깃값이 주어지지 않으면 다음과 같이 오류가 발생한다.

  ```
  var name; 					// 컴팡리 오류
  ```

  또한 var의 사용은 지역 변수에만 한정된다.



> 상수

상수를 만드는 방법은 변수 선언 시 <b>final 키워드</b>를 사용하면 된다. 상수는 변수와 달리 실행 중에 값을 바꿀 수 없다.



> 타입 변환

타입 변환이란 변수나 상수 혹은 리터럴의 타입을 다른 타입으로 바꾸는 것을 말한다.

- 자동 타입 변환

  다음과 같이 치환문(=)이나 수식 내에서 타입이 일치하지 않을 때, 컴파일러는 오류대신 <b>작은 타입을 큰 타입으로 자동 변환</b>한다.

  ```java
  long m = 25;						// 리터럴 25는 int 타입. 25가 long 타입으로 자동 변환
  double d = 3.14 * 10;		// 실수 연산을 하기 위해 10이 10.0으로 자동 변환
  ```

- 강제 타입 변환

  강제 타입 변환은 개발자가 강제로 타입 변환을 지시하는 경우이다.

  ```java
  int n = 300;
  byte b = n;					// 컴파일 오류. int 타입은 byte 타입으로 자동 변환 안 됨
  ```

  변수 n에 저장된 값 300은 byte 타입의 범위보다 크기 때문에 b에 300이 저장되지 않고 256을 뺀 나머지 값 44가 저장된다.  
  이처럼 큰 타입의 값을 작은 타입의 값으로 변환해야 할 때, 컴파일러는 자동 변환 대신 컴파일 오류를 발생시킨다.  
  개발자가 이 사실을 알고도 타입 변환을 원한다면, 다음과 같이 () 안에 타입을 명시하여 <b>강제 타입 변환</b>을 지시해야 한다.

  ```java
  byte b = (byte)n;				// n을 byte 타입으로 강제 변환. b = 44
  ```

  하지만, 강제 변환을 하면 컴파일 오류가 발생하지만 않을 뿐 여전히 44가 저장되어 <b>데이터 손실</b>이 발생한다.  
  강제 타입 변환을 <b>캐스팅(casting)</b>이라고도 부른다.



## 자바에서 키 입력

> System.in

System.in은 키보드 장치를 직접 제어하고 키 입력을 받는 <b>표준 입력 스트림</b> 객체이다.  
하지만 System.in은 입력된 키를 단순한 바이트 정보로 응용프로그램에게 제공하므로, 응용프로그램은 받은 바이트 정보를 문자나 숫자로 변환해야 하는 번거로움이 있다.



> Scanner를 이용한 키 입력

Scanner는 응용프로그램이 키 입력을 쉽게 받을 수 있도록 자바 패키지에서 제공하는 클래스이다.  
Scanner를 이용해서 키 입력을 받는 방법을 알아보자.

- Scanner 객체 생성

  우선 다음과 같이 Scanner 객체를 생성한다.

  ```java
  Scanner scanner = new Scanner(System.in);
  ```

  이 생성문에 의해 [그림 2-6]과 같은 구조가 이루어지고, scanner 객체는 System.in 객체를 이용하여 키보드로부터 일련의 바이트 정보들을 입력받고, 이 바이트들을 정수, 실수, 문자, 문자열 등 자바 응용프로그램이 원하는 타입으로 변환하여 리턴한다.

  ![](./img/Chapter2/2-6.jpg)

- Import 문 사용

  Scanner 클래스는 자바에서 제공되는 java.util 패키지에 있으므로, 이 import 문을 통해 Scanner의 경로명이 java.util.Scanner 임을 나타낸다.

- Scanner 클래스로 키 입력받기

  scanner 클래스는 사용자가 입력하는 키 값을 공백 문자(' ','\t','\n')를 기준으로 분리하여 <b>토큰 단위</b>로 읽는다.

  ![](./img/Chapter2/2-7.jpg)

  Scanner 클래스를 이용하여 키 입력을 받을 때 아래의 메소드를 사용한다.

  ```java
  String next()								// 다음 토큰을 문자열로 리턴
  byte nextByte()							// 다음 토큰을 byte타입으로 리턴
  short nextShort()						// 다음 토큰을 short 타입으로 리턴
  int nextInt()								// 다음 토큰을 int 타입으로 리턴
  long nextLong()							// 다음 토큰을 long 타입으로 리턴
  float nextFloat()						// 다음 토큰을 float 타입으로 리턴
  double nextDouble()					// 다음 토큰을 double 타입으로 리턴
  boolean nextBoolean()				// 다음 토큰을 boolean 타입으로 리턴
  String nextString()					// 다음 토큰을 String 타입으로 리턴
  void close()								// Scanner의 사용 종료
  boolean hasNext()						// 현재 입력된 토큰이 있으면 true, 아니면 입력 때까지 무한정 대기, 새로운 입력이 들어올 때
  														// true 리턴, crtl-z 키가 입력되면 입력 끝이므로 false 리턴
  ```

  다음은 [그림 2-7]과 같이 사용자가 키를 입력하였을 때, Scanner 클래스의 메소드를 사용하여 사용자가 입력한 문자열, 정수, 실수 등을 읽는 코드이다.
  
  ```java
  Scanner scanner = new Scanner(System.in);
  String name = scanner.next();														// "Kim"
  String city = scanner.next();														// "Seoul"
  int age = scanner.nextInt();														// 20
  double weight = scanner.nextDouble();										// 65.1
  boolean isSingle = scanner.nextBoolean();								// true
  ```
  
- nextLine()과 next()

  "Seoul Korea"와 같이 공백이 낀 문자열을 입력받기 위해서는 Scanner 클래스의 <b>nextLine()</b>을 이용하면 된다. <b>next()</b>로는 공백이 낀 문자열을 읽을 수 없다. 위 경우 next()는 "Seoul"만 문자열로 리턴한다.  
또한 nextLine()은 엔터키의 입력을 기다리는 용도로도 사용할 수 있다.  
  다른 입력 없이 엔터키만 입력될 때, nextLine()은 빈 문자열("")을 리턴하면서 바로 돌아오지만, next()를 사용하게 되면, 엔터키를 계속 입력하여도 문자열이나 숫자 등 다른 키가 입력될 때까지 기다린다. next()는 결코 빈 문자열("")을 리턴하지 않는다.

- Scanner 객체 닫기

  scanner 객체의 사용을 종료하려면 다음과 같이 닫아 준다.

  ```java
  scanner.close();
  ```



## 연산



## 조건문

자바의 조건문은 C/C++과 동일하며 다음과 같은 종류가 있다.

```
if 문, if-else 문, switch 문
```



> 단순 if 문

![](./img/Chapter2/2-15.jpg)

if 문의 조건식은 비교 연산이나 논리 연산이 혼합된 식으로 구성되며, 조건식의 결과는 boolean 값이다.  
조건식이 참(true)이면 if 내부의 '실행 문장'이 실행되며, 거짓(false)이면 if 문을 벗어난다. 조건식은 boolean 타입의 변수 하나만으로도 가능하다.  
다음은 if 문을 사용하여 정수 n이 짝수인지 판별하는 코드 사례이다. n을 나눈 나머지가 0이면 n은 짝수이다.

```java
if(n%2 == 0) {
	System.out.println(n + "은 짝수입니다.");
}
```

if의 실행문이 한 문장인 경우 다음과 같이 중괄호({}) 를 생략해도 된다.

```java
if((score >= 88) && (score <= 89))
	System.out.println("학점은 B입니다.");
```



> If-else 문

if-else 문은 if의 조건식이 참인 경우와 거짓은 경우에 각각 실행할 문장을 지시할 수 있다. 조건식이 true이 실행 문장1을 실행한 후 if-else 문을 벗어나고, false이면 실행 문장2를 실행한 후 if-else 문을 벗어난다.

![](./img/Chapter2/2-16.jpg)

정수 n이 짝수인지 홀수인지 구분하는 코드를 if-else 문으로 작성해보자.

```java
if (n%2 == 0) {
	System.out.println(n + "은 짝수입니다.");
}
else {
	System.out.println(n + "은 홀수입니다.")
}
```

if와 else의 실행문이 하나의 문장이면 역시 중괄호를 생략할 수 있다.



> 다중 if-else 문

다중 if-else문은 if-else가 연속되는 것으로 전형적인 모양은 [그림 2-17]과 같다.  
![](./img/Chapter2/2-17.jpg)

위에서부터 '조건식'이 참인 경우, 해당하는 '실행 문장'을 실행한 후 다중 if-else을 벗어난다.



> 중첩 if-else 문

if 문이나 if-else 문, else 문의 '실행 문장' 에, if 문이나 if-else 문을 내포할 수 있다. 아래 예제를 참고해보자.

```java
import java.util.Scanner;
/*
점수와 학년을 입력받아 60점 이상이면 합격, 미만이면 불합격을 출력한다.
4학년의 경우 70점 이상이어야 합격이다.
*/
public class NextedIf {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("점수를 입력하세요(0~100): ");
    int score = scanner.nextInt();
    System.out.print("학년을 입력하세요(1~4): ");
    int year = scanner.nextInt();
    
    if (score >= 60) {
      if(year != 4)
        System.out.println("합격!"); // 4학년 아니면 합격
      else if (score >= 70)
        System.out.println("합격!"); // 4학년이 70점 이상이면 합격
      else
        System.out.println("불합격!"); // 4학년이 70점 미만이면 불합격
    }
    else	// 60점 미만 불합격
      System.out.println("불합격!");
  }
}
```



> switch 문

값에 따라 여러 방향으로 분기하는 경우, if 문보다 <b>switch</b> 문을 사용하면 가독성이 높은 좋은 코드를 작성할 수 있다.

![](./img/Chapter2/2-18.jpg)

switch문은 먼저 '식'을 계산하고 그 결과 값과 일치하는 <b>case 문</b>으로 분기한다. case문의 '실행 문장'을 실행한 후 <b>break</b>를 만나면 switch 문을 벗어난다.  
만일 어떤  case 문으로도 분기하지 못하는 경우 <b>default 문</b>으로 분기하여 '실행 문장 n'을 실행한다. default 문은 생략 가능하며, 실행 문장은 '{' 와 '}'로 둘러싸지 않는다.

```java
import java.util.Scanner;
/*
학점 매기는 코드를 switch 문으로 작성하라.
*/

public class GradingSwitch {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    char grade;
    System.out.print("점수를 입력하세요(0~100): ");
    int score = scanner.nextInt();
    switch (score/10) {
      case 10:		// score = 100
      case 9:			// score = 90~99
        grade = 'A';
        break;
      case 8:			// score = 80~99
        grade = 'B';
        break;
      case 7:			// score = 70~79
        grade = 'C';
        break;
      case 6:			// score = 60~69
        grade = 'D';
        break;
      default:		// score는 59 이하
        grade = 'F';
    }
    System.out.println("학점은 " + grade + "입니다.");
    
    scanner.close();
  }
}
```



- Switch 문 내의 break 문

  switch 문에서 <b>break 문</b>은 중요하다. case의 '실행 문장'이 실행되고 만난 break 문장은 switch 문을 벗어나도록 지시한다.

- case 문의 값

  switch 문은 식의 결과 값을 case 문의 값과 비교한다. case 문의 값은 <b> 정수 리터럴, 문자 리터럴, 문자열 리터럴만</b> 허용한다.

  ```java
  int b;
  switch(b%2) {
    case 1: ...; break;
    case 2: ...; break;
  }
  char c;
  switch(c) {
    case '+': ...; break;
    case '_': ...; break;
  }
  String s = "예";
  switch(s) {
    case "예": ...; break;
    case "아니요": ...; break;
  }
  ```

  case 문에는 다음과 같이 변수나 식은 사용할 수 없다.

  ```java
  int b;
  switch (b) {
    case a : ...; break;					// 오류. 변수 a 사용 안 됨
    case a>3 : ...; break;				// 오류. 식(a>3) 사용 안 됨
    case a == 1 : ...; break;			// 오류. 식(a==1) 사용 안 됨
  }
  ```

  
