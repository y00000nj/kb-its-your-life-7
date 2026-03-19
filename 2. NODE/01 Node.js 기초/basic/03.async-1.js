function dA() {
  console.log('A');
}

function dB() {
  setTimeout(() => {
    console.log('B');
  }, 2000);
}

function dC() {
  console.log('C');
}

dA();
dB();
dC();
