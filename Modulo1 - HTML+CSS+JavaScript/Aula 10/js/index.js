const elemento1 = $("#primeiro");
$("#primeiro").addClass("primeiro");
elemento1.removeClass("primeiro")
elemento1.css("background-color", "blue")
elemento1.hide();
elemento1.show();
elemento1.append("<h2>Titulo append</h2>")
elemento1.prepend("<h2>Titulo prepend</h2>")
elemento1.html("<h2>Titulo Tag HTML</h2>")
//elemento1.text("<h2>Titulo Text</h2>")
elemento1.before("<h2>Titulo before</h2>")
elemento1.after("<h2>Titulo after</h2>")
elemento1.wrap("<h2>Titulo wrap</h2>")
elemento1.attr("id", "setandoId")
//elemento1.empty()
//elemento1.remove()
function alerta() {
  alert("Clicou")
}
elemento1.on("click", alerta)
//elemento1.on("mouseover", () => alert("mouseover"))
elemento1.off("click", alerta)
elemento1.one("click", alerta)
//elemento1.on("mouseleave", () => alert("mouseleave"))
//elemento1.off()

//click, mouseover, mousemove, change, input, blur, focus, dblick


const buttonOpen = $("#button");
buttonOpen.on("click", () => {
  const urlImg = 'https://www.farinspace.com/wp-content/uploads/jquery_200x200.jpg'

  if (buttonOpen[0].innerText === 'Show') {
    buttonOpen.after(`<img src=${urlImg} alt="" id="img">`)
    buttonOpen[0].innerText = 'Hide';
  } else {
    const buttonClose = $("#img");
    buttonClose.remove();
    buttonOpen[0].innerText = 'Show';
  }
});


const button2 = $("#button2");
button2.on("click", () => {
  button2.animate({ width: '250px' });
  button2.animate({ height: '250px' });
  button2.animate({ width: '100px' });
  button2.animate({ height: '22px' });
})






