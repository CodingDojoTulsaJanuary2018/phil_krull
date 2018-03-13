function foo(a,b,c){
    if(a > 5){
        return c(b(a));
    } else {
        return b(c(a));
    }
}

var bar = foo(-2, function(a){
    var sum = 1;
    for(var i=a; i>0; i--) {
        sum += i;
    }
    return sum;
    }, function(a){
        return a + 5;
    }
)
console.log(bar);