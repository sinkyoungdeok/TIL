const http = require('http');
const routes = require('./routes');

/*
const server = http.createServer(function(req, res) { // 익명 함수
    console.log(req);
}); 
*/

console.log(routes.someText);

const server = http.createServer(routes.handler);

server.listen(3000);