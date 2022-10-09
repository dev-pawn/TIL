from flask import Flask, render_template, request

app = Flask("JobScrapper")
app = Flask(__name__, template_folder='templates')


@app.route("/")
def home():
    return render_template("home.html")


@app.route("/search")
def search():
    keyword = request.args.get("keyword")
    return render_template("search.html", keyword=keyword)


app.run("0.0.0.0")
