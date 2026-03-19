var getTriangle = function (base, height) {
  return (base * height) / 2;
};

console.log('삼각형의 면적: ' + getTriangle(2, 5));

const getT = (base, height) => {
  return (base * height) / 2;
};

console.log('삼각형의 면적(arrow): ' + getT(2, 5));
