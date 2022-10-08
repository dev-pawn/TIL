# Day9 & Day13

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



## Refactor

indeed라는 채용사이트도 검색이 가능하게 하기 위해

기존에 작성한 코드를 extractors폴더 안에 wwr.py로 저장 후 리팩토링



wwr.py

```python
from requests import get
from bs4 import BeautifulSoup

def extract_wwr_jobs(keyword):
    base_url = "https://weworkremotely.com/remote-jobs/search?term="
    response = get(f"{base_url}{keyword}")

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
    return results
```



main.py

```python
from requests import get
from bs4 import BeautifulSoup
from extractors.wwr import extract_wwr_jobs

```



## Recursive

find_all로 list를 찾으면 하위에 모든 li까지 찾는다. 그걸 막기 위해 recursive=False를 사용



main.py

```python
from requests import get
from bs4 import BeautifulSoup
from extractors.wwr import extract_wwr_jobs

if response.status_code != 200:
    print("Cant request page")
else:
    soup = BeautifulSoup(response.text, "html.parser")
    job_list = soup.find("ul", class_="jobsearch-ResultsList")
    jobs = job_list.find_all('li', recursive=False)
    print(job)
    print("///////")
```





## Indeed 403 Fix

Refactor에서 작성한 코드가 indeed 사이트의 봇 감지 기능에 막히게 됨.

그래서 우리는 Selenium을 이용해서 실제 브라우저를 실행하고 데이터를 받아와야 함\



main.py

```python
from selenium import webdriver
from selenium.webdriver.chrome.options import Options

### replit.com 에서 Selenium을 실행하기 위한 코드
options = Options()
options.add_argument("--no-sandbox")
options.add_argument("--disable-dev-hm-usage")
###

browser = webdriver.Chrome(options=options)

browser.get("https://www.indeed.com/jobs?q=python&limit=50")
print(browser.page_source)
```



## None



main.py

```python
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from bs4 import BeautfulSoup
### replit.com 에서 Selenium을 실행하기 위한 코드
options = Options()
options.add_argument("--no-sandbox")
options.add_argument("--disable-dev-hm-usage")
###

browser = webdriver.Chrome(options=options)

browser.get("https://www.indeed.com/jobs?q=python&limit=50")
soup = BeautifulSoup(browser.page_source, "html.parser")

if response.status_code != 200:
    print("Cant request page")
else:
    soup = BeautifulSoup(response.text, "html.parser")
    job_list = soup.find("ul", class_="jobsearch-ResultsList")
    jobs = job_list.find_all('li', recursive=False)
    print(job)
    print("///////")
```

