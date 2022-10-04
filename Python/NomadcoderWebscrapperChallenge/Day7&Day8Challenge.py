from bs4 import BeautifulSoup
import requests


def extract_jobs(term):
    url = f"https://remoteok.com/remote-{term}-jobs"
    request = requests.get(url, headers={"User-Agent": "Kimchi"})
    if request.status_code == 200:
        soup = BeautifulSoup(request.text, "html.parser")
        # write your ✨magical✨ code here
        results = []
        jobs = (soup.find_all('table', id="jobsboard"))
        for job_section in jobs:
            job_posts = job_section.find_all('tr', class_="job")
            for post in job_posts:
                tds = post.find_all('td', class_="company")
                for td in tds:
                    title = td.find('h2', itemprop="title")
                    company = td.find('h3', itemprop="name")
                    location = td.find_all('div', class_="location")
                    if len(location) == 1:
                        locationforstring = td.find_all(
                            'div', class_="location")
                        location.clear()
                        location.append(locationforstring[0].string)
                    elif len(location) == 2:
                        locationforstring = td.find_all(
                            'div', class_="location")
                        location.clear()
                        location.append(locationforstring[0].string)
                        location.append(locationforstring[1].string)
                    elif len(location) == 3:
                        locationforstring = td.find_all(
                            'div', class_="location")
                        location.clear()
                        location.append(locationforstring[0].string)
                        location.append(locationforstring[1].string)
                        location.append(locationforstring[2].string)
                    elif len(location) == 4:
                        locationforstring = td.find_all(
                            'div', class_="location")
                        location.clear()
                        location.append(locationforstring[0].string)
                        location.append(locationforstring[1].string)
                        location.append(locationforstring[2].string)
                        location.append(locationforstring[3].string)
                    job_data = {
                        'title': (title.string).strip("\n"),
                        'company': (company.string).strip("\n "),
                        'location_and_pay': location,
                    }
                    results.append(job_data)
        for result in results:
            print(result)
            print("/////////////////////////////////////////////")

    else:
        print("Can't get jobs.")


extract_jobs("rust")
extract_jobs("python")
extract_jobs("golang")
extract_jobs("react")
