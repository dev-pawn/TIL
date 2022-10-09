from requests import get
from bs4 import BeautifulSoup

def extract_wwr_jobs(keyword):
  url = f"https://weworkremotely.com/remote-jobs/search?term={keyword}"
  request = get(url)

  if request.status_code == 200:
    results = []
    soup = BeautifulSoup(request.text, "html.parser")
    jobs = soup.find_all('section', class_="jobs")
    for job_section in jobs:
      job_posts = job_section.find_all('li')
      job_posts.pop(-1)
      for post in job_posts:
        anchors = post.find_all('a')
        anchor = anchors[1]
        link = anchor['href']
        spans = anchor.find_all('span', class_="company")
        if len(spans) == 3:
          company, empty, region = spans
        elif len(spans) == 2:
          company, region = spans
        title = anchor.find('span', class_='title')
        if company.string is None:
          print("Check None")
          company = "Empty"
        else:
          company = company.string
        if region.string is None:
          print("Check None")
          region = "Empty"
        else:
          region = region.string
        if title.string is None:
          print("Check None")
          title = "Empty"
        else:
          title = title.string
        job_data = {
          'link': f"https://weworkremotely.com{link}",
          'company': company.replace(",", " "),
          'location': region.replace(",", " "),
          'position': title.replace(",", " ")
        }
        results.append(job_data)
    return results
  else:
    print(f"ERROR : status_code{request.status_code}")