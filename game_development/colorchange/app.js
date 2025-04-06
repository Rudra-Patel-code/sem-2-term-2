setInterval(() => {
    getColor();
}, 3000);

const getColor = () => {
    const randomNumber = Math.floor(Math.random() * 16677215);
    const randomCode = "#" + randomNumber.toString(16);
    document.body.style.backgroundColor = randomCode;
    document.getElementById("color-code").innerText = randomCode;

    navigator.clipboard.writeText(randomCode);
};
getColor();
