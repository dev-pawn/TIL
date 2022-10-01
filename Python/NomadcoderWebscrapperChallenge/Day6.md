# Day 6



## For Loops

for문은 아래와 같이 사용하며 각각의 아이템에 placeholder라는 변수로 접근할 수 있다.

```python
websites = (
	"google.com",
    "airbnb.com",
    "twitter.com",
    "facebook.com"
    "tiktok.com"
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
    "https://tiktok.com"
)

for website in websites:
	if not website.startswith("https://"):
        website = f"https://{website}"
    print(website)                    
```



## Requests

파이썬에는 수많은 사용자 패키지가 있으며 원하는 패키지를 추가로 설치하여 사용할 수 있음

[Python Package Index](pypi.org)

우리는 여기서 Requests라는 패키지를 설치해서 사용할거임



## Status Codes

[HTTP상태코드](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)

```python
from requests import get

websites = (
	"google.com",
    "airbnb.com",
    "https://twitter.com",
    "facebook.com"
    "https://tiktok.com"
)

for website in websites:
	if not website.startswith("https://"):
        website = f"https://{website}"
    response = get(website)
    if response.status_code == 200:
        print(f"{website} is OK")
    else:
        print(f"{website} not OK")
```



>  결과물을 dicts에 담고 한번에 출력하기

```python
from requests import get

websites = (
	"google.com",
    "airbnb.com",
    "https://twitter.com",
    "facebook.com"
    "https://tiktok.com"
)

result = {}

for website in websites:
	if not website.startswith("https://"):
        website = f"https://{website}"
    response = get(website)
    if response.status_code 200:
        result[website] = "OK"
    else:
        result[website] = "FAILED"
        
print(results) 
```



> 200번을 제외한 응답도 처리하기

```python
from requests import get

websites = (
	"google.com",
    "airbnb.com",
    "https://twitter.com",
    "facebook.com"
    "https://tiktok.com"
)

result = {}

for website in websites:
	if not website.startswith("https://"):
        website = f"https://{website}"
    response = get(website)
    if response.status_code >= 500:
        results[website] = "Server Error"
    elif response.status_code >= 400:
        results[website] = "Client Error"
	elif response.status_code >= 300:
    	results[website] = "Redirection"
	elif response.status_code >= 200:
    	results[website] = "OK"
	elif response.status_code >= 100:
    	results[website] = "Informational Response"
	else:
    	results[website] = "FAILED"    
print(results) 
```

