# 마크다운(markdown) 문법 가이드

readme.md 등의 .md 파일 작성에 쓰이는 마크다운과 관련 문법을 알아본다.

## 목차

- [들어가며](#들어가며)
- [마크다운 문법이란](#마크다운-문법이란)
- [마크다운 문법](#마크다운-문법)
  - [제목](#제목header)
  - [문단](#문단줄바꿈)
  - [목록](#목록list)
  - [강조](#강조)
  - [인용문](#인용문)
  - [링크](#링크)
  - [이미지 삽입](#이미지-삽입)
- [유용한 사이트](#유용한-사이트)
- [참고 자료](#참고-자료)

## 들어가며

본격적으로 깃허브를 사용하게 되면서 readme.md 파일 작성의 중요성을 느끼게 되었고\
.md파일의 가독성 있는 작성에 필수적으로 이용되는 마크다운문법을 정리하여 익숙하게 사용할 수 있도록 한다.

## 마크다운 문법이란

마크다운은 일반 텍스트 기반의 경량 마크업 언어이다.\
일반 텍스트로 서식이 있는 문서를 작성하는데 사용되며, 읽기도 쉽고 쓰기도 쉬운 서식을 지향하여\
일반적인 마크업 언어(ex.html)에 비해 문법이 쉽고 간단한 것이 특징이다.

## 마크다운 문법

- ### 제목(header)
  총 h1~h6까지 제목을 표현할 수 있다.

```
#~###### 제목
```

h1과 h2는 다음과 같이 표현할 수도 있다.

```
제목(h1)
=====
제목(h2)
-----
```

- ### 문단(줄바꿈)

마크다운은 기본적으로 강제 개행을 인식하지 않는다.\
강제 개행을 인식시키기 위해선 줄 끝에 공백을 두칸 넣거나 역슬레시를 넣어도 된다.

- ### 목록(list)

```sh
순서있음
1. 첫번째
1. 두번째
1. 세번째

순서없음
- 김치
	+ 감자
		* 깍두기

```

순서있음

1. 첫번째
1. 두번째
1. 세번째

순서없음

- 김치

  - 감자
    - 깍두기

- ### 강조

```
**볼드(진하게)**
__볼드(진하게)__
_이텔릭체(기울여서)_
*이텔릭체(기울여서)*
~~취소선~~
```

**볼드(진하게)**
**볼드(진하게)**
_이텔릭체(기울여서)_
_이텔릭체(기울여서)_
~~취소선~~

- ### 인용문

```
> 인용문1
>> 인용문2
>>> 인용문3
```

> 인용문1
>
> > 인용문2
> >
> > > 인용문3

- ### 링크

```
[내용](링크)

이것은 [링크](https://www.naver.com) 입니다.
이것은 [링크](https://www.naver.com "(생략가능)설명문구") 입니다.
이것은 [네이버 링크][1] 입니다.
이것은 [다음 링크][b] 입니다.
이것은 [애플 링크[three] 입니다.
[1] https://www.naver.com "네이버"
[b] https://www.daum.net "다음"
[three] http://www.apple.com/kr/ "애플"
```

이것은 [링크](https://www.naver.com) 입니다.
이것은 [링크](https://www.naver.com "(생략가능)설명문구") 입니다.
이것은 [네이버 링크][1] 입니다.
이것은 [다음 링크][b] 입니다.
이것은 [애플 링크][three] 입니다.

[1]: https://www.naver.com "네이버"
[b]: https://www.daum.net "다음"
[three]: http://www.apple.com/kr/ "애플"

- ### 이미지 삽입

```
![깃헙](https://guides.github.com/images/logo@2x.png  "(생략가능)설명문구")
![깃허브][imggithub]

[imggithub]: https://guides.github.com/images/logo@2x.png  "(생략가능)설명문구"
```

![깃헙](https://guides.github.com/images/logo@2x.png "(생략가능)설명문구")
![깃허브][imggithub]

[imggithub]: https://guides.github.com/images/logo@2x.png "(생략가능)설명문구"

- ### 박스로 감싸기

````
```와 ``` 사이에 글을 씁니다.
````

## 유용한 사이트

<https://stackedit.io/app#>

## 참고 자료

https://thisblogbusy.tistory.com/entry/%EB%A7%88%ED%81%AC%EB%8B%A4%EC%9A%B4Markdown-%EC%9D%B4%EB%9E%80
