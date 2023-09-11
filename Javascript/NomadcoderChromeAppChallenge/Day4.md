# Day 4



## The Document Object

Document Object를 통해서 html의 정보를 가져올 수 있음

```javascript
document.title						// html title 값을 가져옴.
document.title = "change title"		//html title의 값을 change title로 변경
document.body						//html의 body 값을 가져옴.
```



## HTML in Javascript

getElementById란 함수를 통해  id로 element를 가져올 수 있다.

```javascript
document.getElementById("title")		// html에서 id가 "title"인 html element를 가져옴

const title = document.getElementById("title")
title.innerText = "Got you!";			// html element의 innerText 값을 "Got you!"로 수정
```



## Searching For Elements



```javascript
const hellos = document.getElementByClassName("hello")
// classname이 "hello"인 element를 가져옴

const title = document.getElement.ByTagName("h1")
// tag가 "h1"인 element를 가져옴

const title = document.querySelector(".hello h1")
// css 방식으로 element를 검색해서 가져올 수 있음
// 만약 가져올 값이 여러 개일 경우 제일 첫 번째 element만 가져옴
// 여러개의 값을 가져오고 싶을 경우 querySelectorAll을 사용해야함
```



## Events



```
```

