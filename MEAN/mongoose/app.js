// imports here

// this will connect and create/ connect to the db
mongoose.connect('mongodb://localhost/quoting_dojo');

// using mongoose Schema to create a model "class" to make our documents upon insert
const quoteSchema = new mongoose.Schema({
    name: String,
    quote: String
});

// add quoteSchema to the available models as a collection, and expose it to the file(Quote)
const Quote = mongoose.model('quotes', quoteSchema);

app.get('/quotes', function(req, res) {
    Quote.find({}, function(err, quotes) {
        if (err) { console.log(err); }
        console.log(quotes);
        res.render('quotes', { quotes: quotes });
    });
    console.log('Finding quotes');
    }
// a return outside of the callback == bad(return before the request is finished)
);

app.post('/quotes', function(req, res) {
    Quote.create(req.body, function(err, result) {
        if (err) { console.log(err); }
    res.redirect('/quotes');
    });
});

// app listening