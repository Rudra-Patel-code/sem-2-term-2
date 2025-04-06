document.addEventListener("keydown", (event) => {
    event.preventDefault();
    if (event.key === "ArrowLeft") {
        moveLeft();
    }
    if (event.key === "ArrowRight") {
        moveRight();
    }
});
var character = document.getElementById("character");
function moveLeft() {
    let top = parseInt(
        window.getComputedStyle(character).getPropertyValue("top")
    );
    top -= 100;
    if (top >= 0) {
        character.style.top = top + "px";
    }
}

function moveRight() {
    let top = parseInt(
        window.getComputedStyle(character).getPropertyValue("top")
    );
    top += 100;
    if (top < 300) {
        character.style.top = top + "px";
    }
}

var block = document.getElementById("block");
var counter = 0;

block.addEventListener("animationiteration", () => {
    var random = Math.floor(Math.random() * 3);
    block.style.top = random * 100 + "px";
    counter++;
});

setInterval(function () {
    var characterleft = parseInt(
        window.getComputedStyle(character).getPropertyValue("top")
    );
    var blockleft = parseInt(
        window.getComputedStyle(block).getPropertyValue("top")
    );
    var blocktop = parseInt(
        window.getComputedStyle(block).getPropertyValue("left")
    );
    if (characterleft == blockleft && blocktop < 500 && blocktop > 300) {
        alert("Game Over. Score: " + counter);
        block.style.animation = "none";
        window.location.reload();
    }
}, 1);
