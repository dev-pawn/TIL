# Day 6



## For Loops

for문은 아래와 같이 사용하며 각각의 아이템에 placeholder라는 변수로 접근할 수 있다.

```python
websites = (
	"google.com",
    "airbnb.com",
    "twitter.com",
    "facebook.com"
    "tictok.com"
)

for placeholder in websites:
    print("hello")
```



## URL Formatting

```python
websites = (
	"google.com",
    "airbnb.com",
    "https://twitter.com",
    "facebook.com"
    "https://tictok.com"
)

for website in websites:
	if not website.startwith("https://"):
        website = f"https://{website}"
    print(website)
                             
                             
```

