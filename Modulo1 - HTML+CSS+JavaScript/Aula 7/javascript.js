//1.	Crie uma função que recebe um número e verifica se ele é par ou ímpar.
const imparPar = (n) => n % 2 === 0 ? "par" : "impar";
imparPar(2);

//2.	Crie uma arrow function que receba um número e verifique se é primo.
const primo = (n) => {
  for (let i = 2; i < n; i++)
    if (n % i === 0) {
      return false
    };
  return n > 1;
}
primo(2);

//3. Crie uma função que imprime de 10 até 1 e 
//depois imprime na tela “feliz ano novo” através de uma callback
function callBack() {
  return console.log("feliz ano novo")
}
function anoNovo(callBack) {
  for (let i = 10; i > 0; i--) {
    console.log(i);
  }
  callBack();
}
anoNovo(callBack);

//4.	Faça o mesmo utilizando Promise com concatenação de then
const promise = () => new Promise((resolve, reject) => {
  for (let i = 10; i > 0; i--) {
    console.log(i);
  }
  resolve();
});
promise().then(console.log("Feliz ano novo"));

//5.	Agora repita a função utilizando o método async/await
//Obs: a função abaixo, não tem necessidade da chamada await dentro dela, visto que nao teria efeito,
// porém na chamada da mesma é utilizando o await para que não seja retornado uma promisse, Era isso que v´cs queriam ?
const asyncAwait = async () => {
  for (let i = 10; i > 0; i--) {
    console.log(i);
  }
  console.log('Feliz ano novo');
}
await asyncAwait();

//6.	Crie um array com as seguintes notas [5.3, 4.7, 8.5, 7.1, 6.4, 9.2, 9.8, 5.5, 7.4, 7.0],
// construa uma função para imprimir apenas as notas acima de 7
const notas = [5.3, 4.7, 8.5, 7.1, 6.4, 9.2, 9.8, 5.5, 7.4, 7.0];
const acimaDeSete = (notas) => console.log(notas.filter(nota => nota > 7));
acimaDeSete(notas);

//7.	Crie um array de objetos onde cada objeto será um produto de supermercado e 
//terá o nome do produto e o seu respectivo preço, agora construa uma função que 
//some todos os valores e te devolva o total.
const produtos =
  [{
    nome: "produto1",
    preco: 10.00
  },
  {
    nome: "produto2",
    preco: 20.00
  },
  {
    nome: "produto4",
    preco: 30.00
  }];
const sum = (produtos) => produtos.map(produto => produto.preco).reduce((acc, current) => acc + current);
sum(produtos);

//8.	Em uma escola ficou definido que os alunos do 8º ano terão aulas de história 
//e os alunos do 9º terão aulas de física às quartas-feiras. Você deve criar uma 
//função que receba um array de objetos contendo nome e série de cada aluno e 
//atribua a sua respectiva disciplina da quarta-feira. (O array de alunos deve 
//ser criado como você desejar contanto que contenha pelo menos 5 alunos).
const alunos =
  [{
    nome: "jemison",
    serie: 8
  },
  {
    nome: "mario",
    serie: 9
  },
  {
    nome: "gustavo",
    serie: 8
  },
  {
    nome: "fulano",
    serie: 9
  },
  {
    nome: "deltrano",
    serie: 8
  },
  {
    nome: "zé",
    serie: 9
  }];

const setDiciplina = (alunos) => {
  return alunos.map(aluno => ({
    nome: aluno.nome,
    serie: aluno.serie,
    diciplina: aluno.serie === 8 ? "história" : "física"
  }));
}
setDiciplina(alunos)