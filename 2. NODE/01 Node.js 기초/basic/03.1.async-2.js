function dA() {
  console.log('A');
}

function dB(callback) {
  setTimeout(() => {
    console.log('B');
    callback();
  }, 2000);
}

function dC() {
  console.log('C');
}

dA();
dB(dC);
