const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const path = require('path');

const app = express();

/// setting up the static requirements
app.use(bodyParser.urlencoded({ extended:true }));
app.use(express.static(path.join(__dirname, './client/static')));

// setting the view engine
app.set('views', path.join(__dirname, './client/views'));
app.set('view engine', 'ejs');

// require the mongoose and routes .js files
require('./server/config/mongoose.js');
const routes = require('./server/config/routes.js');
routes(app);

// start our server
app.listen(8888, ()=>{
  console.log('listening on port 8888');
})
