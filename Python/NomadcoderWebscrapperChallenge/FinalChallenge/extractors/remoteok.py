from bs4 import BeautifulSoup
import requests


def extract_remoteok_jobs(keyword):
    url = f"https://remoteok.com/remote-{keyword}-jobs"
    request = requests.get(url, headers={"User-Agent": "Kimchi"})
    results = []
    if request.status_code == 200:
        soup = BeautifulSoup(request.text, "html.parser")
        jobs = soup.find_all("tr", class_="job")
        for job in jobs:
            anchor = job.find("a", itemprop="url")
            link = anchor['href']
            company = job.find("h3", itemprop="name")
            position = job.find("h2", itemprop="title")
            location = job.find("div", class_="location")
            if company and position and location:
                job = {
                    'link': f"https://remoteok.com{link}",
                    'company': company.string.strip(),
                    'position': position.string.strip(),
                    'location': location.string.strip()
                }
                results.append(job)
    else:
        print("Can't get jobs.")
    return results
