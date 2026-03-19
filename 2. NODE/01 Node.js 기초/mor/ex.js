consthttp = require('http');

constserver = http.createServer((req, res) => {
  res.end('Hello Node');
});

server.listen(3000);
