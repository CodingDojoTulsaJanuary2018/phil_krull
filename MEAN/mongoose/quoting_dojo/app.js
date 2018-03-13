const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const path = require('path');
const PORT = 8888;

const app = express();

// set up the MongoDB connection
mongoose.connect('mongodb://localhost/march_quoting_dojo');

const QuoteSchema = new mongoose.Schema({
    name: String,
    quote: String
}, {timestamps: true, strict: false});

mongoose.model('Quote', QuoteSchema);

// expose the schema to the scope of page
const Quote = mongoose.model('Quote');

app.use(express.static(path.join(__dirname, './static/')));
app.use(bodyParser.urlencoded({extend: true}));

app.set('views', path.join(__dirname, './views/'));
app.set('view engine', 'ejs');

app.get('/', function(req, res){
    res.render('index');
    // console.log('this in a callback function', this);
})

app.get('/quotes', function(req, res){
    const quotes = [
        {name: 'Rob', quote: 'dayligth savings this week'},
        {name: 'Michael', quote: 'Jesus is amazing'},
        {name: 'Gabrielle', quote: 'while (!(succeed = try()){}!'}
    ]
    Quote.find({}).sort('-createdAt').exec(function(err, _quotes){
        if(err){
            console.log('something went wrong');
        } else {
            console.log(_quotes[_quotes.length-1].createdAt);
            res.render('success', {all_quotes: _quotes});
        }
    })
})

app.post('/quotes', (req, res)=>{
    // console.log('this in a arrow function', this);
    // create the quote
    let quote = new Quote()

    quote.name = req.body.name;
    quote.quote = req.body.quote;
    quote.age = 21;

    quote.save(function(err){
        if(err){
            console.log('something went wrong');
            res.redirect('/')
        } else {
            // successfully save quote
            console.log('created a quote')
            res.redirect('/quotes');
        }
    })
    // req.body.age = 21;

    // Quote.create(req.body, function(err, quote){
    //     if(err){
    //         console.log(err);
    //         res.redirect('/');
    //     } else {
    //         console.log(quote);
    //         res.redirect('/quotes');
    //     }
    // });

    console.log('quote');
})

app.listen(PORT, function() {
    console.log(`listening on port: ${PORT}`);
})