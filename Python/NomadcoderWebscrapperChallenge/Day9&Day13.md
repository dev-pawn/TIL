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

None은 C언어에서의 NULL과 같다.

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
	for job in jobs:
 	 	zone = job.find("div", class_="mosaic-zone")
  	if zone == None:
    	print("job li")
```



## Select



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
results = []
job_list = soup.find("ul", class_="jobsearch-ResultsList")
jobs = job_list.find_all('li', recursive=False)
for job in jobs:
  zone = job.find("div", class_="mosaic-zone")
  if zone == None:
    anchor = job.select_one("h2 a")
    title = anchor['aria-label']
    link = anchor['href']
    company = job.find("span", class_="companyName")
    location = job.find("div", class_="companyLocation")
    job_data = {
      'link' : f"https://kr.indeed.com{link}",
      'company' : company.string,
      'location' : location.string,
      'position' : title
    }
    results.append(job_data)
for result in results:
  print(result, "\n////////\n")
```



## Pages

채용 페이지는 처음 나타나는 하나가 아닌 여러개의 페이지로 구성되어 있으니 첫 페이지에 보이는
1~5 페이지를 추가로 스크랩하기 위한 코드를 짜자(이론상 모든 페이지를 스크랩 할 수 있지만 사이트에 과도한 요청을 보내기 때문에 여기선 지양)



main.py

```python
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
### replit.com 에서 Selenium을 실행하기 위한 코드
options = Options()
options.add_argument("--no-sandbox")
options.add_argument("--disable-dev-hm-usage")
###
browser = webdriver.Chrome(options=options)


def get_page_count(keyword):
    browser.get(f"https://kr.indeed.com/jobs?q={keyword}&limit=50")
    soup = BeautifulSoup(browser.page_source, "html.parser")
    pagination = soup.find("nav", attrs={"aria-label": "pagination"})

    if pagination == None:
        return 1
    pages = pagination.find_all("div")
    print(len(pages))


def extract_indeed_jobs(keyword):
    browser.get("https://www.indeed.com/jobs?q=python&limit=50")
    soup = BeautifulSoup(browser.page_source, "html.parser")
    results = []
    job_list = soup.find("ul", class_="jobsearch-ResultsList")
    jobs = job_list.find_all('li', recursive=False)
    for job in jobs:
        zone = job.find("div", class_="mosaic-zone")
        if zone == None:
            anchor = job.select_one("h2 a")
            title = anchor['aria-label']
            link = anchor['href']
            company = job.find("span", class_="companyName")
            location = job.find("div", class_="companyLocation")
            job_data = {
                'link': f"https://kr.indeed.com{link}",
                'company': company.string,
                'location': location.string,
                'position': title
            }
            results.append(job_data)
    for result in results:
        print(result, "\n////////\n")


get_page_count("python")
```



## Pages part Two

range()를 for문에 사용하여 페이지 수 만큼 반복하여 검색해준다.

```python
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
### replit.com 에서 Selenium을 실행하기 위한 코드
options = Options()
options.add_argument("--no-sandbox")
options.add_argument("--disable-dev-hm-usage")
###
browser = webdriver.Chrome(options=options)


def get_page_count(keyword):
    browser.get(f"https://kr.indeed.com/jobs?q={keyword}&limit=50")
    soup = BeautifulSoup(browser.page_source, "html.parser")
    pagination = soup.find("nav", attrs={"aria-label": "pagination"})

    if pagination == None:
        return 1
    pages = pagination.find_all("div")
    count = len(pages)
    if count >= 5:
      return 5
    else:
      return count


def extract_indeed_jobs(keyword):
  pages = get_page_count(keyword)
  for page in range(pages):
    browser.get("https://www.indeed.com/jobs?q=python&limit=50")
    soup = BeautifulSoup(browser.page_source, "html.parser")
    results = []
    job_list = soup.find("ul", class_="jobsearch-ResultsList")
    jobs = job_list.find_all('li', recursive=False)
    for job in jobs:
        zone = job.find("div", class_="mosaic-zone")
        if zone == None:
            anchor = job.select_one("h2 a")
            title = anchor['aria-label']
            link = anchor['href']
            company = job.find("span", class_="companyName")
            location = job.find("div", class_="companyLocation")
            job_data = {
                'link': f"https://kr.indeed.com{link}",
                'company': company.string,
                'location': location.string,
                'position': title
            }
            results.append(job_data)
    for result in results:
        print(result, "\n////////\n")
```



## Refactor

여기서부터는 셀레니움을 import하는 방법에 대한 자세한 설명이 없어 진행이 불가능하다.
replit.com에선 설정으로 무난히 실행이 가능하다. 추후 셀레니움에 대해 더 공부하고 진행하겠다.



## Write to File



```python
file =  open(f"{keyword}.csv", "w")

file.write("Position,Company,Location,URL\n")

for job in jobs:
    file.write(f"{job['position']},{job['company']},{job['location']},{job['link']}\n")
file.close()
```

