const fs = require('fs');

const ex = fs.readFileSync('./example.txt', 'utf-8');
console.log('동기 함수로 처리');
console.log(ex);

fs.readFile('./example.txt', 'utf-8', (err, ex2) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log('비동기 함수로 처리');
  console.log(ex2);
});
