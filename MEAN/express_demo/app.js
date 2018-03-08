// make access to express
const express = require('express');
// set app to the result of the express function
const app = express();
// console.log(app);

// access to os directory path
const path = require('path');
console.log(path);

// aides with post data interpertation
const bodyParser = require('body-parser');

// allows json like access to post data from the form
app.use(bodyParser.urlencoded({extended: true}));
console.log(__dirname);
// pointing the static request to the static folder
app.use(express.static(__dirname + "./static"));

// setting our view engine to render our .ejs (html)
app.set('views', path.join(__dirname, './views'));
// telling express, that our template rendering is going to be the ejs module, js ejs === flask jinja2; going to be replaced with angular
app.set('view engine', 'ejs');


//-------------- ^^^^^^^^^^ -------- setting the quidelines for the project --------------
// the first param of the callback will be the request, 2nd is the response
app.get('/', function(req, res){
    res.render('index')
})

app.post('/users', function(req, res) {
    // using body-parser, the form data will be within the body of the request
    console.log(req.body);
    res.redirect('/');
})

// starting the server
app.listen(8000, function(){
    console.log("Listening on port 8000");
})