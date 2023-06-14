window.addEventListener("load", function() {
    var list = document.querySelectorAll("#displayBox > div");
    for (var i = 0; i < list.length; i++) {
        console.log(list[i])
        var randomColor = Math.floor(Math.random()*16777215).toString(16);
        list[i].style.color = "#" + randomColor;
    }
});