import "./style.css";

let sizeOfWidth = window.innerWidth;
const maxSizeOfWidth = window.outerWidth;

function handleResizeWindow() {
  sizeOfWidth = window.innerWidth;
  if (sizeOfWidth < maxSizeOfWidth * 0.4) {
    document.body.classList.add("aqua");
    document.body.classList.remove("blueviolet");
    document.body.classList.remove("goldenrod");
  } else if (sizeOfWidth < maxSizeOfWidth * 0.7) {
    document.body.classList.remove("aqua");
    document.body.classList.remove("goldenrod");
    document.body.classList.add("blueviolet");
  } else {
    document.body.classList.remove("aqua");
    document.body.classList.remove("blueviolet");
    document.body.classList.add("goldenrod");
  }
}
window.addEventListener("resize", handleResizeWindow);
