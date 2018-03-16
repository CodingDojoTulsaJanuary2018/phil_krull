const express = require('express');
const path = require('path');
const PORT = 8888;

const app = express();

app.use(express.static(path.join(__dirname, './public/dist')));

app.all("*", (req,res,next) => {
    res.sendFile(path.resolve("./public/dist/index.html"))
});

app.listen(PORT, ()=>{
    console.log(`Listening on PORT: ${PORT}!`);
})