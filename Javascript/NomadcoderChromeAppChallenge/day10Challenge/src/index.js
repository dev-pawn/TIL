const clockTitle = document.querySelector(".js-clock");

function displayDday() {
  let crismasDate = new Date(new Date().getFullYear(), 11, 25);
  const currentDate = new Date();

  if (currentDate > crismasDate) {
    crismasDate = new Date(new Date().getFullYear() + 1, 11, 25);
  }

  const diffrentDate = crismasDate - currentDate;
  const day = String(Math.floor(diffrentDate / (1000 * 60 * 60 * 24))).padStart(
    3,
    "0"
  );
  const hours = String(
    Math.floor((diffrentDate % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60))
  ).padStart(2, "0");
  const minutes = String(
    Math.floor((diffrentDate % (1000 * 60 * 60)) / (1000 * 60))
  ).padStart(2, "0");
  const seconds = String(
    Math.floor((diffrentDate % (1000 * 60)) / 1000)
  ).padStart(2, "0");
  clockTitle.innerText = `${day}d ${hours}h ${minutes}m ${seconds}s`;
}

setInterval(displayDday, 1000);
