// <⚠️ DONT DELETE THIS ⚠️>
import "./styles.css";
const colors = ["#1abc9c", "#3498db", "#9b59b6", "#f39c12", "#e74c3c"];
// <⚠️ /DONT DELETE THIS ⚠️>

/*
✅ The text of the title should change when the mouse is on top of it.
✅ The text of the title should change when the mouse is leaves it.
✅ When the window is resized the title should change.
✅ On right click the title should also change.
✅ The colors of the title should come from a color from the colors array.
✅ DO NOT CHANGE .css, or .html files.
✅ ALL function handlers should be INSIDE of "superEventHandler"
*/
const superEventHandler = {
  handleTextEnter: () => {
    text.style.color = colors[0];
    text.innerText = "The mouse is here!";
  },
  handleTextLeave: () => {
    text.style.color = colors[1];
    text.innerText = "The mouse is gone!";
  },
  handleWindowResize: () => {
    text.style.color = colors[2];
    text.innerText = "You just resized!";
  },
  handleMouseRightClick: () => {
    text.style.color = colors[4];
    text.innerText = "That was right click!";
  }
};

const text = document.querySelector("h2");
const windows = window;

text.addEventListener("mouseenter", superEventHandler.handleTextEnter);
text.addEventListener("mouseleave", superEventHandler.handleTextLeave);
windows.addEventListener("resize", superEventHandler.handleWindowResize);
windows.addEventListener(
  "contextmenu",
  superEventHandler.handleMouseRightClick
);
