const quotes = require('./../controllers/quotes');

module.exports = function(app) {
    // call controller method and give the request and response to the method
    app.get('/', quotes.root);
    app.post('/quotes', quotes.create);
    app.get('/quotes', quotes.index);
    app.post('/quotes/like/:id', quotes.update);
        
}