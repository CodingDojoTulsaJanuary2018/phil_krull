// imports here


mongoose.connect('mongodb://localhost/quoting_dojo');

const quoteSchema = new mongoose.Schema({
    name: String,
    quote: String
});

const Quote = mongoose.model('quotes', quoteSchema);

app.get('/quotes', function(req, res) {
    Quote.find({}, function(err, quotes) {
        if (err) { console.log(err); }
        res.render('quotes', { quotes: quotes });
    });
    console.log('Finding quotes');
});

app.post('/quotes', function(req, res) {
    Quote.create(req.body, function(err, result) {
        if (err) { console.log(err); }
    res.redirect('/quotes');
    });
});

// app listening