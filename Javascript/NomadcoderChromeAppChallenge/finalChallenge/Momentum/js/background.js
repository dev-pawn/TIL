const imges = ["0.jpg", "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg"];
const chooseImges = imges[Math.floor(Math.random() * imges.length)];
const bgImage = document.createElement("img");

bgImage.src = `img/${chooseImges}`;

document.body.appendChild(bgImage);