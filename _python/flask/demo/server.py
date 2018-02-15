from flask import Flask, render_template, redirect, request
app = Flask(__name__)

@app.route('/')
# .route()
def index():
    return render_template('index.html')
    # render_template(string of the html page you want to be rendered, variable assignment(key = value))

@app.route('/hello')
def hello():
    print "in hello method"
    return redirect('/success')
    # redirect(string of the url patternn you want to match)

@app.route('/success', methods = ["GET", "POST"])
@app.route('/success/<x>')
def success(x="i don't know"):
    # x = "i don't know"
    print request.method
    print request.form['first_name']
    print request.args

    return render_template('success.html', y = x)

app.run(debug=True)