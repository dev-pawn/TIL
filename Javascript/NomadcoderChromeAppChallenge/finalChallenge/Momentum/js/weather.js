const API_KEY = "673f11dfbbe46a6cc885568579439e7c"

function onGeoOk(position) {
    const lat = position.coords.latitude;
    const lng = position.coords.longitude;
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lng}&appid=${API_KEY}&units=metric`;
    fetch(url)
    .then(response => response.json())
    .then(date => {
        const city = document.querySelector("#weather span:first-child");
        const temperature = document.querySelector("#weather span:nth-child(2)");
        const weather = document.querySelector("#weather span:last-child");
        city.innerText = `${date.name}, `;
        weather.innerText = date.weather[0].main;
        temperature.innerText = `${Math.floor(date.main.temp * 10) / 10} °C, `;
   });
    
}

function onGeoErr() {
    alert("Can't find you. No weather for you")
}

navigator.geolocation.getCurrentPosition(onGeoOk, onGeoErr)