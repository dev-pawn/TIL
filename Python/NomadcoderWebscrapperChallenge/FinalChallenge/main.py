from flask import Flask, render_template, request, redirect
from extractors.remoteok import extract_remoteok_jobs
from extractors.wwr import extract_wwr_jobs

app = Flask("JobScrapper")
app = Flask(__name__, template_folder='templates')

db = {}


@app.route("/")
def home():
    return render_template("home.html")


@app.route("/search")
def search():
    keyword = request.args.get("keyword")
    if (keyword == "") or (keyword == None):
        return redirect("/")
    if keyword in db:
        jobs = db[keyword]
    else:
        print("pass if")
        remoteok = extract_remoteok_jobs(keyword)
        wwr = extract_wwr_jobs(keyword)
        jobs = remoteok + wwr
        db[keyword] = jobs
    return render_template("search.html", keyword=keyword, jobs=jobs)


app.run("0.0.0.0")
