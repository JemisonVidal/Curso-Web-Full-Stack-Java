Exercício

Criar uma interface chamada Voador. Nessa interface, definir o método voar,
com a seguinte assinatura:
public void voar()

Em seguida, criar as seguintes classes e fazer com que cada uma implement a interface Voador. Definir também o comportamento do método voar em cada caso: 

● Pato: 
  O pato tem uma energia. Ele começa com 100 pontos de energia, e cada
    vez que voa, o pato perde 5 pontos de energia, seu metodo deve imprimir na tela “Estou
    voando como um pato”, caso ainda tenha energia suficiente e “Não tenho energia
    suficiente para voar” caso não tenha mais energia.
    
● Avião: 
  O avião tem horas de voo. Cada vez que o avião voa, soma 13h de
    voo e imprime na tela “Estou voando como um avião, e
    tenho x horas de voo”, onde em x deve ser exibido a
    quantidade total de horas que esse avião já esteve em
    voo.
    
● Super-homem: 
  O super-homem tem experiência. Cada vez que o
    super-homem voa, a experiência dele aumenta 3 unidades, e imprime na
    tela “Estou voando como um campeão”
    Criar uma classe TorreDeControle contendo uma lista de voadores. 
    
 Em seguida, criar dois métodos na classe TorreDeControle: 

●  public void voemTodos(). Esse método será encarregado de percorrer a
 lista de voadores e fazer com que eles voem. Além disso, a sua classe deve ter um array de Voador, chamado voadores, que deve ser recebido no construtor.
 
 Criar na classe Main:   
 ● um pato  
 ● um avião  
 ● o super-homem  
 ● uma torre de controle
 
Adicionar o pato, o avião e o super-homem à torre de controle. Pedir para a torre
de controle fazer todos os voadores voarem. Observar o comportamento
Chame Alguma vezes e observe o resultado. 
