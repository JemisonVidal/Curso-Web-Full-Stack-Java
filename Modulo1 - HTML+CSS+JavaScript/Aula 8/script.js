let h1 = document.getElementById("id");

h1.addEventListener("click", () => alert("teste"));

setTimeout(() => {
  h1.removeEventListener("click", () => alert("teste"));
}, 1000)