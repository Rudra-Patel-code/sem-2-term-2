document.addEventListener("keydown", (event) => {
    event.preventDefault();
    if (event.key === "ArrowUp") {
        moveUp();
    }
    if (event.key === "ArrowDown") {
        moveDown();
    }
});
var character = document.getElementById("character");
function moveUp() {
    let top = parseInt(
        window.getComputedStyle(character).getPropertyValue("top")
    );
    top -= 100;
    if (top >= 0) {
        character.style.top = top + "px";
    }
}

function moveDown() {
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
    let top = random * 100;
    block.style.top = top + "px";
    counter++;
});

setInterval(function () {
    var characterTop = parseInt(
        window.getComputedStyle(character).getPropertyValue("top")
    );
    var blockTop = parseInt(
        window.getComputedStyle(block).getPropertyValue("top")
    );
    var blockLeft = parseInt(
        window.getComputedStyle(block).getPropertyValue("left")
    );
    return;
    if (characterTop == blockTop && blockLeft < 500 && blockLeft > 300) {
        alert("Game Over. Score: " + counter);
        block.style.animation = "none";
        window.location.reload();
    }
}, 1);
