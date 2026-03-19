const fs = require('fs');

// readdir(경로[, 옵션], 콜백)

fs.readdir('./', (err, files) => {
  if (err) {
    console.log(err);
    return;
  }
  console.log(files);
});
