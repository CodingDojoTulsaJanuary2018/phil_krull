from flask import Flask, render_template, request, redirect, flash, session
from mysqlconnection import MySQLConnector
import os, binascii # include this at the top of your file
import md5 # imports the md5 module to generate a hash




app = Flask(__name__)
app.secret_key = 'my super secret key'
mysql = MySQLConnector(app, 'feb_login_reg')

import re
# create a regular expression object that we can use run operations on
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/register', methods=['post'])
def register():
    print request.form
    error = []
    # validations
    #     1. First Name - letters only, at least 2 characters and that it was submitted
    if not request.form['first_name'].isalpha():
        error.append("first name must be letters only")
    if not request.form['first_name']:
        error.append("first name must have a value")
    if len(request.form['first_name']) < 2:
        error.append("first name must have 2 char")
    # 2. Last Name - letters only, at least 2 characters and that it was submitted
    if not request.form['last_name'].isalpha():
        error.append("last name must be letters only")
    if not request.form['last_name']:
        error.append("last name must have a value")
    if  len(request.form['last_name']) < 2:
        error.append("last name must have 2 char")
    # 3. Email - Valid Email format, and that it was submitted
    if not request.form['email']:
        error.append('email is required')
    if not EMAIL_REGEX.match(request.form['email']):
        error.append('valid email reqiured')
    # 4. Password - at least 8 characters, and that it was submitted
    if not request.form['password'] and len(request.form['password']) > 7:
        error.append('password must be at least 8 char')
    # 5. Password Confirmation - matches password
    if not request.form['password'] == request.form['password_confirmation']:
        error.append('password must match')

    # check for unique email
    query = 'SELECT * FROM users WHERE email = :email'
    data = {
        'email': request.form['email']
    }
    if mysql.query_db(query, data):
        error.append('email already in use')

    print error
    #check the errors list

    if error:
        for e in error:
            flash(e)
        return redirect('/')
    else:
        # passed validation, send to db
        salt = binascii.b2a_hex(os.urandom(5))
        print len(salt)
    # encrypt the password we provided as 32 character string
        hashed_password = md5.new(request.form['password'] + salt).hexdigest()
        print hashed_password #this will show you the hashed value
    # 5f4dcc3b5aa765d61d8327deb882cf99 -> nice!

        query='INSERT INTO users (first_name, last_name, email, password, salt, updated_at, created_at) VALUES (:first_name, :last_name, :email, :password, :salt, NOW(), NOW())'
        data = {
            'first_name': request.form['first_name'],
            'last_name': request.form['last_name'],
            'email': request.form['email'],
            'password': hashed_password,
            'salt': salt
        }
        user_id = mysql.query_db(query, data)
        session['user_id'] = user_id
        return redirect('/success')


    # if success go to success
    #else if register errors

@app.route('/login', methods=['post'])
def login():
    # find user
    query = 'SELECT * FROM users WHERE email = :email'
    data = {
        'email': request.form['email']
    }
    user = mysql.query_db(query, data)

    if user:
        # check for password match
        # match true
        password = request.form['password']
        encrypted_password = md5.new(password + user[0]['salt']).hexdigest()
        if user[0]['password'] == encrypted_password:
            session['user_id'] = user[0]['id']
            return redirect('/success')
        # match false
        else:
            flash('invalid email password combo')
            return redirect('/')
    # no user
    else:
        flash('invalid email')
        return redirect('/')

@app.route('/success')
def success():
    try:
        session['user_id']
        return render_template('success.html')
    except KeyError:
        return redirect('/')


@app.route('/logout', methods=['post'])
def logout():
    session.clear()
    return redirect('/')

app.run(debug = True)