from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
# replit.com 에서 Selenium을 실행하기 위한 코드
options = webdriver.ChromeOptions()
options.add_experimental_option('excludeSwitches', ['enable-logging'])
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
    results = []
    print("Found", pages, "pages")
    for page in range(pages):
        final_url = f"https://kr.indeed.com/jobs?q={keyword}&start={page*10}"
        browser.get(final_url)
        print("Requesting", final_url)
        soup = BeautifulSoup(browser.page_source, "html.parser")
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
                    'company': company.string.replace(",", " "),
                    'location': location.string.replace(",", " "),
                    'position': title.replace(",", " ")
                }
                results.append(job_data)
    return results
