var proxy = require("express-http-proxy");
const path = require('path')
const express = require('express')
var app = new (require('express'))();
var port = 3000;
app.use(express.static(path.join(__dirname, 'static')));
// const API_HOST = 'http://192.168.49.13:8080';
const API_HOST = 'http://localhost:8080';

var apiProxy = proxy(API_HOST, {
    forwardPath: function (req, res) {
        var url = String(req._parsedUrl.path)
        url = url.replace("/api", "")
        console.log(`${req.originalUrl}forward <->${url}`);
        return url
    }
});

app.get("/", function (req, res) {
    res.sendFile(__dirname + '/index.html')
});
app.use("/api/*", apiProxy);

app.listen(port, function (error) {
    if (error) {
        console.error(error)
    } else {
        console.info("==> 🌎  Listening on port %s. Open up http://localhost:%s/ in your browser.", port, port)
    }
})
