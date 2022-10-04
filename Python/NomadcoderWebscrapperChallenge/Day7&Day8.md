# Day 7 & Day 8



## Initial Request

구인구직 사이트로부터 HTML 데이터 받아오기

```python
from requests import get

base_url = "https://weworkremotely.com/remote-jobs/search?term="
search_term = "python"

response = get(f"{base_url}{search_term}")

if response.status_code != 200:
    print("Can't request website")
else:
    print(response.text)
```



## BeautifulSoup

[BeautifulSoupDocs](https://www.crummy.com/software/BeautifulSoup/bs4/doc/)

BeautifulSoup를 이용해서 jobs 클래스의 정보를 받아오기

```python
from requests import get
from bs4 import BeautifulSoup

base_url = "https://weworkremotely.com/remote-jobs/search?term="
search_term = "python"

response = get(f"{base_url}{search_term}")

if response.status_code != 200:
    print("Can't request website")
else:
	soup = BeautifulSoup(response.text, "html.parser")
    jobs = print(soup.find_all('section', class_="jobs"))
```



## Keyword Arguments

위에서 class_="jobs"처럼 argument(class)의 name을 인자와 같이 전달하면 argument를 순서대로 전달하지 않아도 된다.

```python
def say_hello(name, age):
    print(f"Hello {name} you are {age} years old")
    
say_hello("nico", 12)
say_hello(age=12, name="nico")// arguments의 name을 적어주면 인자의 위치는 중요하지않음
```



## Job posts



```python
from requests import get
from bs4 import BeautifulSoup

base_url = "https://weworkremotely.com/remote-jobs/search?term="
search_term = "python"

response = get(f"{base_url}{search_term}")

if response.status_code != 200:
    print("Can't request website")
else:
	soup = BeautifulSoup(response.text, "html.parser")
    jobs = print(soup.find_all('section', class_="jobs"))
    for job_section in jobs:
        job_posts = job_section.find_all('li')
        job_posts.pop(-1)						// 리스트의 마지막에 포함되는 view-all을 제거
        for post in job_posts:
            print(post)
            print("///////////////////")
```



## Job Extraction

list의 각 요소를 변수로 만들기 위해서는 아래 방법을 사용할 수 있다.

```python
list_of numbers = [1, 2, 3]

first = list_of_numbers[0]
second = list_of_numbers[0]			// 이렇게 각 요소를 하나 하나 변수로 만들수도 있지만
first, second, third = list_of_numbers	// 길이를 알 경우 이렇게도 가능
```



```python
from requests import get
from bs4 import BeautifulSoup

base_url = "https://weworkremotely.com/remote-jobs/search?term="
search_term = "python"

response = get(f"{base_url}{search_term}")

if response.status_code != 200:
    print("Can't request website")
else:
	soup = BeautifulSoup(response.text, "html.parser")
    jobs = print(soup.find_all('section', class_="jobs"))
    for job_section in jobs:
        job_posts = job_section.find_all('li')
        job_posts.pop(-1)						// 리스트의 마지막에 포함되는 view-all을 제거
        for post in job_posts:
            anchors = post.find_all('a')
            anchor = anchors[1]				// 두번째 anchor만 사용됨
            link = anchor['href']			// BeautifulSoup로 인해 Dicts처럼 바뀌기 때문에 이렇게 사용가능
            company, kind, region = anchor.find_all('span', class_="company")			// 길이를 알기 때문에 한번에 변수로 지정
            title = anchor.find('span', class_='title')
            print(company, kind, region, title)
            print("///////////////////////////////")
```



## Save Results

BeautifulSoup의 .string 메소드를 이용하면 원하는 텍스트 값만 가져올 수 있다.

```python
from requests import get
from bs4 import BeautifulSoup

base_url = "https://weworkremotely.com/remote-jobs/search?term="
search_term = "python"

response = get(f"{base_url}{search_term}")

if response.status_code != 200:
    print("Can't request website")
else:
    result = []
	soup = BeautifulSoup(response.text, "html.parser")
    jobs = print(soup.find_all('section', class_="jobs"))
    for job_section in jobs:
        job_posts = job_section.find_all('li')
        job_posts.pop(-1)						// 리스트의 마지막에 포함되는 view-all을 제거
        for post in job_posts:
            anchors = post.find_all('a')
            anchor = anchors[1]				// 두번째 anchor만 사용됨
            link = anchor['href']			// BeautifulSoup로 인해 Dicts처럼 바뀌기 때문에 이렇게 사용가능
            company, kind, region = anchor.find_all('span', class_="company")			// 길이를 알기 때문에 한번에 변수로 지정
            title = anchor.find('span', class_='title')
            job_data = {
                'company': company.string,
                'region' : region.string,
                'position' : title.string
            }
            result.append(job_data)
for result int results:
    print(result)
    print("////////////////////")
```

