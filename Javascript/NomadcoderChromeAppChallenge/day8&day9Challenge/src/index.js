const playButton = document.querySelector('#guessForm input[type="submit"]');
const maxValue = document.querySelector("#generateForm input");
const userGuess = document.querySelector("#guessNumber");
const userOutput = document.querySelector("#userOutput");
const machineOutput = document.querySelector("#machineOutput");
const result = document.querySelector("#result");

function onPlayButtonClick(event) {
  event.preventDefault();

  if (maxValue.value === "" || userGuess.value === "") {
    alert("오류 : 정확한 값을 입력하세요.");
  } else if (maxValue.value < 0) {
    alert("오류 : 음수는 허용되지 않습니다.");
  } else {
    printResult(userGuess, maxValue);
  }
}

function printResult(userGuess, maxValue) {
  const maxValueInt = parseInt(maxValue.value);
  const userValueInt = parseInt(userGuess.value);
  const machineValue = Math.floor(Math.random() * (maxValueInt + 1));

  userOutput.innerText = `You Chose: ${userValueInt}`;
  machineOutput.innerText = `the machine Chose: ${machineValue}`;
  if (userValueInt === machineValue) {
    result.innerText = "You won!";
  } else {
    result.innerText = "You lost!";
  }
}

playButton.addEventListener("click", onPlayButtonClick);
